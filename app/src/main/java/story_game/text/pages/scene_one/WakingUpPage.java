package story_game.text.pages.scene_one;

import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;
import story_game.text.Page;
import story_game.text.Text;

public class WakingUpPage extends Page {

    @Override
    public Text[] getTexts() {
        Text[] text = new Text[5];
        text[0] = new Text("a");
        text[1] = new Text("b");
        text[2] = new Text("c");
        text[3] = new Text("d");
        text[4] = new Text("e");
        return text;
    }

    @Override
    public ButtonCustom[] getButtons() {
        ButtonCustom op1 = new ContinueButton(new BedRoomPage(), "Wake up");

        ButtonCustom op2 = new ContinueButton(getTexts(), new RefuseToWakeUpPage(), "Just five more minutes....");

        return new ButtonCustom[] { op1, op2 };
    }
}
