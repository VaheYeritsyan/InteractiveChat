import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {


    private static Scanner scanner=new Scanner(System.in);
    private static MemberService memberService;
    public static ArrayList<Member> memberArray;
    public static void main(String[] args) {
        int numberOfMembers;
        System.out.println("How many members do you want\r");
        numberOfMembers=scanner.nextInt();
        memberArray=new ArrayList<>(numberOfMembers);

        initializeArrayList(numberOfMembers);
        getInput();
        printArrayList();



    }
    public static void printArrayList(){
        for(Member el:memberArray){
            System.out.println(el.getMessageTime()+": "+el.getName()+" "+
                    el.getMessage());
        }
    }
    public static void initializeArrayList(int capacity){
        memberService=new MemberService();
        for (int i = 0; i < capacity; i++) {
            String name="Member "+(i+1);
            memberArray.add(new Member(name));


        }
    }
    public static void getInput(){
        memberService=new MemberService();
        int choice;
        for(Member mem:memberArray){
            do {
                System.out.println("Enter 1 to send a message and 0 to exit");

                choice = scanner.nextInt();
                if (choice == 0) {
                    memberService.resetMember(mem);
                } else if (choice == 1) {
                    memberService.sendMessage(mem);
                }
                else {
                    System.out.println("Please enter 0 or 1");
                }
            }while (choice!=0&&choice!=1);
        }
    }
}
