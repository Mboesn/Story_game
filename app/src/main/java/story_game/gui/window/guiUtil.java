package story_game.gui.window;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class guiUtil {
    public static void loadPopup(FXMLPaths popup, Event event) {
        try {
            // loads pop up
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SettingsWindow.class.getResource(popup.getPath()));
            Pane popupPane = loader.<Pane>load();
            // centers pop up
            AnchorPane.setTopAnchor(popupPane, 0.0);
            AnchorPane.setBottomAnchor(popupPane, 0.0);
            AnchorPane.setLeftAnchor(popupPane, 0.0);
            AnchorPane.setRightAnchor(popupPane, 0.0);

            // loads current pane
            Object source = event.getSource();
            Pane originalPane = null;
            if (source instanceof Stage stage) {
                originalPane = (Pane) stage.getScene().getRoot();
            } else {
                originalPane = (Pane) ((Node) source).getScene().getRoot();
            }

            // adds popup to main
            if (originalPane != null)
                originalPane.getChildren().add(popupPane);

        } catch (Exception e) {
            System.out.println("Failed to open popup\nError: " + e);
            e.printStackTrace();
        }
    }

    public static void closePopup(Pane popupPane) {
        ((Pane) popupPane.getParent()).getChildren().remove(popupPane);
    }
}
