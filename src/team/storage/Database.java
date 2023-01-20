package team.storage;

import team.objects.Meat;
import team.objects.Potato;
import team.objects.Product;
import team.objects.Rice;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private Product[] products;
    private List<Product> purchases;
    private List<Product> sales;

    public Database() {
        products = new Product[3];
        Product potato = new Potato("Sabanera");
        Product rice = new Rice("Una marca");
        Product meat = new Meat("Lomo fino");

        products[0] = potato;
        products[1] = rice;
        products[2] = meat;

        purchases = new ArrayList<>();
        sales = new ArrayList<>();
    }

    public Product getByIndex(int i) {
        if (i < 0 || i > 2) {
            System.out.println("Índice no válido!");
            return null;
        }
        return products[i];
    }

    public Product[] getAll() {
        return products;
    }

    public void buy(Product product) {
        Product temp;
        switch (product.getClass().getSimpleName()) {
            case "Potato":
                temp = products[0];
                break;
            case "Rice":
                temp = products[1];
                break;
            case "Meat":
                temp = products[2];
                break;
            default:
                System.out.println("No Válido");
                return;
        }
        temp.setAmount(temp.getAmount() + product.getAmount());
        temp.setPrice(product.getPrice());
        purchases.add(product);
    }

    public void sale(Product product) {
        Product temp;
        switch (product.getClass().getSimpleName()) {
            case "Potato":
                temp = products[0];
                break;
            case "Rice":
                temp = products[1];
                break;
            case "Meat":
                temp = products[2];
                break;
            default:
                System.out.println("No Válido");
                return;
        }
        temp.setAmount(temp.getAmount() - product.getAmount());
        product.setPrice(temp.getPrice() * 1.25);
        sales.add(product);
    }

    public List<Product> getPurchases() {
        return purchases;
    }

    public List<Product> getSales() {
        return sales;
    }
}
