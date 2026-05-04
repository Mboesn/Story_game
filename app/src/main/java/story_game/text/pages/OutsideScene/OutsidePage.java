package story_game.text.pages.OutsideScene;

import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;
import story_game.save_mechanics.save_file.SaveFile;
import story_game.text.Page;
import story_game.text.Text;

public class OutsidePage extends Page {

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
                new ContinueButton(getTexts(saveFile)).setOnClickFunction(() -> {

                }),
                new ContinueButton(getTexts(saveFile))
        };
        return buttons;
    }
}
