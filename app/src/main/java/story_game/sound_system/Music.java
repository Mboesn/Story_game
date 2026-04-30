package story_game.sound_system;

public enum Music {
    DEFAULT("ebunny-legend-357820.mp3"),
    EPIC("kaden_cook-epic-dungeon-beat-259883.mp3");

    private String path;

    Music(String name) {
        this.path = "app\\src\\main\\java\\resources\\music\\" + name;
    }

    public String getPath() {
        return path;
    }
}
