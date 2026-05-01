package story_game.sound_system;

public enum Music {
    DEFAULT("ebunny-legend-357820"),
    EPIC("kaden_cook-epic-dungeon-beat-259883");

    private String path;

    /**
     * List of all the music available to be played. All music is royalty free.
     * 
     * @param name the name of the music file.
     */
    Music(String name) {
        this.path = "app\\src\\main\\java\\resources\\music\\" + name + ".mp3";
    }

    public String getPath() {
        return path;
    }
}
