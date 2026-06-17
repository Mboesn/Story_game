package story_game.gui.controllers.game;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import story_game.Constants;
import story_game.gui.controllers.exit_confirmation.ExitConfirmationFunctions;
import story_game.gui.controllers.main_menu.MainMenuCtrl;
import story_game.gui.controllers.save_menu.SaveMenuCtrl;
import story_game.gui.controllers.save_menu.SaveMenuCtrl.SaveMenuType;
import story_game.gui.util.ButtonCustom;
import story_game.gui.util.FXMLPaths;
import story_game.gui.util.OnClickFunction;
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

    private static GameCtrl gameController;

    private static boolean unsafeClose = false;
    private static Page currentPage;
    // private static ObservableList<Node> choicesList;
    private static TextFlow gameTextArea;
    private static ScrollPane gameTextScroll;
    private static SaveFile saveFile;

    @FXML
    public void initialize() {
        gameController = this;
    }

    public static void setupGameScene(SaveFile saveFile) {
        StageHandler.stage.setTitle(Constants.GAME_NAME);
        StageHandler.stage.setOnCloseRequest(event -> {
            event.consume();
            switchStage(event);
            // else if (ExitConfirmationAlert.confirmExit(stage))
            // mainMenuStage.show();
            unsafeClose = false;
        });
        GameCtrl.saveFile = saveFile;
        setCurrentPage(saveFile.getCurrentPage());
    }

    public void show(SaveFile saveFile, Stage mainMenuStage) {

        GameCtrl.saveFile = saveFile;

        final double sceneWidth = 1000;
        final double sceneHeight = 600;

        final int textAreaLineSpacing = 3;
        final int textAreaPadding = 25;
        final int textAreaHeight = 300;

        final double choiceButtonSpacing = 15;
        final int choicesPadding = 3;

        Stage stage = new Stage();
        HBox topRow = new HBox();
        VBox root = new VBox();
        VBox choices = new VBox();
        Scene scene = new Scene(root, sceneWidth, sceneHeight);

        stage.setScene(scene);
        stage.setTitle(Constants.GAME_NAME);
        stage.setOnCloseRequest(e -> {
            e.consume();
            // ExitConfirmationAlert.confirmExit(stage);
        });

        ObservableList<Node> rootList = root.getChildren();
        ObservableList<Node> topRowList = topRow.getChildren();
        ObservableList<Node> choicesList = choices.getChildren();

        // GameCtrl.choicesList = choicesList;

        ButtonCustom settingsButton = ButtonCustom.createButtonCustom("Settings",
                e -> {
                });
        topRowList.add(settingsButton);

        ButtonCustom saveGameButton = ButtonCustom.createButtonCustom("Save game",
                e -> {
                    SaveMenuCtrl saveMenuWindow = new SaveMenuCtrl();
                    saveMenuWindow.show(mainMenuStage, SaveMenuType.SAVE_GAME, saveFile);
                });
        topRowList.add(saveGameButton);

        ButtonCustom returnToMenuButton = ButtonCustom.createButtonCustom("Return to menu",
                e -> stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST)));
        topRowList.add(returnToMenuButton);

        stage.setOnCloseRequest(e -> {
            e.consume();
            // If unsafe close is true close without confirming with the player. Used when
            // the game ends.
            if (unsafeClose) {
                mainMenuStage.show();
                stage.close();
            }
            // else if (ExitConfirmationAlert.confirmExit(stage))
            // mainMenuStage.show();
            unsafeClose = false;
        });

        HBox.setHgrow(settingsButton, Priority.ALWAYS);
        HBox.setHgrow(saveGameButton, Priority.ALWAYS);
        HBox.setHgrow(returnToMenuButton, Priority.ALWAYS);
        topRow.setAlignment(Pos.TOP_CENTER);

        rootList.add(topRow);

        TextFlow gameTextArea = new TextFlow();
        gameTextArea.setLineSpacing(textAreaLineSpacing);
        gameTextArea.setPadding(new Insets(0, textAreaPadding, 0, textAreaPadding));
        gameTextArea.setPrefHeight(textAreaHeight);

        ScrollPane textScroll = new ScrollPane(gameTextArea);
        textScroll.setFitToWidth(true);
        textScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        textScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        // Make sure text doesn't clip
        textScroll.setPadding(Insets.EMPTY);

        rootList.add(textScroll);

        GameCtrl.gameTextArea = gameTextArea;
        GameCtrl.gameTextScroll = textScroll;

        choices.setSpacing(choiceButtonSpacing);
        choices.setPadding(new Insets(choicesPadding));
        choices.setAlignment(Pos.CENTER_LEFT);
        choices.setFillWidth(true);
        choices.autosize();

        ScrollPane choicesScroll = new ScrollPane(choices);
        choicesScroll.setFitToWidth(true);
        choicesScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        choicesScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        // Make sure text doesn't clip
        choicesScroll.setPadding(Insets.EMPTY);

        rootList.add(choicesScroll);

        setCurrentPage(saveFile.getCurrentPage());

        stage.initModality(Modality.NONE);

        stage.show();
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
            gameController.textFlow.getChildren().clear();
            gameController.textFlow.getChildren().addAll(text.getTextNodes());
            // Makes sure text doesn't clip into scrollwheel
            gameController.textFlow.layout();
            gameController.textScroll.layout();
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
    }

    @FXML
    private void quickSave(ActionEvent event) {
    }

    @FXML
    private void load(ActionEvent event) {
    }

    @FXML
    private void settings(ActionEvent event) {
    }
}
