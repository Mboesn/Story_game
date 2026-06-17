package story_game.gui.controllers.game;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;
import story_game.Constants;
import story_game.gui.controllers.exit_confirmation.ExitConfirmationFunctions;
import story_game.gui.controllers.main_menu.MainMenuCtrl;
import story_game.gui.controllers.save_menu.SaveMenuFunctions;
import story_game.gui.controllers.save_menu.SaveMenuCtrl.SaveType;
import story_game.gui.util.ButtonCustom;
import story_game.gui.util.FXMLPaths;
import story_game.gui.util.OnClickFunction;
import story_game.gui.util.PopupHandler;
import story_game.gui.util.StageHandler;
import story_game.save_mechanics.save_file.SaveFile;
import story_game.text.Page;
import story_game.text.CustomText;

public class GameCtrl {
    @FXML
    public TextFlow textFlow;
    @FXML
    public ScrollPane textScroll;
    @FXML
    public VBox choicesVBox;
    @FXML
    public VBox a;
    @FXML
    public ScrollPane choicesScroll;

    private static GameCtrl gameController;

    private static boolean unsafeClose = false;
    private static Page currentPage;
    private static SaveFile saveFile;

    @FXML
    public void initialize() {
        gameController = this;
        Region parentLayout = (Region) StageHandler.stage.getScene().getRoot();
        parentLayout.setSnapToPixel(true);
        textFlow.setPrefWidth(textScroll.getWidth());
        textFlow.setFocusTraversable(false);
        textScroll.setFocusTraversable(false);
        choicesScroll.setFocusTraversable(false);
        choicesVBox.setFocusTraversable(false);
        a.setFocusTraversable(false);
    }

    public static void setupGameScene(SaveFile saveFile) {
        StageHandler.stage.setTitle(Constants.GAME_NAME);
        StageHandler.stage.setOnCloseRequest(event -> {
            event.consume();
            switchStage(event);
            unsafeClose = false;
        });
        GameCtrl.saveFile = saveFile;
        setCurrentPage(saveFile.getCurrentPage());
    }

    /**
     * @param unsafeClose whether or not to close the game window without confirming
     *                    with the player.
     */
    public static void setUnsafeClose(boolean unsafeClose) {
        GameCtrl.unsafeClose = unsafeClose;
    }

    /**
     * @return The currently showing page.
     */
    public Page getCurrentPage() {
        return currentPage;
    }

    /**
     * Changes the games pages and updates: the text, the buttons, and the temporary
     * save file.
     * 
     * @param currentPage Page to set the game to.
     */
    public static void setCurrentPage(Page currentPage) {
        try {
            // update game text to first text of the page
            updateText(currentPage.getTexts(saveFile)[0]);
            // update buttons
            addButtons(currentPage.getButtons(saveFile));
            // update variables accordingly
            GameCtrl.currentPage = currentPage;
            saveFile.setCurrentPage(currentPage);
        } catch (Exception e) {
            System.out.println("Failed to set current page, error: \n" + e);
            e.printStackTrace();
        }
    }

    /**
     * Updates the game screen to a given text.
     * 
     * @param text text to update to.
     */
    public static void updateText(CustomText text) {
        try {
            gameController.textFlow.getChildren().setAll(text.getTextNodes());
            gameController.textFlow.requestLayout();
            gameController.textScroll.requestLayout();
        } catch (Exception e) {
            System.out.println("Failed to update text, error: \n" + e);
        }
    }

    /**
     * Changes the choices buttons.
     * 
     * @param buttons new buttons to add to the game screen
     */
    private static void addButtons(ButtonCustom[] buttons) {
        gameController.choicesVBox.getChildren().clear();
        if (buttons != null)
            for (ButtonCustom btn : buttons) {
                try {
                    if (!btn.isInvisible())
                        gameController.choicesVBox.getChildren().add(btn);
                } catch (Exception e) {
                    System.out.println("Failed to add button, error: \n" + e);
                }
            }
    }

    @FXML
    public void returnToMainMenu(ActionEvent event) {
        switchStage(event);
    }

    private static void switchStage(Event event) {
        try {
            Parent root = FXMLLoader.load(GameCtrl.class.getResource(FXMLPaths.MAIN_MENU.getPath()));
            OnClickFunction close = () -> {
                MainMenuCtrl.setupMainMenuStage();
                StageHandler.stage.getScene().setRoot(root);
            };
            if (unsafeClose)
                close.onClick();
            else
                new ExitConfirmationFunctions(event, close);

        } catch (Exception e) {
            System.out.println("Failed to launch game window.\nError: " + e);
        }
    }

    @FXML
    private void save(ActionEvent event) {
        SaveMenuFunctions.saveGame(event, saveFile);
    }

    @FXML
    private void quickSave(ActionEvent event) {
        SaveMenuFunctions.quickSave(saveFile, SaveType.QUICK_SAVE);
    }

    @FXML
    private void load(ActionEvent event) {
        new ExitConfirmationFunctions(event, () -> SaveMenuFunctions.loadGame(event));
    }

    @FXML
    private void quickLoad(ActionEvent event) {
        new ExitConfirmationFunctions(event, SaveMenuFunctions::quickLoad);
    }

    @FXML
    private void settings(ActionEvent event) {
        PopupHandler.loadPopup(FXMLPaths.SETTINGS, event);
    }
}
