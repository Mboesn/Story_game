package story_game.text.pages.TownScene;

import story_game.Constants;
import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;
import story_game.gui.util.EndGameButton;
import story_game.save_mechanics.achievements.Achievement;
import story_game.save_mechanics.save_file.SaveFile;
import story_game.text.Page;
import story_game.text.pages.TownScene.InnScene.TavernEnterPage;
import story_game.text.CustomText;

public class EnterTownPage extends Page {

    @Override
    public CustomText[] getTexts(SaveFile saveFile) {
        CustomText[] texts = new CustomText[] {
                new CustomText("You follow the road for about 15 minutes and reach the outskirts of ",
                        Constants.Names.TOWN_NAME,
                        ". The is considered quite a quiet place, though way too loud and busy for your liking. Despite the fact that this is the biggest town around,"
                                + " There is very few things to find here. Pretty much a few houses and an tavern make up the entire location. The tavern you are quite familiar with as you come there to drink"
                                + " as often as possible. You start ending down the road towards the tavern in hopes of finding some food.")
        };
        return texts;
    }

    @Override
    public ButtonCustom[] getButtons(SaveFile saveFile) {
        ButtonCustom[] buttons = new ButtonCustom[] {
                new ContinueButton(new TavernEnterPage(), "Enter tavern")
        };
        return buttons;
    }
}
