package manager;

import Utils.ReadAndWriteFile;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductManager implements IManager<Product> {
    List<Product> productList;
    ReadAndWriteFile rw = new ReadAndWriteFile();

    public ProductManager() {
        productList = rw.readProductData();
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public Product edit(String id, Product product) {
        Product p = getById(id);
        if (p != null) {
            p.setId(product.getId());
            p.setName(product.getName());
            p.setPrice(product.getPrice());
            p.setQuantity(product.getQuantity());
            p.setType(product.getType());
        }
        return p;
    }

    @Override
    public void remove(String id) {
        Product p = getById(id);
        if (p!=null){
            productList.remove(p);
        }
    }

    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public List<Product> getByAbsoluteName(String name) {
        List<Product> list = new ArrayList<>();
        for (Product p : productList) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                list.add(p);
            }
        }
        return list;
    }

    @Override
    public List<Product> getByType(String type) {
        List<Product> list = new ArrayList<>();
        for (Product p : productList) {
            if (p.getType().equals(type)) {
                list.add(p);
            }
        }
        return list;
    }

    @Override
    public Product getById(String id) {
        for (Product p : productList) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
}
