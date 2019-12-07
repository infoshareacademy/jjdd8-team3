package MenuConsola2;

public abstract class AbstractMenuItem {

    private String label;

    public AbstractMenuItem(String label) {
        this.label = label;
    }

    public abstract void execute(int i);
}
