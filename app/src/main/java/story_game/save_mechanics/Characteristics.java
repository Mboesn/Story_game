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
        CLOAK("traveler's cloak", "Light and fast, good for agility and sneaking but won't block much damage.");

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
            return saveFile.getPlayerCharacter().getClothing();
        }

        @Override
        public void setChoice(SaveFile saveFile) {
            saveFile.getPlayerCharacter().setClothing(this);
        }
    }

    /** list of Weapons and their descriptors */
    public enum Weapons implements Choiceable {
        // TODO: add full list of Weapons and functionality
        NONE("Unarmed",
                "Great for pacifism and seeming non threatening but if your looking to get in a brawl prepare to get beat."),
        DAGGER("Dagger",
                "Small and shiny, much like you, fairly easy to conceal and can cut through someone's stomach if need be but you need to be right in their face."),
        BOW_AND_ARROW("Bow and arrow",
                "Not your typical item for a Goblin but one you know how to use, great for range but makes you stick out like a sore thumb and isn't going to pierce as much as a dagger.");

        private String name;
        private String text;
        private static final Font FONT = new Font();

        Weapons(String name, String text) {
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
            return saveFile.getPlayerCharacter().getWeapon();
        }

        @Override
        public void setChoice(SaveFile saveFile) {
            saveFile.getPlayerCharacter().setWeapon(this);
        }
    }
}
