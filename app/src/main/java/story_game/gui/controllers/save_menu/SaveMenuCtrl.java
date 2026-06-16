package story_game.gui.controllers.save_menu;

import java.util.Optional;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import story_game.gui.controllers.game.GameWindowCtrl;
import story_game.gui.util.ButtonCustom;
import story_game.gui.util.FXMLPaths;
import story_game.gui.util.PopupHandler;
import story_game.save_mechanics.SaveHandler;
import story_game.save_mechanics.save_file.SaveFile;

/**
 * This window lists all available saves, allowing to load a new one or save the
 * current one
 */
public class SaveMenuCtrl {
    public static SaveMenuType saveMenuType = SaveMenuType.LOAD_GAME;
    public static SaveFile saveFile = new SaveFile();
    @FXML
    public StackPane saveMenuPane;
    @FXML
    public GridPane saveButtons;

    private int saveCountStart = 0;

    private SaveType saveType = SaveType.REGULAR_SAVE;

    @FXML
    public void initialize() {
        updateGrid("0");
    }

    /**
     * Opens a save menu
     * 
     * @param mainMenuStage The stage of the main menu
     * @param type          The type of menu to open
     * @param saveFile      The save file to save if loading a save file leave as
     *                      null
     */
    public void show(Stage mainMenuStage, SaveMenuType type, SaveFile saveFile) {
        final double sceneWidth = 350;
        final double sceneHeight = 550;

        final double buttonSpacing = 15;
        final double backButtonInset = 30;

        final int maxSaveCount = 10;

        Stage stage = new Stage();
        VBox root = new VBox();
        Scene scene = new Scene(root, sceneWidth, sceneHeight);

        SaveButton[] saveButtons = new SaveButton[maxSaveCount];
        ObservableList<Node> list = root.getChildren();

        for (int i = 0; i < maxSaveCount; i++) {
            saveButtons[i] = new SaveButton("Save " + (i + 1), stage, saveFile, type, mainMenuStage);
            list.add(saveButtons[i]);
        }

        ButtonCustom back = ButtonCustom.createButtonCustom("Back",
                e -> {
                    if (type != SaveMenuType.SAVE_GAME)
                        mainMenuStage.show();
                    stage.close();
                });

        // Makes the back button be more down
        VBox.setMargin(back, new Insets(backButtonInset, 0, 0, 0));
        list.add(back);

        root.setSpacing(buttonSpacing);
        root.setAlignment(Pos.CENTER);
        root.setFillWidth(true);

        stage.setScene(scene);
        stage.setTitle("Load save");
        // blocks all other windows till save menu has been finished
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    /**
     * Opens a save menu (do not use this method for saving an existing file)
     * 
     * @param mainMenuStage The stage of the main menu
     * @param type          The type of menu to open
     */
    public void show(Stage mainMenuStage, SaveMenuType type) {
        if (type != SaveMenuType.SAVE_GAME)
            show(mainMenuStage, type, type == SaveMenuType.LOAD_GAME ? null : new SaveFile());
        else
            System.out.println("Trying to save game but no save file provided");
    }

    private class SaveButton extends ButtonCustom {
        private static final double minButtonLength = 300;

        /**
         * Creates a button that loads a save file when pressed
         * 
         * @param text              Name of the space file. add whitespaces according to
         *                          button name,
         *                          code will ignore when loading
         * @param loadSaveMenuStage the windows stage, used to close the window after
         *                          loading save
         * @param saveFile          Save file to save, if loading a save file leave as
         *                          null
         * @param type              Type of action to take
         * @param mainMenuStage     Stage of the main menu used to pass to game window
         *                          to open when game returns to menu
         */
        @SuppressWarnings("deprecation")
        public SaveButton(String text, Stage loadSaveMenuStage, SaveFile saveFile,
                SaveMenuType type, Stage mainMenuStage) {
            super(text);
            this.setMinWidth(minButtonLength);
            // removes whitespaces from the text
            String saveFileName = text.replaceAll("\\s+", "");
            SaveFile save = SaveHandler.loadGame(saveFileName);

            // Add current game location to the save file
            String location = "";
            if (save != null) {
                location = save.getCurrentPage().getClass().toString().replace("class story_game.text.pages.", "");
                location = location.split("\\.")[0].toLowerCase();
                switch (location) {
                    case "housescene":
                        location = "House";
                        break;
                    case "outsidescene":
                        location = "Outside";
                        break;
                    default:
                        location = "unknown";
                        break;
                }
            }

            // Loader logic
            if (saveFile == null) {
                // If no save is found for a given slot disable the button
                this.setDisable(save == null);
                if (save != null) {
                    this.setText(this.getText() + " - " + location + " - " + save.getSaveDate());
                    setOnMouseClicked(e -> {
                        loadSaveMenuStage.close();
                        mainMenuStage.close();
                        GameWindowCtrl gameWindow = new GameWindowCtrl();
                        gameWindow.show(save, mainMenuStage);
                    });
                }
            } else {
                if (save == null) {
                    this.setText(this.getText() + " - new save");
                    setOnMouseClicked(e -> {
                        saveGame(saveFileName, loadSaveMenuStage, saveFile, type, mainMenuStage);
                    });
                } else {
                    this.setText(this.getText() + " - " + location + " - " + save.getSaveDate());
                    // Throws an alert telling the user that save will be overridden
                    Alert saveConfirmationAlert = new Alert(AlertType.CONFIRMATION);
                    saveConfirmationAlert.setTitle("Are you sure?");
                    saveConfirmationAlert.setHeaderText("You are about to delete " + text);
                    saveConfirmationAlert
                            .setContentText("Deleting this save cannot be undone, do you wish to proceed?");

                    setOnMouseClicked(e -> {
                        Optional<ButtonType> isSave = saveConfirmationAlert.showAndWait();
                        if (isSave.isPresent() && isSave.get() == ButtonType.OK) {
                            saveGame(saveFileName, loadSaveMenuStage, saveFile, type, mainMenuStage);
                        }
                    });
                }
            }
        }

        /**
         * Saves a given save file
         * 
         * @param saveFileName  The name of the file to save
         * @param saveMenuStage The save menu stage
         * @param saveFile      The save file to save
         * @param type          What type of save to do (new or existing)
         * @param mainMenuStage The main menu stage
         */
        private void saveGame(String saveFileName, Stage saveMenuStage, SaveFile saveFile,
                SaveMenuType type, Stage mainMenuStage) {
            saveFile.updateSaveDate();
            SaveHandler.saveFile(saveFile, saveFileName);
            if (type != SaveMenuType.SAVE_GAME) {
                GameWindowCtrl gameWindow = new GameWindowCtrl();
                gameWindow.show(saveFile, mainMenuStage);
                mainMenuStage.close();
            }
            saveMenuStage.close();
        }
    }

    /** The type of save menu to open */
    public enum SaveMenuType {
        NEW_GAME,
        LOAD_GAME,
        SAVE_GAME;
    }

    /** The type of save to load/save to */
    public enum SaveType {
        REGULAR_SAVE("Save"),
        AUTO_SAVE("Auto Save"),
        QUICK_SAVE("Quick Save");

        private String saveName;

        private SaveType(String saveName) {
            this.saveName = saveName;
        }

        public String getSaveName() {
            return saveName;
        }
    }

    private void updateGrid(String gridButtonId) {
        switch (gridButtonId) {
            case "A":
                saveCountStart = 0;
                saveType = SaveType.AUTO_SAVE;
                break;
            case "Q":
                saveCountStart = 0;
                saveType = SaveType.QUICK_SAVE;
                break;
            default:
                saveCountStart = Integer.parseInt(gridButtonId) * saveButtons.getChildren().size();
                saveType = SaveType.REGULAR_SAVE;
                break;
        }

        String saveName = saveType.getSaveName();
        for (Node saveBtn : saveButtons.getChildren()) {
            if (saveBtn instanceof Button btn) {
                String saveButtonId = btn.getId().replaceAll("save", "");
                int saveNumber = saveCountStart + Integer.parseInt(saveButtonId);
                SaveFile save = SaveHandler.loadGame(saveName + saveNumber);
                // Add current game location to the save file\
                if (save != null) {
                    String location = save.getCurrentPage().getClass().toString()
                            .replace("class story_game.text.pages.", "");
                    location = location.split("\\.")[0].toLowerCase();
                    switch (location) {
                        case "housescene":
                            location = "House";
                            break;
                        case "outsidescene":
                            location = "Outside";
                            break;
                        default:
                            location = "unknown";
                            break;
                    }
                    btn.setText(saveName + " " + saveNumber + "\n" + location + "\n" + save.getSaveDate());
                    saveBtn.setDisable(false);
                } else {
                    btn.setText(saveName + " " + saveNumber + "\n" + "Empty save");
                    if (saveMenuType == SaveMenuType.LOAD_GAME) {
                        saveBtn.setDisable(true);
                    }
                }
            }
        }
    }

    @FXML
    public void updateGrid(ActionEvent event) {
        Button gridBtn = (Button) event.getSource();
        String gridButtonId = gridBtn.getId().replaceAll("grid", "");
        updateGrid(gridButtonId);
    }

    @FXML
    public void saveOrLoad(ActionEvent event) {
        Button saveBtn = (Button) event.getSource();
        String saveButtonId = saveBtn.getId().replaceAll("save", "");
        int saveNumber = saveCountStart + Integer.parseInt(saveButtonId);
        String saveName = saveType.getSaveName() + saveNumber;
        SaveFile buttonSaveFile = SaveHandler.loadGame(saveName);

        if (saveMenuType == SaveMenuType.LOAD_GAME) {
            System.out.println("load " + buttonSaveFile);
        } else {
            if (buttonSaveFile != null) {
                SaveOverrideConfirmationCtrl.overrideSaveFunction = () -> saveGame(saveFile, saveName);
                PopupHandler.loadPopup(FXMLPaths.SAVE_OVERRIDE_CONFIRMATION, event);
            } else {
                saveGame(saveFile, saveName);
            }
            System.out.println("save " + saveName);
        }
    }

    private void saveGame(SaveFile saveFile, String saveName) {
        saveFile.updateSaveDate();
        SaveHandler.saveFile(saveFile, saveName);
        if (saveMenuType == SaveMenuType.NEW_GAME) {
            // GameWindow gameWindow = new GameWindow();
            // gameWindow.show(saveFile, mainMenuStage);
            // mainMenuStage.close();
        }
        back();
    }

    @FXML
    public void back() {
        PopupHandler.closePopup(saveMenuPane);
    }
}
