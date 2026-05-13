package story_game.text;

import java.util.ArrayList;

import javafx.scene.text.Text;

public class CustomText {
    private ArrayList<Text> texts = new ArrayList<Text>();

    /**
     * This class stores all info about a given text paragraph.
     * 
     * @param paragraphs All the paragraphs to merge together. Provide either
     *                   CustomText objects or string which will be displayed using
     *                   default font.
     */
    public CustomText(Object... paragraphs) {
        for (int i = 0; i < paragraphs.length; i++) {
            if (paragraphs[i] instanceof String str) {
                Text tempText = new Text(str);
                tempText.setFont(TextType.DEFAULT.getFont());
                texts.add(tempText);
            } else if (paragraphs[i] instanceof CustomText customText) {
                texts.addAll(customText.getTextNodes());
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
        Text tempText = new Text(text);
        tempText.setFont(textType.getFont());
        texts.add(tempText);
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

    public ArrayList<Text> getTextNodes() {
        return texts;
    }
}
