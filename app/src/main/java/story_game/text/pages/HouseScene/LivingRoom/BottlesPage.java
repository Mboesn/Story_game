package story_game.text.pages.HouseScene.LivingRoom;

import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;
import story_game.save_mechanics.SaveFile;
import story_game.text.Page;
import story_game.text.Text;

public class BottlesPage extends Page {

    @Override
    public Text[] getTexts(SaveFile saveFile) {
        Text[] texts = new Text[] {
                new Text(""),
        };
        return texts;
    }

    @Override
    public ButtonCustom[] getButtons(SaveFile saveFile) {
        ButtonCustom[] buttons = new ButtonCustom[] {
                new ContinueButton(getTexts(saveFile)).setOnClickFunction(() -> {

                }),
                new ContinueButton(getTexts(saveFile))
        };
        return buttons;
    }
}
