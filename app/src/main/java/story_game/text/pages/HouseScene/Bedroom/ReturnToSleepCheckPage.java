package story_game.text.pages.HouseScene.Bedroom;

import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;
import story_game.save_mechanics.save_file.SaveFile;
import story_game.text.CustomText;
import story_game.text.Page;

public class ReturnToSleepCheckPage extends Page {

    @Override
    public CustomText[] getTexts(SaveFile saveFile) {
        CustomText[] texts = new CustomText[] {
                new CustomText("Are you sure you want to go back to sleep?")
        };
        return texts;
    }

    @Override
    public ButtonCustom[] getButtons(SaveFile saveFile) {
        ButtonCustom[] buttons = new ButtonCustom[] {
                new ContinueButton(new BedroomPage(), "Stay awake"),
                new ContinueButton(new RefuseToWakeUpPage(), "Go back to sleep")
        };
        return buttons;
    }
}
