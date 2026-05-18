package story_game.save_mechanics.save_file;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.Gson;

import story_game.save_mechanics.SaveHandler.Saveable;
import story_game.save_mechanics.save_file.scene_flags.HouseSceneFlags;
import story_game.text.Page;
import story_game.text.pages.HouseScene.IntroPage;

public class SaveFile implements Saveable {
    private String saveDate;

    private PlayerCharacter playerCharacter;
    private HouseSceneFlags HouseSceneFlags;
    private Page currentPage;

    /**
     * This class holds all the info about the state of the game. It can be saved
     * and loaded using SaveHandler.
     */
    public SaveFile() {
        updateSaveDate();
        this.playerCharacter = new PlayerCharacter();
        this.HouseSceneFlags = new HouseSceneFlags();
        this.currentPage = new IntroPage();
    }

    public String getSaveDate() {
        return saveDate;
    }

    public void updateSaveDate() {
        LocalDateTime rawTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        this.saveDate = rawTime.format(formatter);
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
