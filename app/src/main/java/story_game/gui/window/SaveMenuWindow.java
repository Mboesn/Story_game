package story_game.gui.window;

import java.util.Optional;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
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
     * @param mainMenuStage Main menu stage
     * @param type          The type of menu to open
     */
    public void show(Stage mainMenuStage, SaveMenuType type) {
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
            saveButtons[i] = new SaveButton("Save " + (i + 1), stage, type);
            list.add(saveButtons[i]);
        }

        ButtonCustom back = new ButtonCustom("Back");

        back.setOnMouseClicked(e -> {
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

    private class SaveButton extends ButtonCustom {

        /**
         * Creates a button that loads a save file when pressed
         * 
         * @param text              Name of the space file. add whitespaces according to
         *                          button name,
         *                          code will ignore when loading
         * @param loadSaveMenuStage the windows stage, used to close the window after
         *                          loading save
         * @param menuType          The type of menu
         */
        public SaveButton(String text, Stage loadSaveMenuStage, SaveMenuType menuType) {
            super(text);
            String saveFileName = text.replaceAll("\\s+", "");
            SaveFile save = SaveHandler.loadGame(saveFileName);

            if (menuType == SaveMenuType.LOAD_GAME) {
                // If no save is found for a given slot disable the button
                this.setDisable(save == null);
                if (save != null) {
                    setOnMouseClicked(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent event) {
                            GameWindow gameWindow = new GameWindow();
                            gameWindow.show(save);
                            loadSaveMenuStage.close();
                        }
                    });
                }
            } else {
                if (save == null) {
                    this.setText(this.getText() + " - new save");
                    setOnMouseClicked(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent event) {
                            saveGame(saveFileName, loadSaveMenuStage);
                        }
                    });
                } else {
                    this.setText(this.getText() + " - override save");
                    // Throws an alert telling the user that save will be overridden
                    Alert exitConfirmationAlert = new Alert(AlertType.CONFIRMATION);
                    exitConfirmationAlert.setTitle("Are you sure?");
                    exitConfirmationAlert.setHeaderText("You are about to delete " + text);
                    exitConfirmationAlert
                            .setContentText("Deleting this save cannot be undone, do you wish to proceed?");

                    setOnMouseClicked(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent event) {
                            Optional<ButtonType> isExit = exitConfirmationAlert.showAndWait();
                            if (isExit.isPresent() && isExit.get() == ButtonType.OK) {
                                saveGame(saveFileName, loadSaveMenuStage);
                            }
                        }
                    });
                }
            }
        }

        private void saveGame(String saveFileName, Stage loadSaveMenuStage) {
            SaveFile saveFile = new SaveFile();
            SaveHandler.saveGame(saveFile, saveFileName);
            GameWindow gameWindow = new GameWindow();
            gameWindow.show(saveFile);
            loadSaveMenuStage.close();
        }
    }

    // The type of save menu to open
    public enum SaveMenuType {
        NEW_GAME,
        LOAD_GAME;
    }
}
