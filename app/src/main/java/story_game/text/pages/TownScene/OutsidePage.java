package story_game.text.pages.TownScene;

import story_game.gui.util.ButtonCustom;
import story_game.gui.util.EndGameButton;
import story_game.save_mechanics.achievements.Achievement;
import story_game.save_mechanics.save_file.SaveFile;
import story_game.text.Page;
import story_game.text.CustomText;

public class OutsidePage extends Page {

    @Override
    public CustomText[] getTexts(SaveFile saveFile) {
        CustomText[] texts = new CustomText[] {
                new CustomText("1"),
                new CustomText("2"),
                new CustomText("3"),
                new CustomText("4"),
                new CustomText("5")
        };
        return texts;
    }

    @Override
    public ButtonCustom[] getButtons(SaveFile saveFile) {
        ButtonCustom[] buttons = new ButtonCustom[] {
                new EndGameButton("Finish Demo", () -> Achievement.FINISH_DEMO)
        };
        return buttons;
    }
}
