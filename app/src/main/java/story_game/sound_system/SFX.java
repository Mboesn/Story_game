package story_game.sound_system;

public enum SFX {
    ROOSTER("dragon-studio-rooster-crowing-364473");

    private String path;

    /**
     * List of all the sounds effects available to be played. All sounds effects is
     * royalty free.
     * 
     * @param name The name of the sound effect file.
     */
    SFX(String name) {
        this.path = "app\\src\\main\\resources\\sfx\\" + name + ".mp3";
    }

    public String getPath() {
        return path;
    }
}
