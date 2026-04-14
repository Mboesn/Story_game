package story_game.gui.util;

import story_game.gui.window.GameWindow;
import story_game.text.Page;
import story_game.text.Text;

public class ContinueButton extends ButtonCustom {
    private int nextText = 1;

    @SuppressWarnings("deprecation")
    public ContinueButton(Text[] text, Page targetPage, String buttonText) {
        super(buttonText);
        setOnMouseClicked(e -> {
            if (text == null || nextText == text.length) {
                if (targetPage != null) {
                    GameWindow.setCurrentPage(targetPage);
                }
            } else {
                GameWindow.updateText(text[nextText]);
                nextText++;
            }
        });
    }

    @Deprecated
    public ContinueButton(Text[] text, String buttonText) {
        this(text, null, buttonText);
    }

    public ContinueButton(Text[] text, Page targetPage) {
        this(text, targetPage, "Continue");
    }

    @Deprecated
    public ContinueButton(Text[] text) {
        this(text, null, "Continue");
    }

    public ContinueButton(Page targetPage, String buttonText) {
        this(null, targetPage, buttonText);
    }

    @Deprecated
    public ContinueButton(String buttonText) {
        this(null, null, buttonText);
    }
}
