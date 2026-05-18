package story_game.text;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * Defines how to display specif types of text. Allowing to mark certain words
 * in a specific manner for the players understanding, focus, immersion, etc.
 */
public enum TextType {
    DEFAULT(Font.font("System", 25)),
    ITEM(Font.font("System", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 25)),
    LOCATION_OPTION(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 25)),
    LOCATION(Font.loadFont(TextType.class.getResourceAsStream("/fonts/CormorantGaramond-VariableFont_wght.ttf"), 25)),
    NAME(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.ITALIC, 25));

    private Font font;

    /**
     * @param font The font to display the text as.
     */
    private TextType(Font font) {
        this.font = font;
    }

    public Font getFont() {
        return font;
    }
}
