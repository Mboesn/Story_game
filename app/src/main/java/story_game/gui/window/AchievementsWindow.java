package story_game.gui.window;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import story_game.gui.util.ButtonCustom;
import story_game.save_mechanics.achievements.AchievementsContainer;
import story_game.save_mechanics.achievements.AchievementsFile;

public class AchievementsWindow {
    public void show() {
        final double sceneWidth = 1000;
        final double sceneHeight = 600;

        final double achievementImageWidth = 75;
        final double achievementImageHeight = 75;

        Stage stage = new Stage();
        VBox root = new VBox();

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(root);
        scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);

        Scene scene = new Scene(scrollPane, sceneWidth, sceneHeight);

        ObservableList<Node> rootList = root.getChildren();

        stage.setScene(scene);
        stage.setTitle("Achievements");

        ButtonCustom back = ButtonCustom.createButtonCustom("Back",
                e -> {
                    stage.close();
                });
        rootList.add(back);

        // Separate completed and uncompleted achievements so they will show up grouped
        // together.
        VBox completedAchievementsBox = new VBox();
        VBox uncompletedAchievementsBox = new VBox();

        AchievementsFile achievements = AchievementsContainer.getAchievements();
        achievements.getAchievements().forEach((key, value) -> {
            try {
                boolean completed = !value.isBlank();
                Image image = new Image(getClass().getResourceAsStream(key.getImagePath()));
                ImageView imageView = new ImageView(image);
                // If haven't completed achievement make it grayscale.
                if (!completed) {
                    ColorAdjust grayscale = new ColorAdjust();
                    grayscale.setSaturation(-1.0); // -1.0 is fully desaturated (grayscale)
                    imageView.setEffect(grayscale);
                }
                // Set the desired dimensions
                imageView.setFitWidth(achievementImageWidth);
                imageView.setFitHeight(achievementImageHeight);
                imageView.setPreserveRatio(false);
                // Smooth the scaling for better quality
                imageView.setSmooth(true);

                GridPane achievementPane = new GridPane();
                achievementPane.add(imageView, 0, 0);

                String achievementName = key.getName() + "\n";
                if (completed) {
                    achievementPane.add(new Text(achievementName + key.getDescription() + " Completed on: " + value), 1,
                            0);
                    completedAchievementsBox.getChildren().add(achievementPane);
                } else {
                    achievementPane.add(new Text(achievementName + "???"), 1, 0);
                    uncompletedAchievementsBox.getChildren().add(achievementPane);
                }

            } catch (Exception e) {
                System.out.println("Failed to load achievement: " + key.getName() + "\nerror: " + e);
            }
        });
        rootList.add(completedAchievementsBox);
        rootList.add(uncompletedAchievementsBox);

        // blocks all other windows till settings has been finished
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}
