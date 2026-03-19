package story_game.save_mechanics;

import story_game.save_mechanics.Characteristics.Race;

public class PlayerCharacter {
    private Race race = Race.HUMAN;
    private int age = 42;

    public PlayerCharacter() {
    }

    public Race getRace() {
        return this.race;
    }

    public int getAge() {
        return this.age;
    }

    public String getString() {
        return "Race: " + getRace().getName() + "Age: " + getAge();
    }
}
