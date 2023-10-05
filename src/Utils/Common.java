package Utils;

import validate.Validate;

public class Common {
    Validate validate = new Validate();

    public String chooseType() {
        String type;
        System.out.println("=====>>> Choose Type <<<======");
        System.out.println("\t\t1. Tobaco \n\t\t2. Milk");
        int choice = validate.inputChoice();
        switch (choice) {
            case 1:
                type = "Tobaco";
                break;
            case 2:
                type = "Milk";
                break;
            default:
                type = "None";
        }
        return type;
    }
}
