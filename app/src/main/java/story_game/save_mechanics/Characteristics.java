package story_game.save_mechanics;

/** List of data that can define the players character */
public class Characteristics {
    /** list of races and their attributes */
    public enum Race {
        HUMAN("Human");

        private String name;

        private Race(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }
}
