package story_game.text.pages.HouseScene.Bathroom;

import story_game.save_mechanics.SaveFile;
import story_game.text.ResponsePage;
import story_game.text.Text;

public class BrushingTeethPage extends ResponsePage {

    public BrushingTeethPage() {
        super(new BathroomPage());
    }

    @Override
    public Text[] getTexts(SaveFile saveFile) {
        Text[] texts = new Text[] {
                new Text("You brush your teeth feeling, and more importantly smelling, fresher than ever.")
        };
        return texts;
    }
}
