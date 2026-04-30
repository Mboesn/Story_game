package story_game.text.pages.HouseScene.Bathroom;

import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;
import story_game.save_mechanics.SaveFile;
import story_game.text.Page;
import story_game.text.Text;
import story_game.text.pages.HouseScene.Bedroom.BedroomPage;

public class BathroomPage extends Page {

    @Override
    public Text[] getTexts(SaveFile saveFile) {
        Text[] texts = new Text[] {
                new Text(
                        "You enter your bathroom and see your toilet, sink, and shower. By the sink you spot your toothbrush.")
        };
        return texts;
    }

    @Override
    public ButtonCustom[] getButtons(SaveFile saveFile) {
        // If haven't brushed teeth let play brush and set brushed teeth to true
        ButtonCustom brush = null;
        if (!saveFile.getHouseSceneFlags().brushedTeeth)
            brush = new ContinueButton(new BrushingTeethPage(), "Brush teeth").setOnClickFunction(() -> {
                saveFile.getHouseSceneFlags().brushedTeeth = true;
            });

        ButtonCustom[] buttons = new ButtonCustom[] {
                brush,
                new ContinueButton(new BedroomPage(), "Return to bedroom")
        };
        return buttons;
    }
}
