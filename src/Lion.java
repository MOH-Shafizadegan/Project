import java.util.Random;

public class Lion extends WildAnimal{
    public Lion() {
        this.cageLevel = 0;
        this.price = 300;
        this.X = random.nextInt(6)+1;
        this.Y = random.nextInt(6)+1;
        this.cageLevelRequired = 3;
        this.OccupiedSpace = 15;
        this.name = "Lion";
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
