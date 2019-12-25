import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;


public class Main{
    private static ArrayList<Member> members=null;
    private static ArrayList<String> messages=null;
    public static int getNumberOfMembers(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("How many members do you want");
        return scanner.nextInt();
    }
    public static void initializeArrayList(int capacity){
        messages=new ArrayList<>();
        members=new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            members.add(new Member());
        }

    }
    public static void askForAction(int index){
        System.out.println(members.get(index).getName());
        System.out.println("Enter 1 to send a message and 2 to exit");
        Scanner scanner=new Scanner(System.in);
        int choice=scanner.nextInt();
        switch (choice){
            case 1:
                addMessage(index);
                break;
            case 2:
                removeMember(index);
                break;
            default:
                System.out.println("Enter 0 or 1");
                break;
        }
    }

    private static void removeMember(int index) {
        System.out.println(members.get(index).getName()+" exited");
        members.remove(index);
    }

    private static void addMessage(int index) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter your message");
        String message=scanner.nextLine();
        String fullMessage=(new Date()).toString();
        fullMessage+=" "+members.get(index).getName()+": "+message;
        messages.add(fullMessage);
    }
    private static void askUntilNoOnline(){
        Random random=new Random();
        while (!members.isEmpty()){
            askForAction(random.nextInt(members.size()));
        }
        System.out.println("No online members, showing messages");
        for(String message:messages){
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        initializeArrayList(getNumberOfMembers());
        askUntilNoOnline();
    }
}