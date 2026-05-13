package story_game.text;

import javafx.scene.text.Text;

public class CustomText {
    private String[] text;
    private TextType[] textType;

    /**
     * This class stores all info about a given text paragraph.
     * 
     * @param text The text to display.
     * @param font The font settings to apply to the text.
     */
    public CustomText(CustomText... customTexts) {
        int textCount = customTexts.length;
        this.text = new String[textCount];
        this.textType = new TextType[textCount];
        for (int i = 0; i < textCount; i++) {
            this.text[i] = customTexts[i].getFirstText();
            this.textType[i] = customTexts[i].getFirstTextType();
        }
    }

    /**
     * This class stores all info about a given text paragraph.
     * 
     * @param text The text to display.
     * @param font The font settings to apply to the text.
     */
    public CustomText(String text, TextType textType) {
        this.text = new String[] { text };
        this.textType = new TextType[] { textType };
    }

    /**
     * This class stores all info about a given text paragraph, using default font.
     * 
     * @param text The text to display.
     */
    public CustomText(String text) {
        this(text, TextType.DEFAULT_FONT);
    }

    /**
     * This class stores all info about a given text paragraph, using default font.
     * 
     * @deprecated temporary constructor to use in order to temporarily make a text
     *             object without given text.
     */
    @Deprecated
    public CustomText() {
        this("Missing text");
    }

    public String getFirstText() {
        return this.text[0];
    }

    public TextType getFirstTextType() {
        return this.textType[0];
    }

    public Text[] getTextNodes() {
        Text[] nodes = new Text[this.text.length];
        for (int i = 0; i < this.text.length; i++) {
            Text tempText = new Text(this.text[i]);
            tempText.setFont(this.textType[i].getFont());
            nodes[i] = tempText;
        }
        return nodes;
    }
}
