package story_game.save_mechanics;

import story_game.save_mechanics.Characteristics.Race;

// This class holds all data pertaining to the character of a specific save file
public class PlayerCharacter {
    private Race race = Race.HUMAN;
    private int age;

    public PlayerCharacter() {
    }

    public Race getRace() {
        return this.race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Race: " + getRace().getName() + "Age: " + getAge();
    }
}
