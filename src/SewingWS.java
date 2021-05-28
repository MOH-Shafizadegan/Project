public class SewingWS extends WorkShop{

    public SewingWS() {
        this.level = 1;
        this.cost = 400;
        this.productionTime = new TIME(6);
        this.input = new Product("cloth",50,2,new TIME(5));
        this.output = new Product("shirt",100,4,new TIME(6));
    }

    @Override
    Product producing() {
        return output;
    }

}
