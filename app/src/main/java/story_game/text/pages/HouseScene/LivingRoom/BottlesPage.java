package story_game.text.pages.HouseScene.LivingRoom;

import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;
import story_game.save_mechanics.SaveFile;
import story_game.text.Page;
import story_game.text.Text;

public class BottlesPage extends Page {

    @Override
    public Text[] getTexts(SaveFile saveFile) {
        Text[] texts = new Text[] {
                new Text("You look closer and they are all empty. You should probably clean this up.")
        };
        return texts;
    }

    @Override
    public ButtonCustom[] getButtons(SaveFile saveFile) {
        ButtonCustom[] buttons = new ButtonCustom[] {
                new ContinueButton(getTexts(saveFile), new BottleCleanUpPage(), "Clean up the bottles")
                        .setOnClickFunction(() -> {
                            saveFile.getHouseSceneFlags().cleanedUpBottles = true;
                        }),
                new ContinueButton(new LivingRoomPage(), "It adds to the decor of the house, should keep it there.")
        };
        return buttons;
    }
}
