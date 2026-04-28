package HomeworkNumFour.Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class BookManager {

    //txt파일에 있는 책을 읽어들이는 메서드
    public void getBookList(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        StringBuilder stringBuilder = new StringBuilder();

        String currentLine = bufferedReader.readLine();

        while (currentLine != null) {

            //다음 줄이 만약 ISBN이 들어가면 다음줄에 print하기 위함
            String nextLine = bufferedReader.readLine();

            if(nextLine == null) {
                break;
            }

            if(nextLine.startsWith("ISBN")) {
                stringBuilder.append(currentLine).append(System.lineSeparator());
            } else {
                stringBuilder.append(currentLine + " | ");
            }

            currentLine = nextLine;
        }
        System.out.println(stringBuilder);
        bufferedReader.close();
    }

    //책을 추가하는 메서드
    public void addBook(String fileName) throws IOException {
        Scanner sc = new Scanner(System.in);
        Path path = Paths.get(fileName);

        StringBuilder stringBuilder = new StringBuilder();

        //다음줄에 쓰기 위함
        stringBuilder.append(System.lineSeparator());

        //추가할려는 책의 정보를 받음
        System.out.println("도서ID (예, ISBN####) : ");
        stringBuilder.append(sc.nextLine()).append(System.lineSeparator());

        System.out.print("도서명 : ");
        stringBuilder.append(sc.nextLine()).append(System.lineSeparator());

        System.out.print("가격 : ");
        stringBuilder.append(sc.nextLine()).append(System.lineSeparator());

        System.out.print("저자 : ");
        stringBuilder.append(sc.nextLine()).append(System.lineSeparator());

        System.out.print("설명 : ");
        stringBuilder.append(sc.nextLine()).append(System.lineSeparator());

        System.out.print("분야 : ");
        stringBuilder.append(sc.nextLine()).append(System.lineSeparator());

        System.out.print("출판일 : ");
        stringBuilder.append(sc.nextLine());

        //모아둔 값들을 한 번 쓰기
        Files.writeString(path, stringBuilder, StandardOpenOption.APPEND);

        System.out.println("새 도서 정보가 저장되었습니다.");

    }
}
