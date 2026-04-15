package story_game.text.pages.scene_one;

import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;
import story_game.save_mechanics.SaveFile;
import story_game.text.Page;
import story_game.text.Text;

public class BedRoomPage extends Page {

    @Override
    public Text[] getTexts() {
        Text[] texts = new Text[3];
        texts[0] = new Text("a");
        texts[1] = new Text();
        texts[2] = new Text("c");

        // TODO Auto-generated method stub
        return texts;
    }

    @Override
    public ButtonCustom[] getButtons(SaveFile saveFile) {
        ButtonCustom[] buttons = new ButtonCustom[1];
        buttons[0] = new ContinueButton(getTexts()).setOnClickFunction(() -> {
            saveFile.getSceneOneFlags().a = 62;
        });
        return buttons;
    }

}
