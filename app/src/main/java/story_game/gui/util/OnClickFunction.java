package story_game.gui.util;

/**
 * This interface is used in order to define additional function to be called
 * when pressing specific buttons.
 */
@FunctionalInterface
public interface OnClickFunction {
    /**
     * A function to be called when pressing a specific button
     */
    void onClick();
}
