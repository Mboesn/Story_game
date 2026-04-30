package story_game.text.pages.HouseScene;

import story_game.Constants;
import story_game.save_mechanics.SaveFile;
import story_game.text.ResponsePage;
import story_game.text.Text;
import story_game.text.pages.HouseScene.Bedroom.WakingUpPage;

public class IntroPage extends ResponsePage {

    public IntroPage() {
        super(new WakingUpPage());
    }

    @Override
    public Text[] getTexts(SaveFile saveFile) {
        Text[] texts = new Text[] {
                new Text(
                        "You're name is Gobby McGobface, you are a goblin from the " + Constants.KINGDOM_NAME
                                + ". You stand at 3 and a half feet, have green skin, bald, pointy ears, With deep black eyes."),
                new Text(
                        "You don't remember what happened the day before, but have some good guesses based on yourself, your headache, and extreme hunger. "
                                + "Two of those things you can't quite do anything about, but your hunger can easily be changed. "
                                + "As long as you can wake up and get your self out of bed and go the kitchen the hunger can be satiated.")
        };
        return texts;
    }
}
