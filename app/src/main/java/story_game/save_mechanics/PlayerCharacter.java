package story_game.save_mechanics;

import story_game.save_mechanics.Characteristics.Clothes;

// This class holds all data pertaining to the character of a specific save file
public class PlayerCharacter {

    private Clothes clothes = Clothes.PAJAMAS;

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    @Override
    public String toString() {
        return clothes.getName();
    }
}
