package story_game.gui.controllers.achievements;

import javafx.fxml.FXML;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import story_game.save_mechanics.achievements.Achievement;

public class AchievementNodeCtrl {
    @FXML
    public ImageView achievementImage;
    @FXML
    public Text nameText;
    @FXML
    public Text discText;
    @FXML
    public AnchorPane node;

    public void setAchievementNode(Achievement achievement, String completionDate) {
        try {
            boolean completed = !completionDate.isBlank();

            Image image = new Image(getClass().getResourceAsStream(achievement.getImagePath()));
            achievementImage.setImage(image);

            // If haven't completed achievement make it grayscale.
            if (!completed) {
                ColorAdjust grayscale = new ColorAdjust();
                grayscale.setSaturation(-1.0); // -1.0 is fully desaturated (grayscale)
                achievementImage.setEffect(grayscale);
            }

            nameText.setText(achievement.getName());

            if (completed) {
                discText.setText(achievement.getDescription() + " Completed on: " + completionDate);
            } else {
                discText.setText("???");
            }
        } catch (Exception e) {
            System.out.println("Failed to load achievement node: " + achievement.getName() + "\nerror: " + e);
        }
    }
}
