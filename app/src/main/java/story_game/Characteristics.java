package story_game;


public class Characteristics {
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
