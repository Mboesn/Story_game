package story_game.text.pages.HouseScene.LivingRoom;

import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;
import story_game.save_mechanics.save_file.SaveFile;
import story_game.text.CustomText;
import story_game.text.Page;
import story_game.text.TextType;
import story_game.text.pages.HouseScene.Bedroom.BedroomPage;
import story_game.text.pages.HouseScene.Kitchen.KitchenPage;
import story_game.text.pages.OutsideScene.OutsidePage;

public class LivingRoomPage extends Page {

    @Override
    public CustomText[] getTexts(SaveFile saveFile) {
        CustomText bottles;
        if (!saveFile.getHouseSceneFlags().cleanedUpBottles)
            bottles = new CustomText(" Sprawled across the floor are countless ",
                    new CustomText("glass bottles", TextType.ITEM), ".");
        else
            bottles = new CustomText("");

        CustomText checkedKitchen;
        if (!saveFile.getHouseSceneFlags().checkedKitchenForFood) {
            checkedKitchen = new CustomText("\n\nYou should probably check out the ",
                    new CustomText("kitchen", TextType.LOCATION_OPTION),
                    " to see what you have to eat before leaving.");
        } else {
            checkedKitchen = new CustomText("\n\nOnce you are all ready you should leave and go to ",
                    new CustomText("town", TextType.LOCATION_OPTION), " to find some food.");
        }

        CustomText[] texts = new CustomText[] {
                new CustomText("Your living room.", bottles,
                        " You find two doors, one leads to the ",
                        new CustomText("kitchen", TextType.LOCATION_OPTION), " and one to the very scary ",
                        new CustomText("outside", TextType.LOCATION_OPTION), ".",
                        checkedKitchen)
        };
        return texts;
    }

    @Override
    public ButtonCustom[] getButtons(SaveFile saveFile) {

        ButtonCustom[] buttons = new ButtonCustom[] {
                new ContinueButton(new BottlesPage(), "Check out bottles")
                        .setInvisible(saveFile.getHouseSceneFlags().cleanedUpBottles),
                new ContinueButton(new KitchenPage(), "Enter kitchen"),
                new ContinueButton(new BedroomPage(), "Return to bedroom"),
                // if you haven't checked the kitchen do not let the player leave
                new ContinueButton(new OutsidePage(),
                        "Exit your house and go on your adventure!!! no turning back")
                        .defineDisable(!saveFile.getHouseSceneFlags().checkedKitchenForFood)
        };
        return buttons;
    }
}
