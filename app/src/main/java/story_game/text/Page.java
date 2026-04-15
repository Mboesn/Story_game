package story_game.text;

import story_game.gui.util.ButtonCustom;
import story_game.save_mechanics.SaveFile;

public abstract class Page {
    public abstract Text[] getTexts();

    public abstract ButtonCustom[] getButtons(SaveFile saveFile);
}
