package story_game.text.pages.HouseScene.Bedroom;

import story_game.gui.util.ButtonCustom;
import story_game.gui.util.EndGameButton;
import story_game.save_mechanics.achievements.Achievement;
import story_game.save_mechanics.save_file.SaveFile;
import story_game.text.Page;
import story_game.text.CustomText;

public class RefuseToWakeUpPage extends Page {

    @Override
    public CustomText[] getTexts(SaveFile saveFile) {
        CustomText text[] = new CustomText[] { new CustomText(
                "And so Gobby McGobface, went to sleep and died of starvation. \n \t \t \t \t \t \t \t \t \t FIN") };
        return text;
    }

    @Override
    public ButtonCustom[] getButtons(SaveFile saveFile) {
        return new ButtonCustom[] {
                new EndGameButton("Wither away", () -> Achievement.SLEEP)
        };
    }
}
