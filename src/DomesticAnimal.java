import java.util.Random;

public abstract class DomesticAnimal extends Animal{
    protected String ManufacturedProduct;
    protected int timeRequiredToProduct;
    protected int remainingLife;
    protected int OccupiedSpace;

    Random random = new Random();
    @Override
    protected void move() {
        int a = 1;
        if (random.nextInt(2) == 0){
            if (X == 6  ||  X == 1){
                a = -a;
            }
            X += a;
        }else {
            if (Y == 6  ||  Y == 1){
                a = -a;
            }
            Y += a;
        }
    }
}
