package HomeworkNumFour;

import HomeworkNumFour.Admin.AdminManager;
import HomeworkNumFour.Book.BookManager;
import HomeworkNumFour.Customer.CustomerManager;
import HomeworkNumFour.MyException.InputException;
import HomeworkNumFour.MyException.LoginFailedException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OnlineBookStoreSystem {

    public void run(String fileName) {
        Scanner sc = new Scanner(System.in);

        AdminManager adminManager = new AdminManager();
        BookManager bookManager = new BookManager();
        CustomerManager customerManager = new CustomerManager();

        // 고객 정보 입력은 루프 시작 전에 한 번만 성공하면 되므로 바깥에 둠
        customerManager.getCustomerInfo();

        boolean isRun = true;

        while (isRun) {
            try {
                System.out.println("********************************************************");
                System.out.println("        Welcome to Shopping Mall");
                System.out.println("        Welcome to Book Market!");
                System.out.println("********************************************************");
                System.out.println("1. 고객 정보 확인하기            4. 도서 목록 조회하기");
                System.out.println("2. 장바구니 상품 목록 보기        5. 장바구니의 항목 수량 줄이기");
                System.out.println("3. 장바구니 비우기              6. 장바구니의 항목 삭제하기");
                System.out.println("7. 영수증 표기하기              8. 종료");
                System.out.println("9. 관리자 로그인");
                System.out.println("********************************************************");
                System.out.print("메뉴 번호를 선택해주세요 : ");

                int input = sc.nextInt();

                //입력값이 1하고 9 사이가 아니면 예외처리
                if (input < 1 || input > 9) {
                    throw new InputException(input + "번을 입력했습니다.\n" + "1부터 9까지의 숫자를 입력하세요.");
                }

                switch (input) {
                    case 1 -> customerManager.printCustomerInfo();
                    case 2 -> mocking();
                    case 3 -> mocking();
                    case 4 -> bookManager.getBookList(fileName);
                    case 5 -> mocking();
                    case 6 -> mocking();
                    case 7 -> mocking();
                    case 8 -> isRun = false;
                    case 9 -> adminManager.login(fileName);
                }

            } catch (InputMismatchException e) {
                // 문자를 입력했을 때 발생하는 예외
                System.out.println("숫자만 입력해주세요");
                sc.nextLine(); // 핵심: 잘못 입력된 찌꺼기(문자)를 버퍼에서 비워줌

            } catch (InputException e) {
                // 1~9 범위를 벗어났을 때 발생하는 커스텀 예외
                System.out.println(e.getMessage());

            } catch (LoginFailedException e) {
                // 로그인 실패 시
                System.out.println(e.getMessage());

            } catch (Exception e) {
                // 그 외 예상치 못한 모든 예외
                System.out.println("예상치 못한 예외상황이 발생했습니다: " + e.getMessage());
            }
            // catch 블록이 끝나면 다시 while문의 처음으로 돌아가서 메뉴를 띄움
        }

        sc.close();
    }

    private void mocking() {
    }

}
