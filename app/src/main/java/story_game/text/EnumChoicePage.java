package story_game.text;

import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;
import story_game.save_mechanics.Choiceable;
import story_game.save_mechanics.SaveFile;

public abstract class EnumChoicePage<T extends Enum<T> & Choiceable> extends Page {

    private Class<T> choicesEnum;
    private String chooseText;
    private String currentChoiceText;

    protected EnumChoicePage(Class<T> choicesEnum, String chooseText, String currentChoiceText) {
        this.choicesEnum = choicesEnum;
        this.chooseText = chooseText;
        this.currentChoiceText = currentChoiceText;
    }

    @Override
    public Text[] getTexts(SaveFile saveFile) {
        String textString;
        T[] choices = choicesEnum.getEnumConstants();
        textString = chooseText + " \n\n";
        for (int i = 0; i < choices.length; i++) {
            if (choices[i] == choices[i].getChoice(saveFile))
                textString += currentChoiceText + "     ";
            textString += choices[i].getName() + ": " + choices[i].getText() + "\n\n";
        }
        Text[] texts = new Text[] {
                new Text(textString, choices[0].getFont())
        };
        return texts;
    }

    @Override
    public ButtonCustom[] getButtons(SaveFile saveFile) {
        ButtonCustom[] buttons = new ButtonCustom[] {
                new ContinueButton(getTexts(saveFile)).setOnClickFunction(() -> {

                }),
                new ContinueButton(getTexts(saveFile))
        };
        return buttons;
    }
}
