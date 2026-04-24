package story_game.text.pages.HouseScene.Closet;

import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;
import story_game.save_mechanics.SaveFile;
import story_game.text.Page;
import story_game.text.Text;
import story_game.text.pages.HouseScene.Bedroom.BedroomPage;

public class ClosetPage extends Page {

    @Override
    public Text[] getTexts(SaveFile saveFile) {
        Text[] texts = new Text[] {
                new Text(
                        """
                                You enter your closet, it isn't very big to an average human but as you aren't an average human, but rather a small goblin you find it quite spacious for your needs.
                                You look about you and find most of your belongings: clothes and weapons.""")
        };
        return texts;
    }

    @Override
    public ButtonCustom[] getButtons(SaveFile saveFile) {
        ButtonCustom[] buttons = new ButtonCustom[] {
                new ContinueButton(new ClothesPage(), "Change clothes"),
                new ContinueButton(new WeaponsPage(), "Change weapons"),
                new ContinueButton(new BedroomPage(), "Return to bedroom")
        };
        return buttons;
    }
}
