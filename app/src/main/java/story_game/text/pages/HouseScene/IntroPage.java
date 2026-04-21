package story_game.text.pages.HouseScene;

import story_game.text.ResponsePage;
import story_game.text.Text;

public class IntroPage extends ResponsePage {

    public IntroPage() {
        super.targetPage = new WakingUpPage();
    }

    @Override
    public Text[] getTexts() {
        Text[] texts = new Text[3];
        texts[0] = new Text("1");
        texts[1] = new Text("2");
        texts[2] = new Text("3");
        return texts;
    }
}
