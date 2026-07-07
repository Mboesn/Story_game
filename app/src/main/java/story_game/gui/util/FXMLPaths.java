package story_game.gui.util;

public enum FXMLPaths {
    MAIN_MENU("MainMenu"),
    EXIT("ExitConfirmAlert"),
    SETTINGS("Settings"),
    ACHIEVEMENTS_WINDOW("Achievements"),
    ACHIEVEMENT_NODE("AchievementNode"),
    SAVE_MENU("SaveMenu"),
    SAVE_OVERRIDE_CONFIRMATION("SaveOverrideConfirmation"),
    GAME("Game");

    private String path;

    /**
     * All the lists of path to the FXML files. Used to launch fxml files.
     * 
     * @param name The name of the FXML file.
     */
    FXMLPaths(String name) {
        this.path = "/gui/fxml/" + name + ".fxml";
    }

    /**
     * @return Path to the FXML file.
     */
    public String getPath() {
        return path;
    }
}
