package story_game.text.pages.HouseScene;

import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;
import story_game.save_mechanics.SaveFile;
import story_game.text.Page;
import story_game.text.Text;

public class BedroomPage extends Page {

    @Override
    public Text[] getTexts() {
        Text[] texts = new Text[3];
        texts[0] = new Text("You open your eyes and see your room in for of you");
        texts[1] = new Text();
        texts[2] = new Text("c");
        return texts;
    }

    @Override
    public ButtonCustom[] getButtons(SaveFile saveFile) {
        ButtonCustom[] buttons = new ButtonCustom[3];
        buttons[0] = new ContinueButton(new ClosetPage(), "Check out the closet");
        buttons[1] = new ContinueButton(new BathroomPage(), "Go to bathroom");
        buttons[2] = new ContinueButton(new LivingroomPage(), "Exit bedroom");
        buttons[3] = new ContinueButton(new RefuseToWakeUpPage(), "Go back to sleep");
        return buttons;
    }
}
