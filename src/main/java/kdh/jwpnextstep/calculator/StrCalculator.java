package kdh.jwpnextstep.calculator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public interface StrCalculator {
    /**
     * 1. 덧셈
     * 2. 구분자 구하기
     * 3. 구분자로 입력 문자열 split
     * 4. 배열 원소들을 int로 변환
     * 5. 문자열 입력받기
     */

    // 1. 덧셈 : 배열을 입력받아서 return
    int summation(int[] intArray);

    // 2. 구분자 구하기 : 입력 문자열에서 구분자를 구함
    ArrayList<String> getSeparator(String inputString);

    // 3. 구분자로 입력 문자열 split
    String[] splitString(String inputString, ArrayList<String> separators);

    // 4. 배열 원소들을 int로 변환
    int[] changeElements(String[] separatedString);

    // 5. 문자열 입력받기 : 문자열을 입력받아서 return
    String inputString() throws IOException;




}