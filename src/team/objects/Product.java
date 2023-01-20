package team.objects;

public abstract class Product {
    private String name;
    private int amount;
    private double price;

    public  Product(){}

    public Product(String n) {
        this.name = n;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (amount < 0){
            System.out.println("No puede asignar una cantidad negativa");
            return;
        }
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0){
            System.out.println("No se puede colocar un precio negativa");
            return;
        }
        this.price = price;
    }


    @Override
    public String toString() {
        return this.name + " - " + this.amount + " - " + this.price;
    }
}
