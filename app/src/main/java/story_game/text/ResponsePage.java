package story_game.text;

import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;

public abstract class ResponsePage extends Page {
    // The page to return to after completing dialogue 
    protected Page targetPage;
    
    @Override
    public ButtonCustom[] getButtons() {
        
        return new ButtonCustom[] {new ContinueButton(getTexts(), targetPage)};
    }
}
