package kdh.jwpnextstep.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class StrCalculatorImpl implements StrCalculator{
    /**
     * 1. 덧셈
     * 2. 구분자 구하기
     * 3. 구분자로 입력 문자열 split
     * 4. 배열 원소들을 int로 변환
     * 5. 문자열 입력받기
     */

    // 1. 덧셈 : 배열을 입력받아서 return
    public int summation(int[] intArray) {
        int summationResult = Arrays.stream(intArray).sum();
        return summationResult;
    }


    // 2. 구분자 구하기 : 입력 문자열에서 구분자를 구함
    @Override
    public ArrayList<String> getSeparator(String inputString) {
        ArrayList<String> separators = new ArrayList<>();
        // inputString에서 [",", ":"]를 찾음
        if (inputString.contains(",") == true) {
            separators.add(",");
        }
        if (inputString.contains(":") == true) {
            separators.add(":");
        }
        // inputString에서 커스텀 구분자를 찾음
        int startIndex = inputString.indexOf("//");
        int endIndex = inputString.indexOf("\n");
        if (startIndex != -1 && endIndex != -1) {
            String customSeparator = inputString.substring(startIndex+1, endIndex);
            separators.add(customSeparator);
        }
        // 구분자 리스트를 return
        return separators;
    }


    // 3. 구분자로 입력 문자열 split
    @Override
    public String[] splitString(String inputString, ArrayList<String> separators) {
        String[] separatedString;
        for (String sp : separators) {
            separatedString = inputString.split(sp);

        }

        return new String[0];
    }


    // 4. 배열 원소들을 int로 변환
    @Override
    public int[] changeElements(String[] separatedString) {
        return new int[0];
    }


    // 5. 문자열 입력받기 : 문자열을 입력받음
    public String inputString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}
