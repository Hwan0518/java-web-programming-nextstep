package kdh.jwpnextstep;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {

    // 테스트코드 실행시마다 새로운 값을 주입받기 위해서 final을 사용하지 않는다
    private Calculator calculator;

    /**
     * BeforeEach : Calculator 주입
     * AfterEach
     * 1. 덧셈
     * 2. 뺄셈
     * 3. 곱셈
     */

    // Calculator 주입 -> @BeforeEach를 사용해서 초기화 하는것을 권장
    // 1. @BeforeAll은 static만 적용이 되고
    // 2. 각 테스트 메서드마다 독립성을 보장하기위해서 사용한다
    // 3. TestWatcher를 사용하여 기능을 확장할 수 있다
    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    @AfterEach
    public void teardown() {
        System.out.println("teardown");
    }


    // 1. 덧셈
    @Test
    public void add() {
        int result = calculator.add(10,10);
        // 출력으로 확인
        System.out.println(result);
        // assertEquals로 확인
        assertEquals(20, result);
    }

    // 2. 뺄셈
    @Test
    public void subtract() {
        int result = calculator.subtract(10, 5);
        // 출력으로 확인
        System.out.println(result);
        // assertEquals로 확인
        assertEquals(5, result);
    }

    // 3. 곱셈
    @Test
    public void multiply() {
        int result = calculator.multiply(2, 4);
        Integer[] resultArrays = {result};
        // assertTrue로 확인
        assertTrue(result == 8);
        // assertFalse로 확인
        assertFalse(result == 7);
        // assertArrayEquals로 확인
        Integer[] answerArrays = {8};
        assertArrayEquals(answerArrays, resultArrays);
        // assertThat 사용(assertJ)
        assertThat(resultArrays).isEqualTo(answerArrays);
    }


}
