package story_game.text.pages.HouseScene.FrontYard;

import story_game.save_mechanics.save_file.SaveFile;
import story_game.text.CustomText;
import story_game.text.ResponsePage;

public class ExitHousePage extends ResponsePage {

    public ExitHousePage() {
        super(new FrontYardPage());
    }

    @Override
    public CustomText[] getTexts(SaveFile saveFile) {
        CustomText[] texts = new CustomText[] {
                new CustomText(
                        "You open the door to find nothing but white and pain. The huge whiteness quickly turns into " +
                                "all encompassing darkness. For a second you believe you might have gone blind, when you realize your eyes are closed. "
                                +
                                "Opening them slowly and peaking outside your eyes adjust to the sunlight which is not helping your headache. "
                                +
                                "Aggressive urges start attacking you, telling you to retreat back into the safety and comfort of your home. "
                                +
                                "Yet your stomach manges to overpower such weak wiles.")
        };
        return texts;
    }
}
