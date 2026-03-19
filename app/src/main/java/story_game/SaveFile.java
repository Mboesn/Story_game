package story_game;

import com.google.gson.Gson;

import story_game.save_mechanics.PlayerCharacter;
import story_game.save_mechanics.scene_flags.SceneOneFlags;

public class SaveFile {
    private PlayerCharacter playerCharacter;
    private SceneOneFlags sceneOneFlags;

    /**
     * This class holds all the info about the state of the game. It can be saved and loaded using SaveHandler.
     */
    public SaveFile() {
        this.playerCharacter = new PlayerCharacter();
        this.sceneOneFlags = new SceneOneFlags();
    }

    public PlayerCharacter getPlayerCharacter() {
        return this.playerCharacter;
    }

    public SceneOneFlags getSceneOneFlags() {
        return this.sceneOneFlags;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
