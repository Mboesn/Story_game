package story_game.gui.controllers.achievements;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import story_game.gui.controllers.settings.SettingsCtrl;
import story_game.gui.util.FXMLPaths;
import story_game.gui.util.PopupHandler;
import story_game.save_mechanics.achievements.AchievementsContainer;
import story_game.save_mechanics.achievements.AchievementsFile;

/**
 * Controls the page hosting all the achievements. Top list includes completed
 * achievements bottom includes uncompleted achievements.
 */
public class AchievementsCtrl {
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

        // For every achievement listed in the achievement save file add a node with
        // it's information and status.
        achievements.getAchievements().forEach((achievement, completionDate) -> {
            try {
                // Load a new node and set it's values equal to the current achievement
                Pane achievementNodePane;
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(SettingsCtrl.class.getResource(FXMLPaths.ACHIEVEMENT_NODE.getPath()));
                achievementNodePane = loader.<Pane>load();
                AchievementNodeCtrl controller = loader.getController();

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
        // If one of the lists is empty remove the list and title.
        if (completedAchievementsBox.getChildren().isEmpty()) {
            achievementsVBox.getChildren().remove(completedAchievementsBox);
            achievementsVBox.getChildren().remove(completedText);
        } else if (uncompletedAchievementsBox.getChildren().isEmpty()) {
            achievementsVBox.getChildren().remove(uncompletedAchievementsBox);
            achievementsVBox.getChildren().remove(uncompletedText);
        }
    }

    @FXML
    /**
     * Closes the window.
     */
    public void back(ActionEvent event) {
        PopupHandler.closePopup(achievementsPane);
    }
}
