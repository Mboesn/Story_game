package story_game.gui.util;

import story_game.gui.window.GameWindow;
import story_game.text.Page;
import story_game.text.Text;

public class ContinueButton extends ButtonCustom {
    private int nextText = 1;

    @SuppressWarnings("deprecation")
    public ContinueButton(Text[] text, Page targetPage) {
        super("Continue");
        setOnMouseClicked(e -> {
            if (nextText == text.length)
                GameWindow.setCurrentPage(targetPage);
            else {
                GameWindow.updateText(text[nextText]);
                nextText++;
            }
        });
    }
}
