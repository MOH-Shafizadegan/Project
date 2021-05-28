import java.util.Random;

public class Bear extends WildAnimal{
    public Bear() {
        this.cageLevel = 0;
        this.price = 400;
        this.X = random.nextInt(6)+1;
        this.Y = random.nextInt(6)+1;
        this.cageLevelRequired = 4;
        this.OccupiedSpace = 15;
        this.name = "Bear";
    }

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
