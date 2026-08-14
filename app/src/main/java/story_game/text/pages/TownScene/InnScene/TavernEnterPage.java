package story_game.text.pages.TownScene.InnScene;

import story_game.Constants;
import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;
import story_game.save_mechanics.save_file.SaveFile;
import story_game.text.CustomText;
import story_game.text.Page;

public class TavernEnterPage extends Page {

    @Override
    public CustomText[] getTexts(SaveFile saveFile) {
        CustomText[] texts = new CustomText[] {
                new CustomText("You enter the ", Constants.Names.TAVERN_NAME,
                        ", a small tavern with very few guests. The sign outside has a pracing horse with as you might guess,"
                                + " a silver mane. You stride straight to your favorite spot right up front at the bar and notice ",
                        Constants.Names.BARKEEP_CHARACTER_NAME,
                        ", the friendly dwarven barkeep, staring daggers at you. You fear if you speak up he might actually attack you.")
        };
        return texts;
    }

    @Override
    public ButtonCustom[] getButtons(SaveFile saveFile) {
        ButtonCustom[] buttons = new ButtonCustom[] {
                new ContinueButton("Exit bar"),
                new ContinueButton("Speak to the barkeep")
        };
        return buttons;
    }
}
