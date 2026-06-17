package story_game.gui.util;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import story_game.Constants;

// Adds repetitive functions to the Button class
public class ButtonCustom extends Button {
    protected boolean isInvisible = false;

    /**
     * Creates a button with the specified text as its label.
     * 
     * @param text A text string for its label.
     * @deprecated Use createButtonCustom() in order to make sure that the button
     *             has
     *             a function
     */
    @Deprecated
    public ButtonCustom(String text) {
        super(text);
        setMinWidth(Constants.DEFAULT_BUTTON_MIN_WIDTH);
        setDefaultButton(false);
        setFocusTraversable(false);
    }

    /**
     * Creates a button with the specified text as its label and Sets the value of
     * the property onMouseClicked.
     * 
     * @param text          A text string for its label.
     * @param buttonHandler Defines a function to be called when a mouse button has
     *                      been clicked (pressed and released) on this Node.
     * 
     * @return A new button.
     */
    public static ButtonCustom createButtonCustom(String text, EventHandler<? super MouseEvent> buttonHandler) {
        ButtonCustom btn = new ButtonCustom(text);
        btn.setOnMouseClicked(buttonHandler);
        return btn;
    }

    /**
     * Sets if the button is disabled. The button will still be displayed yet not be
     * clickable.
     * 
     * @param isDisabled if the button is disabled
     * @return This object
     */
    public ButtonCustom defineDisable(boolean isDisabled) {
        setDisable(isDisabled);
        return this;
    }

    /**
     * @return if the button is invisible. When the button is called in GameWindow
     *         it will not show the button if this value is true. Only applicable to
     *         choice buttons.
     */
    public boolean isInvisible() {
        return this.isInvisible;
    }

    /**
     * Sets if the button is invisible. When the button is called in GameWindow it
     * will not show the button if this value is true. Only applicable to choice
     * buttons.
     * 
     * @param isInvisible if the button is invisible
     * @return This object
     */
    public ButtonCustom setInvisible(boolean isInvisible) {
        this.isInvisible = isInvisible;
        return this;
    }
}
