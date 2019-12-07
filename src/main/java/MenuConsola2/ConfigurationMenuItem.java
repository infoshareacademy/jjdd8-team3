package MenuConsola2;

import MenuConsola2.AbstractMenuItem;

public class ConfigurationMenuItem extends AbstractMenuItem {


    private static final String LABEL = "pierwsza opcja";

    public ConfigurationMenuItem() {
        super(LABEL);
    }

    @Override
    public void execute(int i) {
        if(i > 0 && i <= 4){

        } else {
            System.out.println("ZLA OPCJA");
        }
    }
}
