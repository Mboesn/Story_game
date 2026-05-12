package story_game.save_mechanics.achievements;

public enum Achievement {
    SLEEP("Sweet dreams", "Fall asleep and never wake up.", "sleeping zzz"),
    FINISH_DEMO("Finish demo", "Finish demo", "gears"),
    GET_YOURSELF_TOGETHER("Get yourself together", "Get dressed, brush your teeth, and clean up.", "suit");

    transient private String name;
    transient private String description;
    transient private String imagePath;

    /**
     * List of all the achievements.
     * 
     * @param name        The name of the achievement.
     * @param description The description of the achievement.
     * @param imageName   The name of the image to use for the achievement.
     */
    Achievement(String name, String description, String imageName) {
        this.name = name;
        this.description = description;
        this.imagePath = "/achievement images/" + imageName + ".jpg";
    }

    /**
     * @return the name of the achievement.
     */
    public String getName() {
        return name;
    }

    /**
     * @return the description of the achievement.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return The path to the image to use for the achievement. Relative to
     *         resources file.
     */
    public String getImagePath() {
        return imagePath;
    }
}