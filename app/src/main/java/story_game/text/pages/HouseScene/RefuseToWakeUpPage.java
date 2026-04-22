package story_game.text.pages.HouseScene;

import story_game.gui.util.ButtonCustom;
import story_game.save_mechanics.SaveFile;
import story_game.text.Page;
import story_game.text.Text;

public class RefuseToWakeUpPage extends Page {

    @Override
    public Text[] getTexts() {
        Text text[] = new Text[] { new Text(
                "And so Gobby McGobface, went to sleep and never woke again \n \t \t \t \t \t \t \t \t \t FIN") };
        return text;
    }

    @Override
    public ButtonCustom[] getButtons(SaveFile saveFile) {
        // TODO: add exit button and achievement
        return null;
    }
}
