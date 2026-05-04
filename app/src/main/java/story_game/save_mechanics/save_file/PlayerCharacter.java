package story_game.save_mechanics.save_file;

import story_game.save_mechanics.save_file.Characteristics.Clothes;
import story_game.save_mechanics.save_file.Characteristics.Weapons;

// This class holds all data pertaining to the character of a specific save file
public class PlayerCharacter {

    private Clothes clothing = Clothes.PAJAMAS;
    private Weapons weapon = Weapons.NONE;

    public Clothes getClothing() {
        return clothing;
    }

    public void setClothing(Clothes clothing) {
        this.clothing = clothing;
    }

    public Weapons getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return clothing.getName() + " " + weapon.getName();
    }
}
