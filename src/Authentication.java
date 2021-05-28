import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Authentication {
    private static File users = new File("users.txt");
    private String userName;
    private String password;
    private static Scanner scanner = new Scanner(System.in);

    public void initUserPass(){
        System.out.println("Enter your Username: ");
        this.userName = scanner.nextLine();
        System.out.println("Enter your password: ");
        this.password = scanner.nextLine();
    }

    public void signIn(){
        System.out.println("<<<<    Sign in panel   >>>>");
        initUserPass();
        if (checkUserPass())
            System.out.println("Signed In successfully. Welcome "+this.userName);
        else
            System.out.println("ERROR! Sign in failed because of wrong username and/or password.");
    }

    public boolean checkUserPass(){
        try {
            Scanner fileScanner = new Scanner(users);
            while (fileScanner.hasNext()){
                String line = fileScanner.nextLine();
                String[] userPass = line.split(",");
                if (userPass[0].equals(this.userName)){
                    return userPass[1].equals(this.password);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void signUp(){
        System.out.println("<<<<   Sign up panel   >>>>");
        System.out.println("Enter your Username: ");
        String userNameInput = scanner.nextLine();
        if (checkNewUsername(userNameInput)){
            System.out.println("Sign up failed! this username already exist. use another username...");
            return;
        }
        this.userName = userNameInput;
        System.out.println("Enter your password: ");
        this.password = scanner.nextLine();
        addUser();
        System.out.println("Sign up successfully. Welcome "+this.userName);
    }

    public boolean checkNewUsername(String name){
        try {
            Scanner fileScanner = new Scanner(users);
            while (fileScanner.hasNext()){
                String line = fileScanner.nextLine();
                String[] userPass = line.split(",");
                if (userPass[0].equals(name))
                    return false;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void addUser(){
        try {
            FileWriter fileWriter = new FileWriter(users,true);
            fileWriter.append(this.userName+","+this.password+"\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
