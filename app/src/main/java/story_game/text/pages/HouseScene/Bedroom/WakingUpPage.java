package story_game.text.pages.HouseScene.Bedroom;

import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;
import story_game.save_mechanics.SaveFile;
import story_game.sound_system.AudioHandler;
import story_game.sound_system.SFX;
import story_game.text.Page;
import story_game.text.Text;

public class WakingUpPage extends Page {

        @Override
        public Text[] getTexts(SaveFile saveFile) {
                Text[] texts = new Text[] {
                                new Text("Now are you ready to take on the day and all the adventures that come with it?"),
                                new Text(
                                                "You're right, every good hero deserves a little rest, take a bit of time and get yourself mentally prepared for the troubles and tribulations to come. "
                                                                + "Once you have got yourself prepared just go ahead and wake up and take on the new day!"),
                                new Text(
                                                "Maybe it's fear? Maybe it's sloth? Either way you need to get it together and face what is to come!"),
                                new Text(
                                                """
                                                                Clearly all the best games start with the main character waking up:
                                                                    Half life 2
                                                                    Portal 2
                                                                    Skyrim
                                                                    Fallout: New Vegas
                                                                    Disco Elysium

                                                                So obviously there must be some correlation between waking up at the beginning of a game and having a good time. You should probably try it.
                                                                        """),
                                new Text(
                                                """
                                                                Well you also have:
                                                                        BioShock
                                                                        Prey
                                                                        Amnesia: The dark descent
                                                                        Persona 5
                                                                        Outer Wilds
                                                                        """),
                                new Text("You know, this bit has gotten pretty old fairly quickly. I think The Stanley Parable did it way better, just press the wake up button already....")
                };
                return texts;
        }

        @Override
        public ButtonCustom[] getButtons(SaveFile saveFile) {
                ButtonCustom[] buttons = new ButtonCustom[] {
                                new ContinueButton(new WakeUpPage(), "Wake up").setOnClickFunction(() -> {
                                        AudioHandler.playSFX(SFX.ROOSTER);
                                }),
                                new ContinueButton(getTexts(saveFile), new RefuseToWakeUpPage(),
                                                "Just five more minutes....")
                };
                return buttons;
        }
}
