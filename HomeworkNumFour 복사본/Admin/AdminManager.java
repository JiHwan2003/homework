package HomeworkNumFour.Admin;

import HomeworkNumFour.Book.BookManager;
import HomeworkNumFour.MyException.InputException;
import HomeworkNumFour.MyException.LoginFailedException;

import java.util.Scanner;

public class AdminManager {

    //로그인 하는 메서드
    public void login(String fileName) throws Exception {
        Scanner sc = new Scanner(System.in);
        BookManager bookManager = new BookManager();
        Admin admin = new Admin();

        //아이디 패스워드 입력받음
        System.out.println("관리자 정보를 입력하세요.");
        System.out.print("아이디 : ");
        String inputID = sc.nextLine();

        System.out.print("비밀번호 : ");
        String inputPassword = sc.nextLine();

        //만약 한개라도 틀리면 로그인 실패 예외 던짐
        if (inputID.equals(admin.getAdminID()) && inputPassword.equals(admin.getAdminPassword())) {
            System.out.print("도서 정보를 추가하겠습니까? Y | N : ");
            String input = sc.next().toLowerCase();

            //사용자의 입력이 Y인 경우 책 추가
            if (input.equals("y")) {
                bookManager.addBook(fileName);
            }

            //사용자의 입력이 N인 경우 관리자 정보 출력
            else if (input.equals("n")) {
                System.out.println("이름 " + admin.getAdminName() + " 연락처 " + admin.getAdminPhoneNum());
                System.out.println("아이디 " + admin.getAdminID() + " 비밀번호 " + admin.getAdminPassword());
            }

            //Y or N이 아닌 경우 예외 던짐
            else {
                throw new InputException("Y 또는 N을 입력해주세요.");
            }
        } else {
            throw new LoginFailedException();
        }
    }
}
