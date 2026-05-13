package story_game.text.pages.HouseScene.Bathroom;

import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;
import story_game.save_mechanics.achievements.AchievementsContainer;
import story_game.save_mechanics.achievements.Achievement;
import story_game.save_mechanics.save_file.Characteristics.Clothes;
import story_game.save_mechanics.save_file.SaveFile;
import story_game.text.Page;
import story_game.text.TextType;
import story_game.text.CustomText;
import story_game.text.pages.HouseScene.Bedroom.BedroomPage;

public class BathroomPage extends Page {

    @Override
    public CustomText[] getTexts(SaveFile saveFile) {
        CustomText[] texts = new CustomText[] {
                new CustomText(
                        "You enter your bathroom and see your toilet, sink, and shower. By the sink you spot your ",
                        new CustomText("toothbrush.", TextType.ITEM))
        };
        return texts;
    }

    @Override
    public ButtonCustom[] getButtons(SaveFile saveFile) {
        ButtonCustom[] buttons = new ButtonCustom[] {
                new ContinueButton(new BrushingTeethPage(), "Brush teeth").setOnClickFunction(() -> {
                    saveFile.getHouseSceneFlags().brushedTeeth = true;
                    AchievementsContainer
                            .CheckAchievements(() -> saveFile.getPlayerCharacter().getClothing() != Clothes.PAJAMAS
                                    && saveFile.getHouseSceneFlags().cleanedUpBottles
                                            ? Achievement.GET_YOURSELF_TOGETHER
                                            : null);
                }).setInvisible(saveFile.getHouseSceneFlags().brushedTeeth),
                new ContinueButton(new BedroomPage(), "Return to bedroom")
        };
        return buttons;
    }
}
