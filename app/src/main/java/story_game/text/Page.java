package story_game.text;

import story_game.gui.util.ButtonCustom;

public abstract class Page {
    protected String pageName;

    public abstract Text[] getTexts();

    public abstract ButtonCustom[] getButtons();

    public String getName() {
        return pageName;
    }
}
