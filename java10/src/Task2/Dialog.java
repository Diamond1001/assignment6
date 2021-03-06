package Task2;

public abstract class Dialog {
    abstract Button createButton();

    void render() {
        Button okButton = createButton();
        okButton.onClick("something");
        okButton.render();
    }
}
