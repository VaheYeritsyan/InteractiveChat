import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MemberService {
    private Scanner scanner=new Scanner(System.in);
    public void sendMessage(Member member){
        System.out.println("Enter the message for "+member.getName());
        String message=scanner.nextLine();
        Date date=new Date();
        member.setMessageTime(date.toString());
        member.setMessage(message);
    }
    public void resetMember(Member member){
        member.setMessage("No message available");
        member.setMessageTime("");
    }

}
