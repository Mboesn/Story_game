package story_game.text.pages.HouseScene.Closet;

import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;
import story_game.save_mechanics.achievements.AchievementsContainer;
import story_game.save_mechanics.achievements.Achievement;
import story_game.save_mechanics.save_file.Characteristics.Clothes;
import story_game.save_mechanics.save_file.SaveFile;
import story_game.text.Page;
import story_game.text.Text;
import story_game.text.pages.HouseScene.Bedroom.BedroomPage;

public class ClosetPage extends Page {

    @Override
    public Text[] getTexts(SaveFile saveFile) {
        AchievementsContainer.CheckAchievements(() -> saveFile.getHouseSceneFlags().brushedTeeth
                && saveFile.getPlayerCharacter().getClothing() != Clothes.PAJAMAS
                && saveFile.getHouseSceneFlags().cleanedUpBottles
                        ? Achievement.GET_YOURSELF_TOGETHER
                        : null);
        Text[] texts = new Text[] {
                new Text(
                        """
                                You enter your closet, it isn't very big to an average human but as you aren't an average human, but rather a small goblin that finds it quite spacious for your needs.
                                You look about you and find most of your belongings: clothes and weapons.""")
        };
        return texts;
    }

    @Override
    public ButtonCustom[] getButtons(SaveFile saveFile) {
        ButtonCustom[] buttons = new ButtonCustom[] {
                new ContinueButton(new ClothesPage(), "Change clothes"),
                new ContinueButton(new WeaponsPage(), "Change weapons"),
                new ContinueButton(new BedroomPage(), "Return to bedroom")
        };
        return buttons;
    }
}
