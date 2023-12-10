package kdh.jwpnextstep.calculator;

/**
 * 요구사항
 * 1. ","나 ":"을 구분자로 가지는 문자열을 전달하는 경우, 구분자를 기준으로 합한 값을 반환한다
 *    ex) "1,2"=3, "1,2:3"=6
 * 2. 커스텀 구분자 지정 가능
 *    "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다 ex) //;\n1;2;3 = 6
 * 3. 음수를 전달하는 경우 RuntimeException으로 예외처리
 */
public class Calculator {
    /**
     * 1. 덧셈
     * 2. 뺄셈
     * 3. 곱셈
     * 4. 나눗셈
     */

    // 1. 덧셈
    public int add(int i, int j) {
        return i + j;
    }

    // 2. 뺄셈
    public int subtract(int i, int j) {
        return i - j;
    }

    // 3. 곱셈
    public int multiply(int i, int j) {
        return i * j;
    }

    // 4. 나눗셈
    public int divide(int i, int j) {
        return i / j;
    }


}
