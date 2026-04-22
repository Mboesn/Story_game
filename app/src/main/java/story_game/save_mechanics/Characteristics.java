package story_game.save_mechanics;

import story_game.text.Font;

/** List of data that can define the players character */
public class Characteristics {

    /** list of Clothes and their descriptors */
    public enum Clothes implements Choiceable {
        // TODO: add full list of clothes and functionality
        PAJAMAS("Pajamas",
                "You shouldn't leave the house like this, you are already considered weird, no point and pointing it out even more."),
        FULL_ARMOR("Full suit of armor",
                "Heavy, loud, and unwieldy, good for taking a hit but bad for sneaking and running."),
        CLOAK("Travalers cloak", "Light and fast, good for agility and sneaking but won't block much damage.");

        private String name;
        private String text;
        private static final Font FONT = new Font();

        Clothes(String name, String text) {
            this.name = name;
            this.text = text;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getText() {
            return text;
        }

        @Override
        public Font getFont() {
            return FONT;
        }

        @Override
        public Enum<?> getChoice(SaveFile saveFile) {
            return saveFile.getPlayerCharacter().getClothes();
        }

        @Override
        public void setChoice(SaveFile saveFile) {
            saveFile.getPlayerCharacter().setClothes(this);
        }
    }
}
