package story_game.text.pages.scene_one;

import story_game.gui.util.ButtonCustom;
import story_game.text.Page;
import story_game.text.Text;

public class OpeningPage extends Page {

    public OpeningPage() {
        super();
        super.pageName = "Opening";
    }

    @Override
    public Text[] getTexts() {
        Text[] texts = new Text[3];
        texts[0] = new Text("Well you must be asking how we got here");
        texts[1] = new Text("Well I don't know");
        texts[2] = new Text("text 3");
        return texts;
    }
    @Override
    public ButtonCustom getButtons() {
        ButtonCustom op1 = new ButtonCustom("wake up");
        
        return null;
    }
}
