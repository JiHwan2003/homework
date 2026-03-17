import java.lang.reflect.Array;
import java.util.Arrays;

public class Remover {

    private String[] resultArray;

    //실행하는 메서드
    //다른 메서드들은 굳이 다른 클래스에서 알 필요가 없고 오직 run 메서드만 알면 되니깐
    //나머지 메서드는 private, run 메서드만 public으로 선언
    public void run(String[] array) {
        removeDuplicate(array);
        String[] result = resize();
        print(result);
    }

    //중복 제거하는 메서드
    private void removeDuplicate(String[] array) {
        //각각의 중복 여부를 체크하는 변수
        boolean duplicate = false;

        //중복 여부를 체크하고 각각의 위치에 담는 배열
        boolean[] flagArray = new boolean[array.length];

        //중복을 제거한 배열
        String[] removeArray = new String[array.length];

        //중복을 거르고 removeArray 배열에 담을 때 removeArray의 인덱스를 나타내는 변수
        int removeArrayNum = 0;

        //뒤에서부터 중복이면 true 아니면 false 리턴해서 flag배열에 역순으로 담음
        //예를 들어 9번째 값은 0~8번까지 비교, 8번째 값은 0~7번째까지 비교
        for (int idx1 = array.length - 1; idx1 >= 0; idx1--) {
            for (int idx2 = idx1 - 1; idx2 >= 0; idx2--) {
                if (array[idx1].equals(array[idx2])) {
                    duplicate = true;
                    break;
                }
            }
            flagArray[idx1] = duplicate;
            duplicate = false;
        }

        //flag 배열을 참고해서 중복 없는 배열을 만듦
        for (int idx = 0; idx < flagArray.length; idx++) {
            if (flagArray[idx] == false) {
                removeArray[removeArrayNum] = array[idx];
                removeArrayNum++;
            }
        }

        resultArray = removeArray;
    }


    //중복 제거한 배열의 사이즈를 조절하는 메서드
    private String[] resize() {
        //null이 가장 먼저 등장한 곳의 인데스
        int nullIndex = 0;

        //값이 비어있기 시작한 곳의 인덱스를 구함
        for (int index = 0; index < resultArray.length; index++) {
            if (resultArray[index] == null) {
                nullIndex = index;
                break;
            }
        }

        //만약 빈곳이 없다면 그냥 리턴
        if (nullIndex == 0) return resultArray;

        //사이즈 조정한 배열
        String[] resizeArray = new String[nullIndex];

        //크기를 조정한 새로운 배열에 값이 있는 곳까지만 값을 넘겨주고 리턴
        for (int index = 0; index < nullIndex; index++) {
            resizeArray[index] = resultArray[index];
        }
        return resizeArray;
    }

    //값 출력 메서드
    private void print(String[] array) {
        System.out.println("Result = " + Arrays.toString(array));
    }
}
