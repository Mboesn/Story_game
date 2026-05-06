package story_game.save_mechanics.achievements;

import story_game.gui.util.CompletedAchievementCheck;
import story_game.save_mechanics.SaveHandler;
import story_game.save_mechanics.achievements.AchievementsFile.Achievement;

public class AchievementsContainer {
    private static AchievementsFile achievements = SaveHandler.loadAchievements();

    /**
     * @return The current achievements file.
     */
    public static AchievementsFile getAchievements() {
        return achievements;
    }

    public static void CheckAchievements(CompletedAchievementCheck... achievementChecks) {
        for (CompletedAchievementCheck achievementCheck : achievementChecks) {
            Achievement achievement = achievementCheck.CheckCompleted();
            if (achievement != null)
                getAchievements().setAchievement(achievement, true);
        }
        SaveHandler.saveAchievements(getAchievements());
    }
}
