package story_game.text;

import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;
import story_game.save_mechanics.SaveFile;

/**
 * This class represents a generic page in the game Which does not have any
 * buttons other than a "Continue" button.
 */
public abstract class ResponsePage extends Page {
    /** The page to load after completing shifting through the texts. */
    private Page targetPage;

    protected ResponsePage(Page targetPage) {
        this.targetPage = targetPage;
    }

    @Override
    public ButtonCustom[] getButtons(SaveFile saveFile) {
        return new ButtonCustom[] { new ContinueButton(getTexts(saveFile), targetPage) };
    }
}
