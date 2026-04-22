package story_game.text.pages.HouseScene;

import story_game.save_mechanics.SaveFile;
import story_game.text.ResponsePage;
import story_game.text.Text;

public class IntroPage extends ResponsePage {

    public IntroPage() {
        super(new WakingUpPage());
    }

    @Override
    public Text[] getTexts(SaveFile saveFile) {
        Text[] texts = new Text[] {
                new Text("1"),
                new Text("2"),
                new Text("3")
        };
        return texts;
    }
}
