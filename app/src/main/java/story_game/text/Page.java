package story_game.text;

import story_game.gui.util.ButtonCustom;
import story_game.save_mechanics.SaveFile;

/**
 * This class represents a generic page in the game.
 */
public abstract class Page {

    /**
     * Defines what texts to show when loading the page. The first element of the
     * array is shown when page is loaded, the rest can be loaded from a
     * ContinueButton.
     * 
     * @return Array of texts to display.
     */
    public abstract Text[] getTexts();

    /**
     * Array of all the buttons to display when loading the page.
     * 
     * @param saveFile current temporary save file used by the GameWindow class.
     *                 used to retrieve and edit data in the save file.
     * @return Array of buttons to display.
     */
    public abstract ButtonCustom[] getButtons(SaveFile saveFile);
}
