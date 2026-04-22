package story_game.save_mechanics;

import story_game.text.Font;

public interface Choiceable {

    public String getName();

    public String getText();

    public Font getFont();

    public Enum<?> getChoice(SaveFile saveFile);

    public void setChoice(SaveFile saveFile);
}
