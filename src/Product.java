public class Product {
    String name;
    int sellingPrice;
    int barnSpace;
    TIME disappearTime;


    public Product(String name, int sellingPrice, int barnSpace, TIME disappearTime) {
        this.name = name;
        this.sellingPrice = sellingPrice;
        this.barnSpace = barnSpace;
        this.disappearTime = disappearTime;
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Product))
            return false;
        Product product = (Product) o;
        return product.name.equals(this.name);
    }
}
