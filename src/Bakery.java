public class Bakery extends WorkShop{

    public Bakery() {
        this.level = 1;
        this.cost = 250;
        this.productionTime = new TIME(5);
        this.input = new Product("flour",40,2,new TIME(5));
        this.output = new Product("bread",80,4,new TIME(6));
        this.name = "bakery";
    }

    @Override
    Product producing() {
        return output;
    }

}
