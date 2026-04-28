package HomeworkNumFour.Admin;

public class Admin {

    //관리자의 정보,아이디,패스워드는 한 번 정하면 안 바뀌므로 final 사용
    private final String adminID = "Admin";
    private final String adminPassword = "Admin1234";

    private final String adminName = "관리자";
    private final String adminPhoneNum = "15881588";

    //관리자의 정보,아이디,패스워드는 한 번 정하면 안 바뀌므로 get만 존재
    public String getAdminID() {
        return adminID;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminPhoneNum() {
        return adminPhoneNum;
    }
}
