public class Mill extends WorkShop{

    public Mill() {
        this.level = 1;
        this.cost = 150;
        this.productionTime = new TIME(4);
        this.input = new Product("egg",15,1,new TIME(4));
        this.output = new Product("flour",40,2,new TIME(5));
        this.name = "mill";
    }

    @Override
    Product producing() {
        return output;
    }

}
