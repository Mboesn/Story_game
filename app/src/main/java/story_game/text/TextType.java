package story_game.text;

import javafx.scene.text.Font;

public enum TextType {
    DEFAULT_FONT(Font.font("System", 25));

    private Font font;

    private TextType(Font font) {
        this.font = font;
    }

    public Font getFont() {
        return font;
    }
}
