package validate;

import Utils.Constant;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validate {
    Scanner sc = new Scanner(System.in);

    public String validateId() {
        String id;
        do {
            System.out.print("Input product id: ");
            id = sc.nextLine();
            if (id.matches(Constant.REGEX_ID)) {
                break;
            } else {
                System.out.println("ID is not in the correct format (id must have 3 or more digits)");
            }

        } while (true);
        return id;
    }

    public String validateName() {
        String name;
        do {
            System.out.print("Input product name: ");
            name = sc.nextLine();
            if (name.matches(Constant.REGEX_NAME)) {
                break;
            } else {
                System.out.println("Product name is not in correct format (name must have 6-8 words)");
            }
        } while (true);
        return name;
    }

    public int validateQuantity() {
        int quantity;
        do {
            System.out.print("Input product quantity: ");
            try {
                quantity = sc.nextInt();
                if (quantity < 0 || quantity > 100) {
                    System.out.println("The quantity must be less than 100 and greater than 0");
                } else return quantity;

            } catch (InputMismatchException e) {
                System.out.println("Please intput number");
                sc.nextLine();
            }
        }
        while (true);
    }

    public int validatePrice() {
        int price;
        do {
            System.out.print("Input product price: ");
            try {
                price = sc.nextInt();
                if (price < 0 || price > 1000) {
                    System.out.println("Price is less than 1000 and greater than 0");
                } else return price;

            } catch (InputMismatchException e) {
                System.out.println("Please intput number");
                sc.nextLine();
            }
        }
        while (true);
    }

    public int inputChoice() {
        int choice;
        try {
            choice = sc.nextInt();
            sc.nextLine();
            return choice;
        } catch (InputMismatchException e) {
            System.out.println("Vui lòng nhập số");
            sc.nextLine();
        }
        return -1;
    }
}
