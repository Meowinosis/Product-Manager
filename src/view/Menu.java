package view;

import Utils.Common;
import Utils.ReadAndWriteFile;
import manager.ProductManager;
import model.Product;
import validate.Validate;

import java.util.List;
import java.util.Scanner;

public class Menu {
    ProductManager pm = new ProductManager();
    Validate validate = new Validate();
    ReadAndWriteFile rw = new ReadAndWriteFile();
    Common common = new Common();

    public void showMenu() {
        do {
            System.out.println("=====>>> Product Menu <<<======");
            System.out.println("\t\t1. Add new Product \n\t\t2. Edit Product \n\t\t3. Remove Product\n\t\t4. Get all product \n\t\t5. Get products by name\n\t\t6. Get products by type \n\t\t7. Get products by id \n\t\t0. Exit");
            int choice = validate.inputChoice();
            switch (choice) {
                case 0:
                    rw.writeProductData(pm.getAll());
                    return;
                case 1:
                    showMenuAdd();
                    break;
                case 2:
                    showMenuEdit();
                    break;
                case 3:
                    showMenuRemove();
                    break;
                case 4:
                    getAll();
                    break;
                case 5:
                    getProductByName();
                    break;
                case 6:
                    getProductByType();
                    break;
                case 7:
                    getProductById();
                    break;
            }
        } while (true);
    }

    public void getAll() {
        for (Product p : pm.getAll()) {
            System.out.println(p);
        }
    }

    public void showMenuRemove(){
        String id;
        id = validate.validateId();
        if (pm.getById(id) == null) {
            System.out.println("Id is not existed");
        }else{
            pm.remove(id);
            System.out.println("Remove succeed");
        }
    }
    public void showMenuEdit() {
        String id;
        id = validate.validateId();
        if (pm.getById(id) == null) {
            System.out.println("Id is not existed");
        }
        else{
            String name = validate.validateName();
            int price = validate.validatePrice();
            int quantity = validate.validateQuantity();
            String type = common.chooseType();
            Product p = new Product(id, name, price, quantity, type);
            pm.edit(id,p);
            System.out.println("Edit succeed");
        }
    }

    public void showMenuAdd() {
        String id;
        do {
            id = validate.validateId();
            if (pm.getById(id) != null) {
                System.out.println("Id existed");
            }
        } while (pm.getById(id) != null);
        String name = validate.validateName();
        int price = validate.validatePrice();
        int quantity = validate.validateQuantity();
        String type = common.chooseType();
        Product p = new Product(id, name, price, quantity, type);
        pm.add(p);
        System.out.println("Add succeed");
    }
    public void getProductByName(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input name: ");
        String name = sc.nextLine();
        List<Product> list = pm.getByAbsoluteName(name);
        if(list.isEmpty()){
            System.out.println("No product found");
        }else{
            for(Product p: list){
                System.out.println(p);
            }
        }
    }
    public void getProductByType(){
        String type = common.chooseType();
        List<Product> list = pm.getByType(type);
        if(list.isEmpty()){
            System.out.println("No product found");
        }else{
            for(Product p: list){
                System.out.println(p);
            }
        }
    }
    public void getProductById(){
        String id;
        id = validate.validateId();
        if (pm.getById(id) == null) {
            System.out.println("Id is not existed");
        }else{
            System.out.println(pm.getById(id));
        }
    }
}
