import java.util.Random;

public class Tiger extends WildAnimal{
    Random random =new Random();

    public Tiger() {
        this.cageLevel = 0;
        this.price = 500;
        this.X = random.nextInt(6)+1;
        this.Y = random.nextInt(6)+1;
        this.cageLevelRequired = 4;
        this.OccupiedSpace = 15;
        this.name = "Tiger";
    }

    @Override
    protected void move() {
        int a = 2;
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
