package story_game.text.pages.HouseScene;

import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;
import story_game.save_mechanics.SaveFile;
import story_game.text.Page;
import story_game.text.Text;

public class ClosetPage extends Page {

    @Override
    public Text[] getTexts() {
        Text[] texts = new Text[3];
        texts[0] = new Text("It's a closet");
        return texts;
    }

    @Override
    public ButtonCustom[] getButtons(SaveFile saveFile) {
                ButtonCustom[] buttons = new ButtonCustom[1];
        buttons[0] = new ContinueButton(getTexts());
        buttons[1] = new ContinueButton(new BedroomPage(), "Return to bedroom");
        return buttons;
    }

}
