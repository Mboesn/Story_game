package story_game.text.pages.HouseScene.Bedroom;

import story_game.Constants;
import story_game.save_mechanics.SaveFile;
import story_game.text.ResponsePage;
import story_game.text.Text;

public class WakeUpPage extends ResponsePage {

    public WakeUpPage() {
        super(new BedroomPage());
    }

    @Override
    public Text[] getTexts(SaveFile saveFile) {
        Text[] texts = new Text[] {
                new Text(
                        "You open your eyes on a new day in the comfort of your bedroom. The fresh summer sun baths your skin from the big round window beside your bed. "
                                + "You live in a quaint modest cottage on the outskirts of " + Constants.TOWN_NAME
                                + ". You enjoy the privacy and quietness that this location provides. Your cabin has all the basic necessities needed for a living quarters: a bedroom, "
                                + "bathroom, living room, and, most importantly now, a kitchen. You should probably go search for something to settle your hunger as soon as possible. "
                                + "While thinking about what you shall make for breakfast you notice a rancid smell emanating from your person. You realize that you probably didn't brush "
                                + "your teeth the previous night and the smell could very much be deem a biohazard. Getting up from bed you gain a new resolve to finally get yourself "
                                + "together. All you need is to brush your teeth and probably get out of your pajamas.")
        };
        return texts;
    }
}
