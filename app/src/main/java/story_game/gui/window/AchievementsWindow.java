package story_game.gui.window;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import story_game.gui.util.ButtonCustom;
import story_game.save_mechanics.SaveHandler;
import story_game.save_mechanics.achievements.AchievementsFile;

public class AchievementsWindow {
    public void show() {
        final double sceneWidth = 1000;
        final double sceneHeight = 600;

        final double achievementWidth = 200;
        final double achievementHeight = 200;

        Stage stage = new Stage();
        VBox root = new VBox();
        Scene scene = new Scene(root, sceneWidth, sceneHeight);

        ObservableList<Node> rootList = root.getChildren();

        stage.setScene(scene);
        stage.setTitle("Achievements");

        VBox completedAchievementsBox = new VBox();
        VBox uncompletedAchievementsBox = new VBox();

        AchievementsFile achievements = SaveHandler.loadAchievements();
        achievements.getAchievements().forEach((key, value) -> {
            try {
                Image image = new Image(getClass().getResourceAsStream(key.getImagePath()));
                ImageView imageView = new ImageView(image);
                // if haven't completed achievement make it grayscale
                if (!value) {
                    ColorAdjust grayscale = new ColorAdjust();
                    grayscale.setSaturation(-1.0); // -1.0 is fully desaturated (grayscale)
                    imageView.setEffect(grayscale);
                }
                // Set the desired dimensions
                imageView.setFitWidth(achievementWidth);
                imageView.setFitHeight(achievementHeight);
                // Maintain the original aspect ratio (highly recommended)
                imageView.setPreserveRatio(true);
                // Smooth the scaling for better quality
                imageView.setSmooth(true);

                GridPane achievementsPane = new GridPane();
                achievementsPane.add(imageView, 0, 0);
                if (value) {
                    completedAchievementsBox.getChildren().add(achievementsPane);
                } else {
                    uncompletedAchievementsBox.getChildren().add(achievementsPane);
                }

            } catch (Exception e) {
                System.out.println("Failed to load achievement: " + key.getName() + "\nerror: " + e);
                e.printStackTrace();
            }
        });
        rootList.add(completedAchievementsBox);
        rootList.add(uncompletedAchievementsBox);

        ButtonCustom back = ButtonCustom.createButtonCustom("Back",
                e -> {
                    stage.close();
                });
        rootList.add(back);

        // blocks all other windows till settings has been finished
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}
