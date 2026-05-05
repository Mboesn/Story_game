package story_game.save_mechanics.save_file.scene_flags;

public class HouseSceneFlags {
    // Bathroom
    public boolean brushedTeeth = false;
    // Kitchen
    public boolean checkedKitchenForFood = false;
    public transient boolean checkedPantryForFood = false;
    public transient boolean checkedFridgeForFood = false;
    public transient boolean checkedFreezerForFood = false;
    // Living Room
    public transient boolean cleanedUpBottles = false;
}
