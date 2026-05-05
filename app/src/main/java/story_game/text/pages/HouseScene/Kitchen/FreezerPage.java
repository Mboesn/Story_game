package story_game.text.pages.HouseScene.Kitchen;

import story_game.save_mechanics.save_file.SaveFile;
import story_game.text.ResponsePage;
import story_game.text.Text;

public class FreezerPage extends ResponsePage {

    public FreezerPage() {
        super(new KitchenPage());
    }

    @Override
    public Text[] getTexts(SaveFile saveFile) {
        Text[] texts = new Text[] {
                new Text(
                        "You open up the freezer and find a large piece of meat. You would hurry and cook it up if it wasn't completely white with mold."
                                + " You didn't even know steak could grow so much mold, especially in a freezer. That's when you realize the freezer is room temperature."
                                + " The freezer must be busted, you should get around to fixing it, but you should first get around to fixing yourself."
                                + " You close the freezer knowing fully that neither shall occur, at least not in your lifetime.")
        };
        return texts;
    }
}
