package story_game.text;

public class Text {
    private String text;
    private Font font;
    
    public Text(String text, Font font) {
        this.text = text;
        this.font = font;
    }

    public Text(String text) {
        this(text, new Font());
    }

    public String getText() {
        return this.text;
    }

    public Font getFont() {
        return this.font;
    }
}
