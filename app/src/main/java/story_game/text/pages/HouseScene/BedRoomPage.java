package story_game.text.pages.HouseScene;

import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;
import story_game.save_mechanics.SaveFile;
import story_game.text.Page;
import story_game.text.Text;
import story_game.text.pages.HouseScene.Closet.ClosetPage;

public class BedroomPage extends Page {

    @Override
    public Text[] getTexts(SaveFile saveFile) {
        Text[] texts = new Text[] {
                new Text("You open your eyes and see your room in for of you"),
                new Text("b"),
                new Text("c")
        };
        return texts;
    }

    @Override
    public ButtonCustom[] getButtons(SaveFile saveFile) {
        ButtonCustom[] buttons = new ButtonCustom[] {
                new ContinueButton(new ClosetPage(), "Check out the closet"),
                new ContinueButton(new BathroomPage(), "Go to bathroom"),
                new ContinueButton(new LivingRoomPage(), "Exit bedroom"),
                new ContinueButton(new RefuseToWakeUpPage(), "Go back to sleep")
        };
        return buttons;
    }
}
