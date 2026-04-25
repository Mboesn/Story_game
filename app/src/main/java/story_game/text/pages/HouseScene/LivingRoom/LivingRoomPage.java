package story_game.text.pages.HouseScene.LivingRoom;

import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;
import story_game.save_mechanics.SaveFile;
import story_game.text.Page;
import story_game.text.Text;
import story_game.text.pages.HouseScene.Bedroom.BedroomPage;
import story_game.text.pages.HouseScene.Kitchen.KitchenPage;
import story_game.text.pages.OutsideScene.OutsidePage;

public class LivingRoomPage extends Page {

    @Override
    public Text[] getTexts(SaveFile saveFile) {
        Text[] texts = new Text[] {
                new Text("1"),
                new Text("2"),
                new Text("3")
        };
        return texts;
    }

    @Override
    public ButtonCustom[] getButtons(SaveFile saveFile) {
        ButtonCustom[] buttons = new ButtonCustom[] {
                new ContinueButton(getTexts(saveFile)).setOnClickFunction(() -> {
                }),
                new ContinueButton(new KitchenPage(), "Enter kitchen"),
                new ContinueButton(new BedroomPage(), "Return to bedroom"),
                new ContinueButton(new OutsidePage(),
                        "Exit your house and go on your adventure!!! no turning back")
        };
        return buttons;
    }
}
