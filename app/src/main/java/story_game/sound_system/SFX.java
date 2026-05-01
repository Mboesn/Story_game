package story_game.sound_system;

public enum SFX {
    ROOSTER("dragon-studio-rooster-crowing-364473");

    private String path;

    SFX(String name) {
        this.path = "app\\src\\main\\java\\resources\\sfx\\" + name + ".mp3";
    }

    public String getPath() {
        return path;
    }
}
