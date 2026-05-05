package story_game.save_mechanics.achievements;

import story_game.save_mechanics.SaveHandler;

public class AchievementsContainer {
    private static AchievementsFile achievements = SaveHandler.loadAchievements();

    /**
     * @return The current achievements file.
     */
    public static AchievementsFile getAchievements() {
        return achievements;
    }
}
