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
    private String buttonText;

    protected ResponsePage(Page targetPage, String buttonText) {
        this.targetPage = targetPage;
        this.buttonText = buttonText;
    }

    protected ResponsePage(Page targetPage) {
        this(targetPage, null);
    }

    @Override
    public ButtonCustom[] getButtons(SaveFile saveFile) {
        if (buttonText == null)
            return new ButtonCustom[] { new ContinueButton(getTexts(saveFile), targetPage) };
        else
            return new ButtonCustom[] { new ContinueButton(getTexts(saveFile), targetPage, buttonText) };
    }
}
