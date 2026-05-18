package story_game.text.pages.HouseScene.LivingRoom;

import story_game.save_mechanics.save_file.SaveFile;
import story_game.text.ResponsePage;
import story_game.text.CustomText;

public class BottleCleanUpPage extends ResponsePage {

    public BottleCleanUpPage() {
        super(new LivingRoomPage());
    }

    @Override
    public CustomText[] getTexts(SaveFile saveFile) {
        CustomText[] texts = new CustomText[] {
                new CustomText("Good job! your a 0.001% closer to getting your life together!")
        };
        return texts;
    }
}
