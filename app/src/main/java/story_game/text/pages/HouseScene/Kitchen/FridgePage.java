package story_game.text.pages.HouseScene.Kitchen;

import story_game.save_mechanics.SaveFile;
import story_game.text.ResponsePage;
import story_game.text.Text;

public class FridgePage extends ResponsePage {

    public FridgePage() {
        super(new KitchenPage());
    }

    @Override
    public Text[] getTexts(SaveFile saveFile) {
        String text = "You open your fridge. It gives of a foul smell";
        if (!saveFile.getSceneOneFlags().brushedTeeth)
            text += ", though not as foul as your mouth since you still haven't brushed your teeth,";
        text += " due to it containing 2 things. At least 7 month old moldy cheese, and a dead rat you suspect tried to eat the moldy cheese. "
                + "As a result of not wanting to join the rat in the halls of Valhalla or whatever you believe in you elect not to eat either of the objects."
                + " You close your fridge wondering how did the rat manage to get in there, pushing off making sure it gets out of there.";

        Text[] texts = new Text[] {
                new Text(text)
        };
        return texts;
    }
}
