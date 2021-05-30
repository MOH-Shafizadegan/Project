public class Main {
    public static void main(String[] args) {
        Levels level = new Levels(1);
        Manager manager = new Manager(level);
        InputProcessor inputProcessor = new InputProcessor(manager);
        inputProcessor.run();
    }
}
