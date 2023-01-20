package team.controllers;

import team.objects.Meat;
import team.objects.Potato;
import team.objects.Product;
import team.objects.Rice;
import team.storage.Database;
import team.views.View;

import java.util.List;

public class Register {
    private Database database;

    public Register() {
        database = new Database();
    }

    // Inicia el proceso de la registradora
    public void register() {
        int option;
        do {
            View.showHeaderPricipal();
            View.showMenuPrincipal();
            View.showGetOption();
            option = View.getOption();
            switch (option) {
                case 1:
                    buy();
                    break;
                case 2:
                    sale();
                    break;
                case 3:
                    showStock();
                    break;
                case 4:
                    showPurChases();
                    break;
                case 5:
                    showSales();
                    break;
                case 6:
                    View.showThanks();
                    System.exit(0);
                    break;
                default:
                    View.showInvalidOption();
            }
        }while (option >= 1 && option <= 6);
    }

    private void buy() {
        View.showBuyHeader();
        int option;
        do {
            View.showGetOption();
            option = View.getOption();
            if (option >= 1 && option <= 3) {
                buyProduct(option);
            } else if (option == 4) {
                View.showGetBack("Compras");
                return;
            } else {
                View.showInvalidOption();
            }
        }while (option < 1 || option > 4);
    }

    private void buyProduct(int option) {
        Product product = null;
        switch (option) {
            case 1:
                product = new Potato("Sabanera");
                break;
            case 2:
                product = new Rice("Una marca");
                break;
            case 3:
                product = new Meat("Lomo fino");
                break;
            default:
                View.showInvalidOption();
        }
        View.showGetAmount();
        int amount = View.getAmount();
        View.showGetPrice();
        double price = View.getPrice();

        product.setAmount(amount);
        product.setPrice(price);
        database.buy(product);
    }

    private void showStock() {
        View.showStockHeader();
        View.showItemsStock(database.getAll());
        View.showAnyKey();
        View.getOption();
    }

    private void sale() {
        View.showSaleHeader();
        int option;
        do {
            View.showGetOption();
            option = View.getOption();
            if (option >= 1 && option <= 3) {
                saleProduct(option);
            } else if (option == 4) {
                View.showGetBack("Ventas");
                return;
            } else {
                View.showInvalidOption();
            }
        }while (option < 1 || option > 4);
    }

    private void saleProduct(int option) {
        Product product = null;
        if (option < 1 || option >3) {
            View.showInvalidOption();
            return;
        }

        product = database.getByIndex(option - 1);
        View.showGetAmount();
        int amount = View.getAmount();
        if (product.getAmount() < amount) {
            View.showInavlidAmount();
            return;
        }
        product.setAmount(amount);
        database.sale(product);
    }

    private void showPurChases() {
        List<Product> listado = database.getPurchases();
        View.showBuyListHeader();
        View.showPurchases(listado);
    }

    private void showSales() {
        List<Product> listado = database.getSales();
        View.showSaleListHeader();
        View.showSales(listado);
    }
}
