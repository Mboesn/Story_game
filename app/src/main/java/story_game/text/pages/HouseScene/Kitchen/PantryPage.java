package story_game.text.pages.HouseScene.Kitchen;

import story_game.save_mechanics.SaveFile;
import story_game.text.ResponsePage;
import story_game.text.Text;

public class PantryPage extends ResponsePage {

    public PantryPage() {
        super(new KitchenPage());
    }

    @Override
    public Text[] getTexts(SaveFile saveFile) {
        Text[] texts = new Text[] {
                new Text(
                        "You open the pantry. A dirty old thing currently containing an entire ecosystem of ants, spiders and dust mites."
                                + " They seemed to have someone made a truce between the varies species, each inhabiting there own section. You have a small"
                                + " suspicion that they may have even developed a trade system between them."),
                new Text(
                        "In the very back of the pantry you find a box of cereal. You eagerly reach over and grab the box, very narrowly avoiding all the cobwebs."
                                + " You lift it up and are delighted to find out it is quite heavy. Although this celebration was quite premature as you soon find out"
                                + " when you open the box to find it filled to the brim with saw dust. Not wishing to understand the meaning of this, you put the"
                                + " box back, closing the pantry allowing the civilization inside to continue developing.")

        };
        return texts;
    }
}
