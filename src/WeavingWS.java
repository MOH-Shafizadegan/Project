public class WeavingWS extends WorkShop{

    public WeavingWS() {
        this.level = 1;
        this.cost = 250;
        this.productionTime = new TIME(5);
        this.input = new Product("feather",20,1,new TIME(4));
        this.output = new Product("cloth",50,2,new TIME(5));
        this.name = "weaving";
    }

    @Override
    Product producing() {
        return output;
    }

}
