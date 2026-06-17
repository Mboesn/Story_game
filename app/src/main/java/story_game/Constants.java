package story_game;

import java.time.format.DateTimeFormatter;

import story_game.text.CustomText;
import story_game.text.TextType;

// This class holds all final static constants used throughout the code 
public final class Constants {
    public static final String GAME_NAME = "Super Cool Game";
    public static final double DEFAULT_BUTTON_MIN_WIDTH = 200;
    public static final CustomText KINGDOM_NAME = new CustomText("Chestnut Kingdom", TextType.LOCATION);
    public static final CustomText TOWN_NAME = new CustomText("Town of Grimeguard", TextType.LOCATION);
    public static final CustomText MAIN_CHARACTER_NAME = new CustomText("Gobby McGobface", TextType.NAME);
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
}
