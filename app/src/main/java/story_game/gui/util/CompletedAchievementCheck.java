package story_game.gui.util;

import story_game.save_mechanics.achievements.Achievement;

/**
 * This interface is used in order to check when an achievement has been
 * completed by the player.
 */
@FunctionalInterface
public interface CompletedAchievementCheck {
    /**
     * Checks if an achievement has been completed.
     * 
     * @return completed achievement, is null if achievement was not completed.
     */
    public Achievement CheckCompleted();
}
