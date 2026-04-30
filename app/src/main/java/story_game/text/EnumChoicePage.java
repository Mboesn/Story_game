package story_game.text;

import story_game.gui.util.ButtonCustom;
import story_game.gui.util.ContinueButton;
import story_game.save_mechanics.Choiceable;
import story_game.save_mechanics.SaveFile;

public abstract class EnumChoicePage<T extends Enum<T> & Choiceable> extends Page {

    private transient T[] choices;
    private transient String chooseText;
    private transient String currentChoiceText;
    private transient Page targetPage;
    private transient ButtonCustom[] customButton;

    // TODO: change save system to only save id so transient will not be required

    /**
     * This class displays to the player a given enum of choices and lets them
     * select one and then saves it in the save file
     * 
     * @param choicesEnum       The enum of which it will display the choices.
     * @param chooseText        The text to display before the choices instructing
     *                          the player of the choice
     * @param currentChoiceText The text that is displayed before whatever choice is
     *                          currently selected.
     * @param targetPage        Page to switch to after completing all text
     *                          elements.
     * @param customButton      Any extra buttons to add to the page.
     */
    protected EnumChoicePage(Class<T> choicesEnum, String chooseText, String currentChoiceText, Page targetPage,
            ButtonCustom... customButton) {
        this.choices = choicesEnum.getEnumConstants();
        this.chooseText = chooseText;
        this.currentChoiceText = currentChoiceText;
        this.targetPage = targetPage;
        this.customButton = customButton;
    }

    /**
     * This class displays to the player a given enum of choices and lets them
     * select one and then saves it in the save file
     * 
     * @param choicesEnum  The enum of which it will display the choices.
     * @param chooseText   The text to display before the choices instructing
     *                     the player of the choice
     * @param targetPage   Page to switch to after completing all text
     *                     elements.
     * @param customButton Any extra buttons to add to the page.
     */
    protected EnumChoicePage(Class<T> choicesEnum, String chooseText, Page targetPage,
            ButtonCustom... customButton) {
        this(choicesEnum, chooseText, "", targetPage, customButton);
    }

    /**
     * This class displays to the player a given enum of choices and lets them
     * select one and then saves it in the save file
     * 
     * @param choicesEnum       The enum of which it will display the choices.
     * @param chooseText        The text to display before the choices instructing
     *                          the player of the choice
     * @param currentChoiceText The text that is displayed before whatever choice is
     *                          currently selected.
     * @param targetPage        Page to switch to after completing all text
     *                          elements.
     */
    protected EnumChoicePage(Class<T> choicesEnum, String chooseText, String currentChoiceText, Page targetPage) {
        this(choicesEnum, chooseText, currentChoiceText, targetPage, (ButtonCustom[]) null);
    }

    /**
     * This class displays to the player a given enum of choices and lets them
     * select one and then saves it in the save file
     * 
     * @param choicesEnum The enum of which it will display the choices.
     * @param chooseText  The text to display before the choices instructing
     *                    the player of the choice
     * @param targetPage  Page to switch to after completing all text
     *                    elements.
     */
    protected EnumChoicePage(Class<T> choicesEnum, String chooseText, Page targetPage) {
        this(choicesEnum, chooseText, "", targetPage, (ButtonCustom[]) null);
    }

    @Override
    public Text[] getTexts(SaveFile saveFile) {
        String textString = "";
        // If there is text to desplay before the choices add it on top.
        if (!chooseText.equals(""))
            textString = chooseText + " \n\n";
        for (int i = 0; i < choices.length; i++) {
            // If the current choice is selected indicate to the player if a indication is
            // provided.
            if (choices[i] == choices[i].getChoice(saveFile) && !currentChoiceText.equals(""))
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
        int choicesCount = choices.length;
        int buttonCount = choicesCount;
        if (customButton != null)
            buttonCount += customButton.length;

        ButtonCustom[] buttons = new ButtonCustom[buttonCount];

        for (int i = 0; i < buttonCount; i++) {
            // if you haven't finished adding a button for each choice add a button for each
            // choice, else add the custom buttons.
            if (i < choicesCount) {
                // this line is needed because of lambda closure
                final int index = i;
                buttons[i] = new ContinueButton(targetPage, choices[i].getName()).setOnClickFunction(() -> {
                    choices[index].setChoice(saveFile);
                });
            } else {
                buttons[i] = customButton[i - choicesCount];
            }
        }
        return buttons;
    }
}
