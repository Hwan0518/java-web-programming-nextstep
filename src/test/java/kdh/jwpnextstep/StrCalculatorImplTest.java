package kdh.jwpnextstep;

import kdh.jwpnextstep.calculator.StrCalculatorImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class StrCalculatorImplTest {

    // 테스트할 StrCalculator 주입
    private StrCalculatorImpl calc;

    @BeforeEach
    private void setUp() {
        System.out.println("test Start");
        calc = new StrCalculatorImpl();
    }

    // 테스트 끝
    @AfterEach
    private void end() {
        System.out.println("test End\n");
    }

    /**
     * 1. Given
     * 2. When
     * 3. Then
     */

    // Given : 테스트에 사용할 변수 등의 주입


    // When : 실제 테스트할 메서드 실행


    // Then : 결과 확인
}
