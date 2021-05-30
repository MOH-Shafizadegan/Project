import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Levels {
    String status;
    int levelNum;
    File levelFile = new File("src\\missions.txt");
    TIME time = new TIME(0);
    TIME finishTime;
    int coins;
    TIME goldenFinishTime;
    TIME silverFinishTime;
    TIME bronzeFinishTime;
    int goldenGiftCoin;
    int silverGiftCoin;
    int bronzeGiftCoin;
    HashMap<String,Integer> wildAnimals;
    HashMap<String,Integer> tasks;

    public Levels(int levelNum) {
        this.levelNum = levelNum;
        try {
            Scanner scanner = new Scanner(levelFile);
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                if (line.contains("LevelCoins")){
                    String[] parts = line.split(",");
                    this.coins = Integer.parseInt(parts[levelNum]);
                }
                String initWildAnimal = "WildAnimalLevel"+levelNum;
                if (line.contains(initWildAnimal)){
                    String[] parts = line.split(",");
                    for (int i = 1; i < parts.length; i++) {
                        String[] parts2 = parts[i].split("-");
                        wildAnimals.put(parts2[0], Integer.valueOf(parts2[1]));
                    }
                }
                String initTasks = "TasksLevel"+levelNum;
                if (line.contains(initTasks)){
                    String[] parts = line.split(",");
                    for (int i = 1; i < parts.length; i++) {
                        String[] parts2 = parts[i].split("-");
                        tasks.put(parts2[0],Integer.parseInt(parts2[1]));
                    }
                }
                String initFinishTime = "LevelFinishTime"+levelNum;
                if (line.contains(initFinishTime)){
                    String[] parts = line.split(",");
                    this.bronzeFinishTime = new TIME(Integer.parseInt(parts[1]));
                    this.silverFinishTime = new TIME(Integer.parseInt(parts[2]));
                    this.goldenFinishTime = new TIME(Integer.parseInt(parts[3]));
                }
                String initGiftCoins = "giftCoinsLevel"+levelNum;
                if (line.contains(initGiftCoins)){
                    String[] parts = line.split(",");
                    this.bronzeGiftCoin = Integer.parseInt(parts[1]);
                    this.silverGiftCoin = Integer.parseInt(parts[2]);
                    this.goldenGiftCoin = Integer.parseInt(parts[3]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
