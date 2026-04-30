package story_game.text;

import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;
import story_game.save_mechanics.SaveFile;

public abstract class ResponsePage extends Page {

    // TODO: remove transient once save system is fixed
    transient private Page targetPage;
    transient private String buttonText;

    /**
     * This class represents a generic page in the game Which does not have any
     * buttons other than a "Continue" button.
     * 
     * @param targetPage The page to load after completing shifting through the
     *                   texts.
     * @param buttonText Text string for button label.
     */
    protected ResponsePage(Page targetPage, String buttonText) {
        this.targetPage = targetPage;
        this.buttonText = buttonText;
    }

    /**
     * This class represents a generic page in the game Which does not have any
     * buttons other than a "Continue" button. Sets button label to: "Continue".
     * 
     * @param targetPage The page to load after completing shifting through the
     *                   texts.
     */
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
