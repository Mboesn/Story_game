package story_game.text.pages.HouseScene.FrontYard;

import story_game.Constants;
import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;
import story_game.save_mechanics.save_file.SaveFile;
import story_game.text.CustomText;
import story_game.text.Page;
import story_game.text.pages.HouseScene.LivingRoom.LivingRoomPage;
import story_game.text.pages.TownScene.EnterTownPage;

public class FrontYardPage extends Page {

    @Override
    public CustomText[] getTexts(SaveFile saveFile) {
        CustomText[] texts = new CustomText[] {
                new CustomText(
                        "Your front yard is quite modest area receiving much neglect. Overgrown grass, broken fences, "
                                +
                                "and as expected more empty bottles. You give a judgmental glance at the garden gnomes who as always "
                                +
                                "have not done their part to clean up your yard. You currently have 3 main options of where to head.\n"
                                +
                                "The first choice, which probably the best choice according to your crapulous brain, which is to go back inside and head on to bed.\n"
                                +
                                "The second choice, which is a splendid option according to your famished gut, which is to go into town, find the closest pub and "
                                +
                                "not leave till you've had your fill of all the meats, fruits and vegetables the great ",
                        Constants.Names.KINGDOM_NAME, " has to offer.\n" +
                                "The third choice, which is quite an odd one by all accounts of your internal organs, is to just starts wondering around without rhyme or reason.")
        };
        return texts;
    }

    @Override
    public ButtonCustom[] getButtons(SaveFile saveFile) {
        ButtonCustom[] buttons = new ButtonCustom[] {
                new ContinueButton(new LivingRoomPage(), "Return home"),
                new ContinueButton(new EnterTownPage(),"Head to town"),
                new ContinueButton("I am but a leaf in the winds of fate")
        };
        return buttons;
    }
}
