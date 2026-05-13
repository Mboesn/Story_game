package story_game.text.pages.HouseScene.Kitchen;

import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;
import story_game.save_mechanics.save_file.SaveFile;
import story_game.text.Page;
import story_game.text.CustomText;
import story_game.text.pages.HouseScene.LivingRoom.LivingRoomPage;

public class KitchenPage extends Page {

    @Override
    public CustomText[] getTexts(SaveFile saveFile) {
        CustomText mission;
        if (!saveFile.getHouseSceneFlags().checkedKitchenForFood) {
            mission = new CustomText("\n\nYou should probably check for food.");
        } else {
            mission = new CustomText(
                    "\n\nIt seems that you ate the place dry, you should probably go to town to find something to eat.");
        }
        CustomText[] texts = new CustomText[] {
                new CustomText(
                        "You enter your kitchen and find your pantry , fridge, and freezer. In the kitchen there are a bunch more "
                                + "open bottles from, what you can only assume, the night before.",
                        mission)
        };
        return texts;
    }

    @Override
    public ButtonCustom[] getButtons(SaveFile saveFile) {
        boolean checkedKitchen = saveFile.getHouseSceneFlags().checkedKitchenForFood;
        // If you haven't checked all the places enables to check each place you haven't
        // yet checked

        ButtonCustom[] buttons = new ButtonCustom[] {
                new ContinueButton(new PantryPage(), "Check pantry").setOnClickFunction(() -> {
                    saveFile.getHouseSceneFlags().checkedPantryForFood = true;
                    checkedAllKitchen(saveFile);
                }).defineDisable(saveFile.getHouseSceneFlags().checkedPantryForFood).setInvisible(checkedKitchen),

                new ContinueButton(new FridgePage(), "Check fridge").setOnClickFunction(() -> {
                    saveFile.getHouseSceneFlags().checkedFridgeForFood = true;
                    checkedAllKitchen(saveFile);
                }).defineDisable(saveFile.getHouseSceneFlags().checkedFridgeForFood).setInvisible(checkedKitchen),

                new ContinueButton(new FreezerPage(), "Check freezer").setOnClickFunction(() -> {
                    saveFile.getHouseSceneFlags().checkedFreezerForFood = true;
                    checkedAllKitchen(saveFile);
                }).defineDisable(saveFile.getHouseSceneFlags().checkedFreezerForFood).setInvisible(checkedKitchen),

                new ContinueButton(new LivingRoomPage(), "Return to the living room")
        };
        return buttons;
    }

    /**
     * checks if player has checked all locations and sets the save file accordingly
     * 
     * @param saveFile current temporary save file used by the GameWindow class.
     *                 used to retrieve and edit data in the save file.
     */
    private void checkedAllKitchen(SaveFile saveFile) {
        if (saveFile.getHouseSceneFlags().checkedPantryForFood && saveFile.getHouseSceneFlags().checkedFridgeForFood
                && saveFile.getHouseSceneFlags().checkedFreezerForFood) {
            saveFile.getHouseSceneFlags().checkedKitchenForFood = true;
        }
    }
}
