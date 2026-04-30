package story_game.text.pages.HouseScene.Bedroom;

import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;
import story_game.save_mechanics.SaveFile;
import story_game.text.Page;
import story_game.text.Text;
import story_game.text.pages.HouseScene.Bathroom.BathroomPage;
import story_game.text.pages.HouseScene.Closet.ClosetPage;
import story_game.text.pages.HouseScene.LivingRoom.LivingRoomPage;

public class BedroomPage extends Page {

    @Override
    public Text[] getTexts(SaveFile saveFile) {
        Text[] texts = new Text[] {
                new Text(
                        "You're in your bedroom. The draw to catch a few more minutes of sleep is strong but you know you must resist the urge. "
                                + "You don't keep much in your bedroom, you like your spaces free and clean. All you have is a twin sized bed which is quite big for you "
                                + "and a night stand with a lantern, book and empty glass bottle on top. From this room you have three doors, "
                                + "the closet, bathroom and living room.")
        };
        return texts;
    }

    @Override
    public ButtonCustom[] getButtons(SaveFile saveFile) {
        ButtonCustom[] buttons = new ButtonCustom[] {
                new ContinueButton(new ClosetPage(), "Check out the closet"),
                new ContinueButton(new BathroomPage(), "Go to bathroom"),
                new ContinueButton(new BookPage(), "Check out book"),
                new ContinueButton(new LivingRoomPage(), "Exit bedroom"),
                // TODO: maybe remove instant death button?
                new ContinueButton(new RefuseToWakeUpPage(), "Go back to sleep")
        };
        return buttons;
    }
}
