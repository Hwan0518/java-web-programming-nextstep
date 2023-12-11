package kdh.jwpnextstep;

import kdh.jwpnextstep.calculator.StrCalculatorImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StrCalculatorImplTest {

    /**
     * 테스트 전
     */
    // 테스트할 StrCalculator 주입
    private StrCalculatorImpl calc;
    @BeforeEach
    private void setUp() {
        System.out.println("test Start");
        calc = new StrCalculatorImpl();
    }

    /**
     * 테스트 후
     */
    // 테스트 끝
    @AfterEach
    private void end() {
        System.out.println("test Success!\n");
    }

    /**
     * 1. Given : 테스트에 사용할 변수 등 주어지는 값
     * 2. When : 실제 테스트할 메서드 실행
     * 3. Then : 결과 확인
     */


    // 공통 given
    String inputString = "//;\\n1,2;3:4";

    // 구분자 구하기 테스트
    @Test
    public void getSeparatorTest() {
        // Given
        List<String> answer = Arrays.asList(",",";");

        // When
        List data = calc.getSeparator(inputString);
        ArrayList<String> separators = (ArrayList<String>) data.get(0);
        String inputString = (String) data.get(1);

        // Then
        assertThat(separators).isEqualTo(answer);
        assertThat(inputString).isEqualTo("1,2;3:4");
    }

    // 구분자로 입력 문자열 분리 테스트
    @Test
    public void splitStringTest() {
        // Given
        List data = calc.getSeparator(inputString);
        ArrayList<String> separators = (ArrayList<String>) data.get(0);
        String inputString = (String) data.get(1);

        // When
        String[] separatedString = calc.splitString(inputString, separators);

        // Then
        assertThat(separatedString).isEqualTo(new String[]{"1", "2", "3", "4"});
    }

    // 배열 원소들 int로 변환 테스트
    @Test
    public void changeElementsTest() {
        // Given
        List data = calc.getSeparator(inputString);
        ArrayList<String> separators = (ArrayList<String>) data.get(0);
        String inputString = (String) data.get(1);
        String[] separatedString = calc.splitString(inputString, separators);

        // When
        int[] intArray = calc.changeElements(separatedString);

        // Then
        assertThat(intArray).isEqualTo(new int[]{1, 2, 3, 4,});
    }

    // 배열 입력받아서 덧셈하고 return
    @Test
    public void summation() {
        // Given
        List data = calc.getSeparator(inputString);
        ArrayList<String> separators = (ArrayList<String>) data.get(0);
        String inputString = (String) data.get(1);
        String[] separatedString = calc.splitString(inputString, separators);
        int[] intArray = calc.changeElements(separatedString);

        // when
        int summationResult = calc.summation(intArray);

        // then
        assertThat(summationResult).isEqualTo(10);
    }

    // 전체 계산기 테스트
    @Test
    public void StrCalculatorTest() throws IOException {
        // when
        int result = calc.strCalculator();
        // that
        assertThat(result).isEqualTo(10);
    }
}
