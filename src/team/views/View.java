package team.views;

import team.objects.Product;

import java.util.List;
import java.util.Scanner;

public class View {
    public static void showHeaderPricipal() {
        System.out.println("\t*********************");
        System.out.println("\t* CAJA REGISTRADORA *");
        System.out.println("\t*********************");
    }

    public static void showMenuPrincipal() {
        System.out.println("\t\t1. Comprar");
        System.out.println("\t\t2. Vender");
        System.out.println("\t\t3. Inventario");
        System.out.println("\t\t4. Compras");
        System.out.println("\t\t5. Ventas");
        System.out.println("\t\t6. Salir");
    }

    public static void showGetOption() {
        System.out.print("\t\tDigite la opción: ");
    }

    public static void showGetAmount() {
        System.out.print("\t\tDigite la cantidad: ");
    }

    public static void showGetPrice() {
        System.out.print("\t\tDigite el precio: ");
    }

    public static int getOption() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    public static int getAmount() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    public static double getPrice() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextDouble();
    }

    public static void showBuyHeader() {
        System.out.println("\t*********************");
        System.out.println("\t*  MENU DE COMPRAS  *");
        System.out.println("\t*********************");
        showItemsMenu();
    }

    public static void showSaleHeader() {
        System.out.println("\t*********************");
        System.out.println("\t*  MENU DE VENTAS   *");
        System.out.println("\t*********************");
        showItemsMenu();
    }

    public static void showStockHeader() {
        System.out.println("\t*******************************************************");
        System.out.println("\t*                I N V E N T A R I O                  *");
        System.out.println("\t*******************************************************");
        showItemsHeader();
    }

    public static void showItemsHeader() {
        System.out.println("\t* PRODUCTO\t | CANTIDAD\t | Vr UNITARIO\t | Vr TOTAL\t*");
    }

    public static void showBuyListHeader() {
        System.out.println("\t*******************************************************");
        System.out.println("\t*                   C O M P R A S                     *");
        System.out.println("\t*******************************************************");
        showItemsHeader();
    }

    public static void showSaleListHeader() {
        System.out.println("\t*******************************************************");
        System.out.println("\t*                    V E N T A S                      *");
        System.out.println("\t*******************************************************");
        showItemsHeader();
    }

    public static void showItemsMenu() {
        System.out.println("\t\t1. Papa");
        System.out.println("\t\t2. Arroz");
        System.out.println("\t\t3. Carne");
        System.out.println("\t\t4. Volver");
    }

    public static void showThanks() {
        System.out.println("Gracias por utilizar la aplicacion");
    }

    public static void showInvalidOption() {
        System.out.println("Opción no válidad");
    }

    public static void showGetBack(String name) {
        System.out.println("\tSaliendo del modulo..." + name);
    }

    public static void showAnyKey() {
        System.out.print("Digite cualquier numero para continuar: ");
    }

    public static void showItemsStock(Product[] products) {
        for (Product v : products) {
            System.out.println("\t* "+v.getName()+"\t| "+v.getAmount()+"\t| "+v.getPrice()+"\t| "+v.getAmount()*v.getPrice()+"\t*");
        }
    }

    public static void showInavlidAmount() {
        System.out.println("La cantidad no es validad");
    }

    public static void showPurchases(List<Product> listado) {
        for (Product v : listado) {
            System.out.println("\t* "+v.getName()+"\t| "+v.getAmount()+"\t| "+v.getPrice()+"\t| "+v.getAmount()*v.getPrice()+"\t*");
        }
    }

    public static void showSales(List<Product> listado) {
        for (Product v : listado) {
            System.out.println("\t* "+v.getName()+"\t| "+v.getAmount()+"\t| "+v.getPrice()+"\t| "+v.getAmount()*v.getPrice()*1.25+"\t*");
        }
    }
}
