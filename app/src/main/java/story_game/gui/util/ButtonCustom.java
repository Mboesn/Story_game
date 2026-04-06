package story_game.gui.util;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import story_game.Constants;

// Adds repetitive functions to the Button class
public class ButtonCustom extends Button {

    /**
     * Creates a button with the specified text as its label.
     * 
     * @param text A text string for its label.
     * @deprecated Use createButtonCustom in order to make sure that the button has
     *             a function
     */
    public ButtonCustom(String text) {
        super(text);
        setMaxWidth(Constants.DEFAULT_BUTTON_MAX_WIDTH);
    }

    /**
     * Creates a button with the specified text as its label and Sets the value of
     * the property onMouseClicked.
     * 
     * @param text          A text string for its label.
     * @param buttonHandler Defines a function to be called when a mouse button has
     *                      been clicked (pressed and released) on this Node.
     * 
     * @return A created button
     */
    public static ButtonCustom createButtonCustom(String text, EventHandler<? super MouseEvent> buttonHandler) {
        ButtonCustom btn = new ButtonCustom(text);
        btn.setOnMouseClicked(buttonHandler);
        return btn;
    }
}
