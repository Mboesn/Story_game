package story_game.save_mechanics.save_file;

import com.google.gson.Gson;

import story_game.save_mechanics.SaveHandler.Saveable;
import story_game.save_mechanics.save_file.scene_flags.HouseSceneFlags;
import story_game.text.Page;
import story_game.text.pages.HouseScene.IntroPage;

public class SaveFile implements Saveable{
    private PlayerCharacter playerCharacter;
    private HouseSceneFlags HouseSceneFlags;
    private Page currentPage;

    /**
     * This class holds all the info about the state of the game. It can be saved
     * and loaded using SaveHandler.
     */
    public SaveFile() {
        this.playerCharacter = new PlayerCharacter();
        this.HouseSceneFlags = new HouseSceneFlags();
        this.currentPage = new IntroPage();
    }

    public PlayerCharacter getPlayerCharacter() {
        return this.playerCharacter;
    }

    public HouseSceneFlags getHouseSceneFlags() {
        return this.HouseSceneFlags;
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
