package story_game;

public class SaveFile {
    private PlayerCharacter character;

    public SaveFile() {
        this.character = new PlayerCharacter();
    }

    public PlayerCharacter getCharacter() {
        return this.character;
    }
    
}
