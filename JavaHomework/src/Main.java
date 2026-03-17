import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        MyHWInfo.printInfo();

        String[] sa = new String[]{"is", "S8", "S8", "Oreo", "update", "Oreo", "is", "S8"};

        System.out.println("Original = " + Arrays.toString(sa));

        Remover remover = new Remover();

        remover.run(sa);
    }

}