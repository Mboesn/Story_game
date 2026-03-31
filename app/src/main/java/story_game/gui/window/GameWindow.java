package story_game.gui.window;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import story_game.Constants;
import story_game.gui.util.ButtonCustom;
import story_game.save_mechanics.SaveFile;

public class GameWindow {
    public void show(SaveFile saveFile) {
        final double sceneWidth = 1000;
        final double sceneHeight = 600;

        Stage stage = new Stage();
        VBox root = new VBox();
        Scene scene = new Scene(root, sceneWidth, sceneHeight);
        stage.setScene(scene);
        stage.setTitle(Constants.GAME_NAME);
        stage.setOnCloseRequest(e -> {
            e.consume();
            ExitConfirmationAlert.confirmExit(stage);
        });
        ObservableList<Node> list = root.getChildren();

        ButtonCustom settingsButton = new ButtonCustom("Settings");
        settingsButton.setOnMouseClicked(e -> {
            SettingsWindow settingsWindow = new SettingsWindow();
            settingsWindow.show();
        });
        list.add(settingsButton);

        TextArea gameTextArea = new TextArea();
        gameTextArea.setText(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam lacus libero, laoreet ut feugiat non, luctus quis erat. Morbi eleifend accumsan eleifend. Donec nibh nunc, fermentum eu risus ut, fermentum porta leo. Suspendisse in diam auctor, imperdiet metus eget, tincidunt justo. Cras tincidunt cursus leo, sit amet mollis nisi luctus at. Nunc venenatis sit amet ligula eu egestas. Fusce consequat fermentum accumsan. Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ultricies quam et porttitor venenatis.\r\n"
                        + //
                        "\r\n" + //
                        "Mauris venenatis nisl sed turpis ornare elementum. Praesent interdum, enim non rhoncus maximus, erat libero lacinia justo, sit amet posuere ligula metus ac lectus. Curabitur posuere non diam vitae varius. Proin volutpat ipsum libero, et fermentum diam ornare sit amet. Pellentesque sed vehicula mauris. Etiam vitae blandit eros. Suspendisse tincidunt venenatis velit. Suspendisse tellus lorem, commodo dignissim rhoncus et, condimentum et neque. Cras cursus consectetur eros, a dignissim eros hendrerit ac.\r\n"
                        + //
                        "\r\n" + //
                        "Morbi in nulla ullamcorper, faucibus sapien nec, ornare nulla. Fusce consectetur lacus leo, in dapibus felis auctor quis. Etiam semper felis non tempus semper. Praesent pretium gravida arcu ac condimentum. Aenean libero metus, feugiat eu dignissim maximus, malesuada quis tellus. Pellentesque eros nulla, euismod a pharetra ut, ultrices vel magna. Mauris a semper nunc. Duis volutpat felis ut justo ultricies mattis. Ut dui orci, tristique vitae lacus eu, hendrerit ullamcorper ex. Ut imperdiet vitae nisl non porttitor. Fusce rutrum sem vel malesuada commodo. Maecenas sit amet urna at odio blandit ultricies. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae;\r\n"
                        + //
                        "\r\n" + //
                        "Curabitur volutpat suscipit libero, iaculis dignissim felis commodo sed. Donec nec dignissim nulla. Ut blandit justo ex, non elementum urna sodales et. Mauris posuere faucibus velit, quis porttitor magna aliquam eu. Donec tempor ultricies aliquet. Nam dapibus libero vitae ipsum ultrices sagittis. Cras luctus lacus orci, ac tincidunt nulla sagittis non. Phasellus eget mollis tortor. Suspendisse convallis sapien eros, eu tristique tortor commodo vel. Curabitur vehicula velit vestibulum tellus molestie, eget tristique mi sollicitudin.\r\n"
                        + //
                        "\r\n" + //
                        "Mauris scelerisque iaculis porta. Nam dapibus sodales libero, et sodales lacus auctor luctus. Mauris tincidunt, ligula quis elementum bibendum, ex libero porttitor velit, ut malesuada ipsum justo in purus. Donec mattis ac lorem et pellentesque. Donec et ipsum risus. Vivamus varius massa mi, non finibus urna tincidunt non. Donec lectus lacus, aliquam posuere semper a, finibus sed felis. Maecenas non nunc consectetur, lobortis tortor et, tincidunt velit.");
        gameTextArea.setWrapText(true);
        list.add(gameTextArea);

        // TODO: add everything

        // blocks all other windows till settings has been finished
        stage.initModality(Modality.NONE);

        stage.show();
    }
}
