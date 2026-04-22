package story_game.text.pages.HouseScene.Closet;

import story_game.save_mechanics.Characteristics.Weapons;
import story_game.text.EnumChoicePage;

public class WeaponsPage extends EnumChoicePage<Weapons> {
    public WeaponsPage() {
        super(Weapons.class, "Pick a weapon:", "Current weapon:", new ClosetPage());
    }
}
