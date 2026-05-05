package story_game.text.pages.HouseScene.Closet;

import story_game.save_mechanics.save_file.Characteristics.Clothes;
import story_game.text.EnumChoicePage;

public class ClothesPage extends EnumChoicePage<Clothes> {
    public ClothesPage() {
        super(Clothes.class, "Pick an outfit:", "Your current outfit:", new ClosetPage());
    }
}
