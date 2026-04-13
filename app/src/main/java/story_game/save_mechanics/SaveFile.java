package story_game.save_mechanics;

import com.google.gson.Gson;

import story_game.save_mechanics.scene_flags.SceneOneFlags;
import story_game.text.Page;
import story_game.text.pages.scene_one.ExplainingStuffPage;

public class SaveFile {
    private PlayerCharacter playerCharacter;
    private SceneOneFlags sceneOneFlags;
    private Page currentPage;

    /**
     * This class holds all the info about the state of the game. It can be saved
     * and loaded using SaveHandler.
     */
    public SaveFile() {
        this.playerCharacter = new PlayerCharacter();
        this.sceneOneFlags = new SceneOneFlags();
        this.currentPage = new ExplainingStuffPage();
    }

    public PlayerCharacter getPlayerCharacter() {
        return this.playerCharacter;
    }

    public SceneOneFlags getSceneOneFlags() {
        return this.sceneOneFlags;
    }

    public Page getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Page currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
