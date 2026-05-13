package story_game.text;

import javafx.scene.text.Text;

public class CustomText {
    private String[] text;
    private TextType[] textType;
    //TODO: switch to array and take all from custom texts not just first value

    /**
     * This class stores all info about a given text paragraph.
     * 
     * @param customText All the paragraphs to merge together. Provide either
     *                   CustomText objects or string which will be displayed using
     *                   default font.
     */
    public CustomText(Object... paragraphs) {
        int textCount = paragraphs.length;
        this.text = new String[textCount];
        this.textType = new TextType[textCount];
        for (int i = 0; i < textCount; i++) {
            if (paragraphs[i] instanceof String str) {
                this.text[i] = str;
                this.textType[i] = TextType.DEFAULT;
            } else if (paragraphs[i] instanceof CustomText customText) {
                this.text[i] = customText.getFirstText();
                this.textType[i] = customText.getFirstTextType();
            } else {
                throw new IllegalArgumentException(
                        "CustomText only accepts String or CustomText");
            }
        }
    }

    /**
     * This class stores all info about a given text paragraph.
     * 
     * @param text     The text to display.
     * @param textType The font settings to apply to the text.
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
        this(text, TextType.DEFAULT);
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
