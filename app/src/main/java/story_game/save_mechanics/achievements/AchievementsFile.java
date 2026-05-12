package story_game.save_mechanics.achievements;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import com.google.gson.Gson;

import story_game.save_mechanics.SaveHandler.Saveable;

public class AchievementsFile implements Saveable {
    private HashMap<Achievement, String> achievements;

    public AchievementsFile() {
        achievements = new HashMap<Achievement, String>();
        for (Achievement achievement : Achievement.values()) {
            achievements.put(achievement, "");
        }
    }

    public HashMap<Achievement, String> getAchievements() {
        return achievements;
    }

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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm:ss");
        String time = rawTime.format(formatter);
        achievements.replace(achievement, time);
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public enum Achievement {
        SLEEP("Sweet dreams", "Fall asleep and never wake up.", "sleeping zzz"),
        FINISH_DEMO("Finish demo", "Finish demo", "gears"),
        GET_YOURSELF_TOGETHER("Get yourself together", "Get dressed, brush your teeth, and clean up.", "suit");

        transient private String name;
        transient private String description;
        transient private String imagePath;

        Achievement(String name, String description, String imageName) {
            this.name = name;
            this.description = description;
            this.imagePath = "/achievement images/" + imageName + ".jpg";
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public String getImagePath() {
            return imagePath;
        }
    }
}
