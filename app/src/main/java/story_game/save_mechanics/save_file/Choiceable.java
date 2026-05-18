package story_game.save_mechanics.save_file;

/**
 * This interface defines an enum that will be displayed by the game as a list
 * allowing the player to choice which value they want from the automatically
 * generated list.
 */
public interface Choiceable {

    /**
     * @return The name to display of a given choice
     */
    public String getName();

    /**
     * @return The text used to describe the given choice to the player
     */
    public String getText();

    /**
     * @param saveFile current temporary save file used by the GameWindow class.
     *                 used to retrieve and edit data in the save file.
     * @return the current selected choice from the given save file
     */
    public Enum<?> getChoice(SaveFile saveFile);

    /**
     * Set the given choice in the given save file
     * 
     * @param saveFile current temporary save file used by the GameWindow class.
     *                 used to retrieve and edit data in the save file.
     */
    public void setChoice(SaveFile saveFile);
}
