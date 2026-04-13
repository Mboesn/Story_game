package story_game;

import story_game.text.Page;

public class GameHandler {
    private static Page currentPage;

    public static Page getCurrentPage() {
        return currentPage;
    }

    public static void setCurrentPage(Page currentPage) {
        GameHandler.currentPage = currentPage;
    }
}
