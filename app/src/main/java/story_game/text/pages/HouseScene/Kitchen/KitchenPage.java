package story_game.text.pages.HouseScene.Kitchen;

import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;
import story_game.save_mechanics.SaveFile;
import story_game.text.Page;
import story_game.text.Text;
import story_game.text.pages.HouseScene.LivingRoom.LivingRoomPage;

public class KitchenPage extends Page {

    @Override
    public Text[] getTexts(SaveFile saveFile) {
        String text = "You enter your kitchen and find your pantry , fridge, and freezer. In the kitchen there are a bunch more "
                + "open bottles from, what you can only assume as, the night before.";
        if (!saveFile.getHouseSceneFlags().checkedKitchenForFood) {
            text += "\n\nyou should probably check for food.";
        } else {
            text += "\n\nIt seems that you ate the place dry, you should probably go to town to find something to eat.";
        }
        Text[] texts = new Text[] {
                new Text(text)
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
                
                new ContinueButton(new LivingRoomPage(), "Return to livingRoom")
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
