package story_game.gui.util;

import javafx.scene.control.Button;
import story_game.Constants;

// Adds repetitive functions to the Button class
public class ButtonCustom extends Button {
    public ButtonCustom(String text) {
        super(text);
        setMaxWidth(Constants.DEFAULT_BUTTON_WIDTH);
    }
}
