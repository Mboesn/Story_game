package story_game.gui.window;

public enum FXMLPaths {
    MAIN_MENU("MainMenu"),
    EXIT("Exit"),
    SETTINGS("Settings");

    private String path;

    /**
     * List of all the sounds effects available to be played. All sounds effects is
     * royalty free.
     * 
     * @param name The name of the sound effect file.
     */
    FXMLPaths(String name) {
        this.path = "/gui/fxml/" + name + ".fxml";
    }

    public String getPath() {
        return path;
    }
}
