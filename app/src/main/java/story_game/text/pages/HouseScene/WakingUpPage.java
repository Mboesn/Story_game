package story_game.text.pages.HouseScene;

import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;
import story_game.save_mechanics.SaveFile;
import story_game.text.Page;
import story_game.text.Text;

public class WakingUpPage extends Page {

    @Override
    public Text[] getTexts(SaveFile saveFile) {
        Text[] texts = new Text[] {
                new Text("1"),
                new Text("2"),
                new Text("3"),
                new Text("4"),
                new Text("5")
        };
        return texts;
    }

    @Override
    public ButtonCustom[] getButtons(SaveFile saveFile) {
        ButtonCustom[] buttons = new ButtonCustom[] {
                new ContinueButton(new BedroomPage(), "Wake up"),

                new ContinueButton(getTexts(saveFile), new RefuseToWakeUpPage(), "Just five more minutes....")
        };
        return buttons;
    }
}
