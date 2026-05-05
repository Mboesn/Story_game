package story_game.save_mechanics.achievements;

import java.util.HashMap;

import com.google.gson.Gson;

import story_game.save_mechanics.SaveHandler.Saveable;

public class AchievementsFile implements Saveable {
    private HashMap<Achievements, Boolean> achievements;

    public AchievementsFile() {
        achievements = new HashMap<Achievements, Boolean>();
        for (Achievements achievement : Achievements.values()) {
            achievements.put(achievement, false);
        }
    }

    public HashMap<Achievements, Boolean> getAchievements() {
        return achievements;
    }

    public void setAchievements(Achievements achievement, boolean hasCompleted) {
        achievements.replace(achievement, hasCompleted);
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public enum Achievements {
        SLEEP("Sweet dreams", "Fall asleep and never wake up."),
        FINISH_DEMO("Finish demo", "Finish demo"),
        GET_YOURSELF_TOGETHER("Get yourself together", "Get dressed, brush your teeth, and clean up.");

        transient private String name;
        transient private String description;

        Achievements(String name, String description) {
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
