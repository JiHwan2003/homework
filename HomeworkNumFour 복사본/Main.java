package HomeworkNumFour;

import Homework.MyHomeworkInfo;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "src/HomeworkNumFour/book.txt";

        MyHWInfo.printInfo();

        //OnlineBookSystem 객체 생성
        OnlineBookStoreSystem onlineBookStoreSystem = new OnlineBookStoreSystem();

        //실행
        onlineBookStoreSystem.run(fileName);
    }
}
