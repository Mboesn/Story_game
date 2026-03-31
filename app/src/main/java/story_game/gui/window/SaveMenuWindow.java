package story_game.gui.window;

import java.util.Optional;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import story_game.gui.util.ButtonCustom;
import story_game.save_mechanics.SaveFile;
import story_game.save_mechanics.SaveHandler;

/**
 * This window lists all available saves, allowing to load a new one or save the
 * current one
 */
public class SaveMenuWindow {
    /**
     * Opens a save menu
     * 
     * @param mainMenuStage The stage of the main menu
     * @param type          The type of menu tosave, if loading a save file leave as
     *                      null
     */
    public void show(Stage mainMenuStage, SaveMenuType type, SaveFile saveFile) {
        final double sceneWidth = 300;
        final double sceneHeight = 500;

        final double buttonSpacing = 15;
        final double backButtonInset = 30;

        Stage stage = new Stage();
        VBox root = new VBox();
        Scene scene = new Scene(root, sceneWidth, sceneHeight);

        // TODO: add info to save

        SaveButton[] saveButtons = new SaveButton[10];
        ObservableList<Node> list = root.getChildren();

        for (int i = 0; i < 10; i++) {
            saveButtons[i] = new SaveButton("Save " + (i + 1), stage, saveFile, type, mainMenuStage);
            list.add(saveButtons[i]);
        }

        ButtonCustom back = new ButtonCustom("Back");

        back.setOnMouseClicked(e -> {
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
        // blocks all other windows till settings has been finished
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void show(Stage mainMenuStage, SaveMenuType type) {
        if (type != SaveMenuType.SAVE_GAME)
            show(mainMenuStage, type, type == SaveMenuType.LOAD_GAME ? null : new SaveFile());
        else
            System.out.println("Trying to save game but no save file provided");
    }

    private class SaveButton extends ButtonCustom {

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
        public SaveButton(String text, Stage loadSaveMenuStage, SaveFile saveFile,
                SaveMenuType type, Stage mainMenuStage) {
            super(text);
            String saveFileName = text.replaceAll("\\s+", "");
            SaveFile save = SaveHandler.loadGame(saveFileName);

            // Loader logic
            if (saveFile == null) {
                // If no save is found for a given slot disable the button
                this.setDisable(save == null);
                if (save != null) {
                    setOnMouseClicked(e -> {
                        loadSaveMenuStage.close();
                        mainMenuStage.close();
                        GameWindow gameWindow = new GameWindow();
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
                    this.setText(this.getText() + " - override save");
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

        private void saveGame(String saveFileName, Stage loadSaveMenuStage, SaveFile saveFile,
                SaveMenuType type, Stage mainMenuStage) {
            SaveHandler.saveGame(saveFile, saveFileName);
            if (type != SaveMenuType.SAVE_GAME) {
                GameWindow gameWindow = new GameWindow();
                gameWindow.show(saveFile, mainMenuStage);
                mainMenuStage.close();
            }
            loadSaveMenuStage.close();
        }
    }

    // The type of save menu to open
    public enum SaveMenuType {
        NEW_GAME,
        LOAD_GAME,
        SAVE_GAME;
    }
}
