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
     */
    @Deprecated
    public ButtonCustom(String text) {
        super(text);
        setMaxWidth(Constants.DEFAULT_BUTTON_MAX_WIDTH);
    }

    public static ButtonCustom createButtonCustom(String text, EventHandler<? super MouseEvent> buttonHandler) {
        ButtonCustom btn = new ButtonCustom(text);
        btn.setOnMouseClicked(buttonHandler);
        return btn;
    }
}
