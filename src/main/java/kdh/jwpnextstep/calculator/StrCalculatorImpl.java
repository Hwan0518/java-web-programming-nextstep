package kdh.jwpnextstep.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrCalculatorImpl implements StrCalculator{
    /**
     * 1. 덧셈
     * 2. 구분자 구하기
     * 3. 구분자로 입력 문자열 split
     * 4. 배열 원소들을 int로 변환
     * 5. 문자열 입력받기
     * 6. 계산기 작동
     */

    // 1. 덧셈 : 배열을 입력받아서 덧셈하고 return
    public int summation(int[] intArray) {
        int summationResult = Arrays.stream(intArray).sum();
        return summationResult;
    }


    // 2. 구분자 구하기 : 입력 문자열에서 구분자를 구함
    @Override
    public List getSeparator(String inputString) {
        ArrayList<String> separators = new ArrayList<>();
        // inputString에서 ","를 찾음
        if (inputString.contains(",") == true) {
            separators.add(",");
        }
        // inputString에서 커스텀 구분자를 찾음
        int startIndex = inputString.indexOf("//");
        int endIndex = inputString.indexOf("\\n");
        int numberStartIndex;
        if (startIndex != -1 && endIndex != -1) {
            String customSeparator = inputString.substring(startIndex+2, endIndex);
            separators.add(customSeparator);
            numberStartIndex = endIndex +2;
        }
        // 커스텀 구분자가 없다면, numberStartIndex = 0이다
        else {
            numberStartIndex = 0;
        }
        inputString = inputString.substring(numberStartIndex);
        // 구분자 리스트와, 숫자가 시작되는 곳 부터의 inputString을 return
        return List.of(separators, inputString);
    }


    // 3. 구분자로 입력 문자열 split
    @Override
    public String[] splitString(String inputString, ArrayList<String> separators) {
        String[] separatedString;
        // 구분자를 모두 :로 바꿔준다
        for (String sp : separators) {
            inputString = inputString.replaceAll(sp, ":");
        }
        // 문자열에서, 빈 문자나 null을 0으로 바꾼다
        inputString = inputString.replaceAll(" ", "0");
        inputString = inputString.replaceAll("null", "0");
        // 문자열을 :로 나눈다
        separatedString = inputString.split(":");

        return separatedString;
    }


    // 4. 배열 원소들을 int로 변환
    @Override
    public int[] changeElements(String[] separatedString) {
        boolean isInNegative = false;
        int[] intArray = Arrays.stream(separatedString)
                .mapToInt(Integer::parseInt)
                .filter(n->n>=0)
                .toArray();
        // intArray크기와 separatedString 크기가 같지 않다면 음수가 포함되어 있으므로 예외처리
        if (intArray.length != separatedString.length) {
            throw new RuntimeException("음수가 포함되어 있습니다");
        }
        return intArray;
    }


    // 5. 문자열 입력받기 : 문자열을 입력받음
    public String inputString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    // 6. 계산기 작동
    public int strCalculator() throws IOException {
        // 문자열 입력받음
//        String input = inputString();
        String input = "//;;\\n1,2;;3:4";
        // 입력받은 문자열에서 구분자와 실제 계산에 필요한 부분 문자열만을 구함
        List data = getSeparator(input);
        ArrayList<String> separators = (ArrayList<String>) data.get(0);
        String subString = (String) data.get(1);
        // 구분자로 입력 문자열을 분리
        String[] separatedString = splitString(subString, separators);
        // 배열 원소들을 숫자로 변경
        int[] intArray = changeElements(separatedString);
        // 배열 원소들을 모두 더해서 결과를 return
        int result = summation(intArray);
        return result;
    }
}