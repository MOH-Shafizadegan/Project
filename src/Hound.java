import java.util.Random;

public class Hound extends Temp{
    Random random = new Random();
    public Hound() {
        this.price = 100;
        this.X = random.nextInt(6)+1;
        this.Y = random.nextInt(6)+1;
        this.name = "Hound";
    }

}
