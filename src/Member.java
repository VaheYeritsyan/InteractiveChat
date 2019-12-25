public class Member {
    private static int indexOfMember=1;
    private String name;
    public Member() {
        this.name = "Member"+indexOfMember;
        ++indexOfMember;
    }

    public String getName() {
        return name;
    }
}

