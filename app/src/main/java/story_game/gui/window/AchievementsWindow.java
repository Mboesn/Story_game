package story_game.gui.window;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import story_game.save_mechanics.achievements.AchievementsContainer;
import story_game.save_mechanics.achievements.AchievementsFile;

public class AchievementsWindow {
    @FXML
    public VBox completedAchievementsBox;
    @FXML
    public VBox uncompletedAchievementsBox;
    @FXML
    public Text completedText;
    @FXML
    public Text uncompletedText;
    @FXML
    public VBox achievementsVBox;
    @FXML
    public Pane achievementsPane;

    @FXML
    public void initialize() {
        AchievementsFile achievements = AchievementsContainer.getAchievements();

        achievements.getAchievements().forEach((achievement, completionDate) -> {
            try {
                Pane achievementNodePane;
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(SettingsWindow.class.getResource(FXMLPaths.ACHIEVEMENT_NODE.getPath()));
                achievementNodePane = loader.<Pane>load();

                AchievementNode controller = loader.getController();

                controller.setAchievementNode(achievement, completionDate);

                if (!completionDate.isBlank()) {
                    completedAchievementsBox.getChildren().add(achievementNodePane);
                } else {
                    uncompletedAchievementsBox.getChildren().add(achievementNodePane);
                }

            } catch (Exception e) {
                System.out.println("Failed to load achievement: " + achievement.getName() + "\nerror: " + e);
            }
        });
        if (completedAchievementsBox.getChildren().isEmpty()) {
            achievementsVBox.getChildren().remove(completedAchievementsBox);
            achievementsVBox.getChildren().remove(completedText);
        } else if (uncompletedAchievementsBox.getChildren().isEmpty()) {
            achievementsVBox.getChildren().remove(uncompletedAchievementsBox);
            achievementsVBox.getChildren().remove(uncompletedText);
        }
    }

    @FXML
    public void back(ActionEvent event) {
        new ExitConfirmationAlert(event, achievementsPane);
    }
}
