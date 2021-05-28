import com.google.gson.Gson;

import java.util.ArrayList;

public class Manager {

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
    public void pickupProduct(int x, int y){

    }
    public void fillWaterBucket(){

    }
    public void planting(int x, int y){

    }
    public void startingWorkshop(String name){

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
}

