package story_game.text.pages.HouseScene.Bathroom;

import story_game.save_mechanics.save_file.SaveFile;
import story_game.text.ResponsePage;
import story_game.text.CustomText;

public class BrushingTeethPage extends ResponsePage {

    public BrushingTeethPage() {
        super(new BathroomPage());
    }

    @Override
    public CustomText[] getTexts(SaveFile saveFile) {
        CustomText[] texts = new CustomText[] {
                new CustomText("You brush your teeth feeling, and more importantly smelling, fresher than ever.")
        };
        return texts;
    }
}
