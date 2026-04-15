package story_game.text;

public class Text {
    private String text;
    private Font font;

    /**
     * This class stores all info about a given text paragraph.
     * 
     * @param text The text to display.
     * @param font The font settings to apply to the text.
     */
    public Text(String text, Font font) {
        this.text = text;
        this.font = font;
    }

    /**
     * This class stores all info about a given text paragraph, using default font.
     * 
     * @param text The text to display.
     */
    public Text(String text) {
        this(text, new Font());
    }

    /**
     * This class stores all info about a given text paragraph, using default font.
     * 
     * @deprecated temporary constructor to use in order to temporarily make a text
     *             object without given text.
     */
    @Deprecated
    public Text() {
        this("Missing text", new Font());
    }

    /**
     * @return Text to display.
     */
    public String getText() {
        return this.text;
    }

    /**
     * @return The font settings to apply to the text.
     */
    public Font getFont() {
        return this.font;
    }
}
