public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        InputProcessor inputProcessor = new InputProcessor(manager);
        inputProcessor.run();
    }
}
