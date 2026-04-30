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
        String text = "Your living room. Sprawled across the floor are countless glass bottles. You find"
                + " two doors, one leads to the kitchen and one to the very scary outside.";
        if (!saveFile.getHouseSceneFlags().checkedKitchenForFood) {
            text += "\n\nYou should probably check out the kitchen to see what you have to eat before leaving.";
        } else {
            text += "\n\nOnce you are all ready you should leave and go to town to find some food.";
        }

        Text[] texts = new Text[] {
                new Text(text)
        };
        return texts;
    }

    @Override
    public ButtonCustom[] getButtons(SaveFile saveFile) {
        // if you haven't checked the kitchen do not let the player leave
        ButtonCustom exitButton = new ContinueButton(new OutsidePage(),
                "Exit your house and go on your adventure!!! no turning back")
                .defineDisable(!saveFile.getHouseSceneFlags().checkedKitchenForFood);

        ButtonCustom[] buttons = new ButtonCustom[] {
                new ContinueButton(getTexts(saveFile)).setOnClickFunction(() -> {
                }),
                new ContinueButton(new KitchenPage(), "Enter kitchen"),
                new ContinueButton(new BedroomPage(), "Return to bedroom"),
                exitButton
        };
        return buttons;
    }
}
