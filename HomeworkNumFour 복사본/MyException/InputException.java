package HomeworkNumFour.MyException;

public class InputException extends Exception {

    //부모 클래스 생성자 호출
    public InputException() {
        super();
    }

    //message를 저장
    public InputException(String message) {
        super(message);
    }
}