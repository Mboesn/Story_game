package story_game.text.pages.HouseScene;

import story_game.Constants;
import story_game.save_mechanics.save_file.SaveFile;
import story_game.text.ResponsePage;
import story_game.text.CustomText;
import story_game.text.pages.HouseScene.Bedroom.WakingUpPage;

public class IntroPage extends ResponsePage {

    public IntroPage() {
        super(new WakingUpPage());
    }

    @Override
    public CustomText[] getTexts(SaveFile saveFile) {
        CustomText[] texts = new CustomText[] {
                new CustomText(
                        "Your name is ", Constants.Names.MAIN_CHARACTER_NAME, ", you are a goblin from the ",
                        Constants.Names.KINGDOM_NAME,
                        ". You stand at 3 and a half feet, have green skin, bald, pointy ears, With deep black eyes."),
                new CustomText(
                        "You don't remember what happened the day before, but have some good guesses based on yourself, your headache, and extreme hunger. "
                                + "Two of those things you can't quite do anything about, but your hunger can easily be changed. "
                                + "As long as you can wake up and get yourself out of bed and go the kitchen the hunger can be satiated.")
        };
        return texts;
    }
}
