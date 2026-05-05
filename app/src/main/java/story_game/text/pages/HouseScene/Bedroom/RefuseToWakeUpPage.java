package story_game.text.pages.HouseScene.Bedroom;

import story_game.gui.util.ButtonCustom;
import story_game.save_mechanics.save_file.SaveFile;
import story_game.text.Page;
import story_game.text.Text;

public class RefuseToWakeUpPage extends Page {

    @Override
    public Text[] getTexts(SaveFile saveFile) {
        Text text[] = new Text[] { new Text(
                "And so Gobby McGobface, went to sleep and died of starvation. \n \t \t \t \t \t \t \t \t \t FIN") };
        return text;
    }

    @Override
    public ButtonCustom[] getButtons(SaveFile saveFile) {
        // TODO: add exit button and achievement
        return null;
    }
}
