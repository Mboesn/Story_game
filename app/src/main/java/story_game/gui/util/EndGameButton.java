package story_game.gui.util;

import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import story_game.gui.window.GameWindow;
import story_game.save_mechanics.achievements.AchievementsContainer;

public class EndGameButton extends ButtonCustom {
    private OnClickFunction onClickFunction;

    /**
     * 
     * @param text
     * @param achievementChecks
     */
    @SuppressWarnings("deprecation")
    public EndGameButton(String text, CompletedAchievementCheck... achievementChecks) {
        super(text);
        setOnMouseClicked(e -> {
            if (onClickFunction != null) {
                onClickFunction.onClick();
            }
            AchievementsContainer.CheckAchievements(achievementChecks);
            GameWindow.unsafeClose = true;
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
        });
    }

    /**
     * Sets a function to be called before checking achievements.
     * 
     * @param onClickFunction Function to call before checking achievements.
     * @return This object
     */
    public EndGameButton setOnClickFunction(OnClickFunction onClickFunction) {
        this.onClickFunction = onClickFunction;
        return this;
    }
}
