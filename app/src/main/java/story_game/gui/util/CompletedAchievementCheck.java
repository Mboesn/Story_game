package story_game.gui.util;

import story_game.save_mechanics.achievements.AchievementsFile.Achievement;

@FunctionalInterface
public interface CompletedAchievementCheck {
    public Achievement CheckCompleted();
}
