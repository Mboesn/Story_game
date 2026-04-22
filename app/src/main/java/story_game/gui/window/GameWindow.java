package story_game.gui.window;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import story_game.Constants;
import story_game.gui.util.ButtonCustom;
import story_game.gui.window.SaveMenuWindow.SaveMenuType;
import story_game.save_mechanics.SaveFile;
import story_game.text.Page;
import story_game.text.Text;

public class GameWindow {

    private static Page currentPage;
    private static ObservableList<Node> choicesList;
    private static TextArea gameTextArea;
    private static SaveFile saveFile;

    public void show(SaveFile saveFile, Stage mainMenuStage) {

        GameWindow.saveFile = saveFile;

        final double sceneWidth = 1000;
        final double sceneHeight = 600;

        final double choiceButtonSpacing = 15;

        final int textAreaSize = 25;

        Stage stage = new Stage();
        HBox topRow = new HBox();
        VBox root = new VBox();
        VBox choices = new VBox();
        Scene scene = new Scene(root, sceneWidth, sceneHeight);

        stage.setScene(scene);
        stage.setTitle(Constants.GAME_NAME);
        stage.setOnCloseRequest(e -> {
            e.consume();
            ExitConfirmationAlert.confirmExit(stage);
        });

        ObservableList<Node> rootList = root.getChildren();
        ObservableList<Node> topRowList = topRow.getChildren();
        ObservableList<Node> choicesList = choices.getChildren();

        GameWindow.choicesList = choicesList;

        ButtonCustom settingsButton = ButtonCustom.createButtonCustom("Settings",
                e -> {
                    SettingsWindow settingsWindow = new SettingsWindow();
                    settingsWindow.show();
                });
        topRowList.add(settingsButton);

        ButtonCustom saveGameButton = ButtonCustom.createButtonCustom("Save game",
                e -> {
                    SaveMenuWindow saveMenuWindow = new SaveMenuWindow();
                    saveMenuWindow.show(mainMenuStage, SaveMenuType.SAVE_GAME, saveFile);
                });
        topRowList.add(saveGameButton);

        ButtonCustom returnToMenuButton = ButtonCustom.createButtonCustom("Return to menu",
                e -> stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST)));
        topRowList.add(returnToMenuButton);

        stage.setOnCloseRequest(e -> {
            e.consume();
            if (ExitConfirmationAlert.confirmExit(stage)) {
                mainMenuStage.show();
            }
        });

        HBox.setHgrow(settingsButton, Priority.ALWAYS);
        HBox.setHgrow(saveGameButton, Priority.ALWAYS);
        HBox.setHgrow(returnToMenuButton, Priority.ALWAYS);
        topRow.setAlignment(Pos.TOP_CENTER);

        rootList.add(topRow);

        TextArea gameTextArea = new TextArea();
        gameTextArea.setWrapText(true);
        gameTextArea.setEditable(false);
        gameTextArea.setPrefRowCount(textAreaSize);
        rootList.add(gameTextArea);

        GameWindow.gameTextArea = gameTextArea;

        rootList.add(choices);
        choices.setSpacing(choiceButtonSpacing);
        choices.setAlignment(Pos.CENTER_LEFT);
        choices.setFillWidth(true);
        choices.autosize();

        setCurrentPage(saveFile.getCurrentPage());

        stage.initModality(Modality.NONE);

        stage.show();
    }

    /**
     * Changes the choices buttons.
     * 
     * @param buttons new buttons to add to the game screen
     */
    private static void addButtons(ButtonCustom[] buttons) {
        choicesList.clear();
        if (buttons != null)
            for (ButtonCustom btn : buttons) {
                try {
                    choicesList.add(btn);
                } catch (Exception e) {
                    System.out.println("Failed to add button, error: \n" + e);
                }
            }
    }

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
            Text text = currentPage.getTexts()[0];
            updateText(text);
            // update buttons
            addButtons(currentPage.getButtons(saveFile));
            // update variables accordingly
            GameWindow.currentPage = currentPage;
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
    public static void updateText(Text text) {
        try {
            GameWindow.gameTextArea.setText(text.getText());
        } catch (Exception e) {
            System.out.println("Failed to update text, error: \n" + e);
        }
    }
}
