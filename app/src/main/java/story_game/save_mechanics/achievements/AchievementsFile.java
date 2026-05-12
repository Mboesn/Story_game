package story_game.save_mechanics.achievements;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import com.google.gson.Gson;

import story_game.save_mechanics.SaveHandler.Saveable;

public class AchievementsFile implements Saveable {
    private HashMap<Achievement, String> achievements;

    /**
     * A serializable class containing all achievement and time stamp of completion.
     */
    public AchievementsFile() {
        achievements = new HashMap<Achievement, String>();
        for (Achievement achievement : Achievement.values()) {
            achievements.put(achievement, "");
        }
    }

    /**
     * @return The hash map containing all achievements and the time stamp of
     *         completion, a black timestamp means achievement has not been
     *         completed.
     */
    public HashMap<Achievement, String> getAchievements() {
        return achievements;
    }

    /**
     * Updates status of achievement. If it has been completed sets timestamp to
     * current time.
     * 
     * @param achievement  The achievement to update.
     * @param hasCompleted Has the achievement been completed.
     */
    public void setAchievement(Achievement achievement, boolean hasCompleted) {
        // Make sure the achievement has been completed and has not already been
        // completed
        if (!hasCompleted) {
            return;
        }
        if (getAchievements().containsKey(achievement)) {
            if (!getAchievements().get(achievement).isBlank())
                return;
        }
        LocalDateTime rawTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String time = rawTime.format(formatter);
        achievements.replace(achievement, time);
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
