import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.logging.Level;

public class Manager {

    Levels level;
    Barn barn = new Barn();
    private ArrayList<DomesticAnimal> domesticAnimalsList = new ArrayList<>();
    private ArrayList<WildAnimal> wildAnimalsList = new ArrayList<>();
    private ArrayList<Hound> houndsList = new ArrayList<>();
    private ArrayList<Grass> grassesList = new ArrayList<>();
    private ArrayList<Grass> removeGrassList = new ArrayList<>();
    private ArrayList<Animal> removeAnimalList = new ArrayList<>();
    private ArrayList<Product> productsList = new ArrayList<>();
    private ArrayList<Product> removeProductList = new ArrayList<>();
    private ArrayList<Cat> catsList = new ArrayList<>();
    private ArrayList<WorkShop> workShops = new ArrayList<>();

    public Manager(Levels level) {
        this.level = level;
    }

    public void eatGrass(){
        for (DomesticAnimal domesticAnimal : domesticAnimalsList) {
            for (Grass grass : grassesList) {
                if (grass.getX() == domesticAnimal.X  &&  grass.getY() == domesticAnimal.Y  &&  domesticAnimal.remainingLife <= 50){
                    domesticAnimal.remainingLife = 100;
                    removeGrassList.add(grass);
                }
            }
        }
        for (Grass grass : removeGrassList) {
            if (grassesList.contains(grass)){
                grassesList.remove(grass);
            }
        }
    }
    public void reduceLife(){
        for (DomesticAnimal domesticAnimal : domesticAnimalsList) {
            domesticAnimal.remainingLife -= 10;
            if (domesticAnimal.remainingLife <= 0){
                removeAnimalList.add(domesticAnimal);
            }
        }
        for (Animal animal : removeAnimalList) {
            if (domesticAnimalsList.contains(animal)){
                domesticAnimalsList.remove(animal);
            }
        }
    }
    public void destroyDomesticAnimalAndProduct(){
        for (WildAnimal wildAnimal : wildAnimalsList) {
            for (DomesticAnimal domesticAnimal : domesticAnimalsList) {
                if (wildAnimal.X == domesticAnimal.X  &&  wildAnimal.Y == domesticAnimal.Y){
                    removeAnimalList.add(domesticAnimal);
                }
            }
            for (Product product : productsList) {
                if (product.getX() == wildAnimal.X  &&  product.getY() == wildAnimal.Y){
                    removeProductList.add(product);
                }
            }
        }
        for (Product product : removeProductList) {
            if (productsList.contains(product))
                productsList.remove(product);
        }
        for (Animal animal : removeAnimalList) {
            if (domesticAnimalsList.contains(animal))
                domesticAnimalsList.remove(animal);
        }
    }
    public void destroyWildAnimal(){
        for (Hound hound : houndsList) {
            for (WildAnimal wildAnimal : wildAnimalsList) {
                if (hound.X == wildAnimal.X  &&  hound.Y == wildAnimal.Y){
                    removeAnimalList.add(hound);
                    removeAnimalList.add(wildAnimal);
                }
            }
        }
        for (Animal animal : removeAnimalList) {
            if (houndsList.contains(animal))
                houndsList.remove(animal);
            if (wildAnimalsList.contains(animal))
                wildAnimalsList.remove(animal);
        }

    }
    public void collectProducts(){
        for (Cat cat : catsList) {
            for (Product product : productsList) {
                if (product.getX() == cat.X  &&  product.getY() == cat.Y){
                    barn.setFreeSpace(barn.getFreeSpace()-product.getOccupiedSpace());
                }
            }
        }
    }
    public void produceGrass(int x, int y){
        Grass grass = new Grass(x,y);
        grassesList.add(grass);
    }
    public void buyAnimal(String name){

    }
    public void buyWorkshop(String name){
        for (WorkShop workShop : workShops) {
            if (workShop.name.equals(name)){
                System.out.println("You have bought this workshop before...");
                return;
            }
        }
        switch (name) {
            case "bakery" -> {
                Bakery bakery = new Bakery();
                if (level.coins >= bakery.getCost()){
                    workShops.add(bakery);
                    level.coins -= bakery.getCost();
                    System.out.println("Great! you bought a bakery." +
                            "now you can create bread from flour.");
                }
                else
                    System.out.println("Sorry! You don't have enough coins");
            }
            case "iceCreamSelling" -> {
                IceCreamSelling iceCreamSelling = new IceCreamSelling();
                if (level.coins >= iceCreamSelling.getCost()){
                    workShops.add(iceCreamSelling);
                    level.coins -= iceCreamSelling.getCost();
                    System.out.println("Great! you bought an ice cream selling." +
                            "now you can make ice cream with pocket milk.");
                }
                else
                    System.out.println("Sorry! You don't have enough coins");            }
            case "milkPackaging" -> {
                MilkPackaging milkPackaging = new MilkPackaging();
                if (level.coins >= milkPackaging.getCost()){
                    workShops.add(milkPackaging);
                    level.coins -= milkPackaging.getCost();
                    System.out.println("Great! you bought a milk packaging workshop." +
                            " now you can package milk.");
                }
                else
                    System.out.println("Sorry! You don't have enough coins");            }
            case "mill" -> {
                Mill mill = new Mill();
                if (level.coins >= mill.getCost()){
                    workShops.add(mill);
                    level.coins -= mill.getCost();
                    System.out.println("Great! you bought a mill." +
                            " now you can make flour with egg.");
                }
                else
                    System.out.println("Sorry! You don't have enough coins");            }
            case "sewing" -> {
                SewingWS sewingWS = new SewingWS();
                if (level.coins >= sewingWS.getCost()){
                    workShops.add(sewingWS);
                    level.coins -= sewingWS.getCost();
                    System.out.println("Great! you bought a sewing workshop." +
                            " now you can create shirt with cloth.");
                }
                else
                    System.out.println("Sorry! You don't have enough coins");            }
            case "weaving" -> {
                WeavingWS weavingWS = new WeavingWS();
                if (level.coins >= weavingWS.getCost()){
                    workShops.add(weavingWS);
                    level.coins -= weavingWS.getCost();
                    System.out.println("Great! you bought a weaving workshop." +
                            " now you can change feather to cloth.");
                }
                else
                    System.out.println("Sorry! You don't have enough coins");            }
        }
    }
    public void upgradeWorkshop(String name){
        for (WorkShop workShop : workShops) {
            if (workShop.name.equals(name)){
                if (level.coins >= workShop.getUpgradeCost()){
                    workShop.upgrading();
                    level.coins -= workShop.getUpgradeCost();
                    System.out.println("Perfect! "+workShop.name+" upgraded to level 2.");
                    return;
                }
                System.out.println("Sorry! you don't have enough coin");
                return;
            }
        }
        System.out.println("ERROR! workshop not found!...");
    }
    public void pickupProduct(int x, int y){

    }
    public void fillWaterBucket(){

    }
    public void planting(int x, int y){

    }
    public void startingWorkshop(String name){
        for (WorkShop workShop : workShops) {
            if (workShop.name.equals(name)){
                //if workshop's input product exist in the barn then
                workShop.setStartTime(level.time);
                System.out.println(workShop.name+" start working, your product will be ready by" +
                        workShop.productionTime.n+" TIME.");
                return;
            }
        }
    }
    public void checkWorkshops(){
        for (WorkShop workShop : workShops) {
            if (workShop.isProductReady(level.time)){
                Product product = workShop.producing();
                productsList.add(product);
                workShop.setStartTime(new TIME(0));
                System.out.println(workShop.name+" producing process finished." +
                        " your product is ready.");
            }
        }
    }
    public void cage(int x, int y){
        for (WildAnimal wildAnimal : wildAnimalsList) {
            if (wildAnimal.X == x  &&  wildAnimal.Y == y){
                wildAnimal.cageLevel++;
            }
        }
    }
    public void goingForwardTime(int n){

    }
    public void loadingProducts(String name){

    }
    public void unLoadingProducts(String name){

    }
    public void startTrip(){

    }
    public void checkTasks(){
        if (level.tasks.containsKey("Coin")){
            if (level.coins == level.tasks.get("Coin")){
                level.tasks.remove("Coin");
                System.out.println("Good! You complete a task. Your coins reach the desired amount.");
            }
        }
        for (DomesticAnimal domesticAnimal : domesticAnimalsList) {
            if (level.tasks.containsKey(domesticAnimal.name)){
                int animalNum = level.tasks.get(domesticAnimal.name) - 1;
                if (animalNum == 0)
                    level.tasks.remove(domesticAnimal.name);
                level.tasks.replace(domesticAnimal.name,animalNum);
            }
        }
        for (Product product : Barn.products){
            if (level.tasks.containsKey(product.name)){
                int productNum = level.tasks.get(product.name)-1;
                if (productNum == 0)
                    level.tasks.remove(product.name);
                level.tasks.replace(product.name,productNum);
            }
        }
    }
    public boolean isLevelCompleted(){
        if (level.tasks.isEmpty()){
            level.finishTime = new TIME(level.time);
            if (level.finishTime.n <= level.goldenFinishTime.n){
                level.status = "Golden";
            }
            else if (level.finishTime.n <= level.silverFinishTime.n){
                level.status = "Silver";
            }
            else{
                level.status = "Bronze";
            }
            return true;
        }
        return false;
    }
}