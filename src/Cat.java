import java.util.Random;

public class Cat extends Temp{
    Random random = new Random();
    public Cat() {
        this.price = 150;
        this.X = random.nextInt(6)+1;
        this.Y = random.nextInt(6)+1;
        this.name = "Cat";
    }
}
