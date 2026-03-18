package story_game;

import story_game.Characteristics.Race;

public class PlayerCharacter {
    private Race race = Race.HUMAN;
    private int age = 69;

    public PlayerCharacter() {
    }

    public String getRaceName() {
        return race.getName();
    }

    public int getAge() {
        return this.age;
    }

    public String getString() {
        return "Race: " + getRaceName() + "Age: " + getAge();
    }
}
