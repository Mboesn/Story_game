package story_game.gui.util;

import story_game.gui.window.GameWindow;
import story_game.text.Page;
import story_game.text.Text;

public class ContinueButton extends ButtonCustom {
    private int nextText = 1;
    private OnClickFunction onClickFunction;

    /**
     * Creates a button with the specified text as its label, This button will shift
     * through all the text given, excluding the first element, once reached last
     * text element switches the page to the given page. This button does not set
     * the text to first element.
     * 
     * @param text       Text to shift through.
     * @param targetPage Page to switch to after completing all text elements.
     * @param buttonText A text string for its label.
     */
    @SuppressWarnings("deprecation")
    public ContinueButton(Text[] text, Page targetPage, String buttonText) {
        super(buttonText);
        setOnMouseClicked(e -> {
            if (text == null || nextText == text.length) {
                if (onClickFunction != null) {
                    onClickFunction.onClick();
                }
                if (targetPage != null) {
                    GameWindow.setCurrentPage(targetPage);
                }
            } else {
                GameWindow.updateText(text[nextText]);
                nextText++;
            }
        });
    }

    /**
     * Creates a button with the specified text as its label, This button will shift
     * through all the text given, excluding the first element, once reached last
     * text element switches the page to the given page. This button does not set
     * the text to first element.
     * 
     * @param text       Text to shift through. Leave as a single element to
     *                   immediately switch pages.
     * @param buttonText A text string for its label.
     * 
     * @Deprecated Use a constructor which includes a following page in order to
     *             insure the button will do something when finished.
     */
    @Deprecated
    public ContinueButton(Text[] text, String buttonText) {
        this(text, null, buttonText);
    }

    /**
     * Creates a button with the specified text as its label, This button will shift
     * through all the text given, excluding the first element, once reached last
     * text element switches the page to the given page. This button does not set
     * the text to first element.
     * 
     * Sets button text to "Continue".
     * 
     * @param text       Text to shift through. Leave as a single element to
     *                   immediately switch pages.
     * @param targetPage Page to switch to after completing all text elements.
     */
    public ContinueButton(Text[] text, Page targetPage) {
        this(text, targetPage, "Continue");
    }

    /**
     * Creates a button with the specified text as its label, This button will shift
     * through all the text given, excluding the first element, once reached last
     * text element switches the page to the given page. This button does not set
     * the text to first element.
     * 
     * Sets button text to "Continue".
     * 
     * @param text Text to shift through. Leave as a single element to
     *             immediately switch pages.
     * @Deprecated Use a constructor which includes a following page in order to
     *             insure the button will do something when finished.
     */
    @Deprecated
    public ContinueButton(Text[] text) {
        this(text, null, "Continue");
    }

    /**
     * Creates a button with the specified text as its label, and changes the page
     * when pressed
     * 
     * @param targetPage Page to switch to after completing all text elements.
     * @param buttonText A text string for its label.
     */
    public ContinueButton(Page targetPage, String buttonText) {
        this(null, targetPage, buttonText);
    }

    /**
     * Creates a button with the specified text as its label, and changes the page
     * when pressed
     * 
     * @param targetPage Page to switch to after completing all text elements
     * @param buttonText A text string for its label.
     * @Deprecated Use a constructor which includes a following page in order to
     *             insure the button will do something.
     */
    @Deprecated
    public ContinueButton(String buttonText) {
        this(null, null, buttonText);
    }

    /**
     * Sets a function to be called before switching a page
     * 
     * @param onClickFunction function to call before switching page
     * @return This object
     */
    public ContinueButton setOnClickFunction(OnClickFunction onClickFunction) {
        this.onClickFunction = onClickFunction;
        return this;
    }

    /**
     * Sets if the button is disabled. The button will still be displayed yet not be
     * clickable.
     * 
     * @param isDisabled if the button is disabled
     * @return This object
     */
    @Override
    public ContinueButton defineDisable(boolean isDisabled) {
        setDisable(isDisabled);
        return this;
    }

    /**
     * Sets if the button is invisible. When the button is called in GameWindow it
     * will not show the button if this value is true. Only applicable to choice
     * buttons.
     * 
     * @param isInvisible if the button is invisible
     * @return This object
     */
    @Override
    public ContinueButton setInvisible(boolean isInvisible) {
        this.isInvisible = isInvisible;
        return this;
    }
}
