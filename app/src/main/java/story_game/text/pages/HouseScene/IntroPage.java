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
        texts[0] = new Text("Well you must be asking how we got here");
        texts[1] = new Text("Well I don't know");
        texts[2] = new Text("text 3");
        return texts;
    }
}
