package HomeworkNumFour.Customer;

import java.util.Scanner;

public class CustomerManager {

   private final Customer customer = new Customer();

    //고객의 정보를 사용자로부터 받는 역할을 하는 메서드
    public void getCustomerInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("당신의 이름을 입력하세요 : ");

        customer.setName(sc.nextLine());

        System.out.print("연락처를 입력하세요 : ");
        customer.setPhoneNum(sc.nextLine());
    }

    //고객의 정보를 출력하는 메서드
    public void printCustomerInfo() {
        System.out.println("현재 고객 정보 : ");
        System.out.println("이름 : " + customer.getName() + " 연락처 : " + customer.getPhoneNum());
    }
}
