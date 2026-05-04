package story_game.text.pages.HouseScene.Bedroom;

import story_game.Constants;
import story_game.save_mechanics.save_file.SaveFile;
import story_game.text.ResponsePage;
import story_game.text.Text;

public class BookPage extends ResponsePage {

    public BookPage() {
        super(new BedroomPage(), "Put it back down");
    }

    @Override
    public Text[] getTexts(SaveFile saveFile) {
        Text[] texts = new Text[] {
                new Text(
                        "The book title reads: The great famine of " + Constants.KINGDOM_NAME
                                + " circa 1984 - 1987 by hergork briameakz. You must have been doing some very light reading the previous night.")
        };
        return texts;
    }
}
