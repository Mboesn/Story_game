package story_game.gui.controllers.save_menu;

import java.time.LocalDateTime;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import story_game.Constants;
import story_game.gui.controllers.game.GameCtrl;
import story_game.gui.util.FXMLPaths;
import story_game.gui.util.PopupHandler;
import story_game.gui.util.StageHandler;
import story_game.save_mechanics.SaveHandler;
import story_game.save_mechanics.save_file.SaveFile;

/**
 * This window lists all available saves, allowing to load a new one or save the
 * current one. Do not load this controller from here, use SaveMenuFunctions
 * instead.
 */
public class SaveMenuCtrl {
    // The type of menu to load, set before loading.
    protected static SaveMenuType saveMenuType = SaveMenuType.LOAD_GAME;
    // The save file to save if saving.
    private static SaveFile saveFile = new SaveFile();
    @FXML
    public StackPane saveMenuPane;
    @FXML
    public GridPane saveButtons;

    // The save file to start from when listing files in grid. Change based on grid
    // selections.
    private int saveCountStart = 0;

    // When saving or loading set what type of save to save/load.
    private SaveType saveType = SaveType.REGULAR_SAVE;

    // How many buttons are in the grid.
    private static int gridPaneSaveCount;

    @FXML
    public void initialize() {
        updateGrid("0");
        gridPaneSaveCount = saveButtons.getChildren().size();
    }

    /** The type of save menu to open */
    public enum SaveMenuType {
        NEW_GAME,
        LOAD_GAME,
        SAVE_GAME;
    }

    /** The type of save to load/save to */
    public enum SaveType {
        REGULAR_SAVE("Save"),
        AUTO_SAVE("Auto Save"),
        QUICK_SAVE("Quick Save");

        private String saveName;

        private SaveType(String saveName) {
            this.saveName = saveName;
        }

        public String getSaveName() {
            return saveName;
        }
    }

    /**
     * Change the save files on the grid.
     * 
     * @param gridButtonId The Id of the button that updated the grid.
     */
    private void updateGrid(String gridButtonId) {
        switch (gridButtonId) {
            case "A":
                saveCountStart = 0;
                saveType = SaveType.AUTO_SAVE;
                break;
            case "Q":
                saveCountStart = 0;
                saveType = SaveType.QUICK_SAVE;
                break;
            default:
                saveCountStart = Integer.parseInt(gridButtonId) * gridPaneSaveCount;
                saveType = SaveType.REGULAR_SAVE;
                break;
        }

        String saveName = saveType.getSaveName();
        for (Node saveBtn : saveButtons.getChildren()) {
            if (saveBtn instanceof Button btn) {
                String saveButtonId = btn.getId().replaceAll("save", "");
                int saveNumber = saveCountStart + Integer.parseInt(saveButtonId);
                SaveFile save = SaveHandler.loadGame(saveName + saveNumber);
                // Add current game location to the save file
                if (save != null) {
                    String location = save.getCurrentPage().getClass().toString()
                            .replace("class story_game.text.pages.", "");
                    location = location.split("\\.")[0].toLowerCase();
                    location = getLocationName(location);

                    btn.setText(saveName + " " + saveNumber + "\n" + location + "\n" + save.getSaveDate());
                    saveBtn.setDisable(false);
                } else {
                    btn.setText(saveName + " " + saveNumber + "\n" + "Empty save");
                    // Set disable if save file empty and loading a game.
                    saveBtn.setDisable(saveMenuType == SaveMenuType.LOAD_GAME);
                }
            }
        }
    }

    /**
     * @param packageName The name of the package of the current page.
     * @return The location name to display to the user.
     */
    private String getLocationName(String packageName) {
        switch (packageName) {
            case "housescene":
                packageName = "House";
                break;
            case "outsidescene":
                packageName = "Outside";
                break;
            default:
                packageName = "unknown";
                break;
        }
        return packageName;
    }

    /**
     * Updates the save grid based on the Id of the button that called this method.
     */
    @FXML
    public void updateGrid(ActionEvent event) {
        Button gridBtn = (Button) event.getSource();
        String gridButtonId = gridBtn.getId().replaceAll("grid", "");
        updateGrid(gridButtonId);
    }

    /**
     * Saves or loads the save file (based on the SaveMenuType value). Launches the
     * game menu after saving/loading.
     */
    @FXML
    public void saveOrLoad(ActionEvent event) {
        Button saveBtn = (Button) event.getSource();
        String saveButtonId = saveBtn.getId().replaceAll("save", "");
        int saveNumber = saveCountStart + Integer.parseInt(saveButtonId);
        String saveName = saveType.getSaveName() + saveNumber;
        SaveFile buttonSaveFile = SaveHandler.loadGame(saveName);

        if (saveMenuType == SaveMenuType.LOAD_GAME) {
            launchGame(event, buttonSaveFile);
        } else {
            if (saveMenuType == SaveMenuType.NEW_GAME)
                saveFile = new SaveFile();
            // If overriding an existing save asks the user if they are sure.
            if (buttonSaveFile != null) {
                SaveOverrideConfirmationCtrl.overrideSaveFunction = () -> saveGame(saveFile, saveName, event);
                PopupHandler.loadPopup(FXMLPaths.SAVE_OVERRIDE_CONFIRMATION, event);
            } else {
                saveGame(saveFile, saveName, event);
            }
        }
    }

    /**
     * Saves the game on the newest quick-save/auto-save.
     * 
     * @param saveFile The save file to save.
     * @param saveType The save type.
     */
    protected static void quickSave(SaveFile saveFile, SaveType saveType) {
        if (saveType == SaveType.REGULAR_SAVE)
            return;
        // Goes through all the quick-saves/auto-saves and sets this value to the oldest
        // one or an empty one.
        String oldestQuickSave = saveType.getSaveName() + 1;
        SaveFile tempSave = SaveHandler.loadGame(oldestQuickSave);
        if (tempSave != null) {
            LocalDateTime oldestSaveTime = LocalDateTime.parse(tempSave.getSaveDate(), Constants.formatter);
            for (int i = 2; i <= gridPaneSaveCount; i++) {
                String tempSaveName = saveType.getSaveName() + i;
                tempSave = SaveHandler.loadGame(tempSaveName);
                if (tempSave == null) {
                    oldestQuickSave = tempSaveName;
                    break;
                }
                LocalDateTime tempSaveTime = LocalDateTime.parse(tempSave.getSaveDate(), Constants.formatter);
                if (tempSaveTime.isBefore(oldestSaveTime)) {
                    oldestQuickSave = tempSaveName;
                    break;
                }
            }
        }
        saveFile.updateSaveDate();
        SaveHandler.saveFile(saveFile, oldestQuickSave);
    }

    /**
     * Loads the newest quick-save.
     */
    protected static void quickLoad() {
        // Goes through all quick-saves and finds the newest one.
        String newestQuickSave = "";
        LocalDateTime newestSaveTime = LocalDateTime.now();
        for (int i = 1; i <= gridPaneSaveCount; i++) {
            String tempSaveName = SaveType.QUICK_SAVE.getSaveName() + i;
            SaveFile tempSave = SaveHandler.loadGame(tempSaveName);
            if (tempSave != null) {
                if (newestQuickSave.isEmpty()) {
                    newestQuickSave = tempSaveName;
                    newestSaveTime = LocalDateTime.parse(tempSave.getSaveDate(), Constants.formatter);
                } else {
                    LocalDateTime tempSaveTime = LocalDateTime.parse(tempSave.getSaveDate(), Constants.formatter);
                    if (tempSaveTime.isAfter(newestSaveTime)) {
                        newestQuickSave = tempSaveName;
                        newestSaveTime = LocalDateTime.parse(tempSave.getSaveDate(), Constants.formatter);
                    }
                }
            }
        }
        SaveFile tempSave = SaveHandler.loadGame(newestQuickSave);
        if (tempSave != null)
            GameCtrl.setupGameScene(tempSave);
    }

    /**
     * Saves the game and launches the game window.
     * 
     * @param saveFile The save file to save.
     * @param saveName The name to give to the save file.
     * @param event    The event that called this action.
     */
    private void saveGame(SaveFile saveFile, String saveName, ActionEvent event) {
        saveFile.updateSaveDate();
        SaveHandler.saveFile(saveFile, saveName);
        launchGame(event, saveFile);
        back();
    }

    /**
     * Launches the game window.
     * 
     * @param event    The event that called this action.
     * @param saveFile The save file to use for the game.
     */
    private void launchGame(ActionEvent event, SaveFile saveFile) {
        try {
            Scene currentScene = StageHandler.stage.getScene();
            Parent root = FXMLLoader.load(getClass().getResource(FXMLPaths.GAME.getPath()));
            GameCtrl.setupGameScene(saveFile);
            currentScene.setRoot(root);
        } catch (Exception e) {
            System.out.println("Failed to launch game window.\nError: " + e);
        }
    }

    /**
     * Closes the save menu.
     */
    @FXML
    public void back() {
        PopupHandler.closePopup(saveMenuPane);
    }
}
