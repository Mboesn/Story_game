package story_game.save_mechanics.achievements;

import java.util.HashMap;

import com.google.gson.Gson;

import story_game.save_mechanics.SaveHandler.Saveable;

public class AchievementsFile implements Saveable {
    private HashMap<Achievement, Boolean> achievements;

    public AchievementsFile() {
        achievements = new HashMap<Achievement, Boolean>();
        for (Achievement achievement : Achievement.values()) {
            achievements.put(achievement, false);
        }
    }

    public HashMap<Achievement, Boolean> getAchievements() {
        return achievements;
    }

    public void setAchievement(Achievement achievement, boolean hasCompleted) {
        achievements.replace(achievement, hasCompleted);
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public enum Achievement {
        SLEEP("Sweet dreams", "Fall asleep and never wake up."),
        FINISH_DEMO("Finish demo", "Finish demo"),
        GET_YOURSELF_TOGETHER("Get yourself together", "Get dressed, brush your teeth, and clean up.");

        transient private String name;
        transient private String description;

        Achievement(String name, String description) {
            this.name = name;
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }
    }
}
