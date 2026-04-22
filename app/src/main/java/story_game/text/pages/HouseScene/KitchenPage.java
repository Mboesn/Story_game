package story_game.text.pages.HouseScene;

import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;
import story_game.save_mechanics.SaveFile;
import story_game.text.Page;
import story_game.text.Text;

public class KitchenPage extends Page {

    @Override
    public Text[] getTexts() {
        Text[] texts = new Text[] {
                new Text("1"),
                new Text("2"),
                new Text("3")
        };
        return texts;
    }

    @Override
    public ButtonCustom[] getButtons(SaveFile saveFile) {
        ButtonCustom[] buttons = new ButtonCustom[] {
                new ContinueButton(getTexts()).setOnClickFunction(() -> {

                }),
                new ContinueButton(new BedroomPage(), "Return to livingroom")
        };
        return buttons;
    }
}
