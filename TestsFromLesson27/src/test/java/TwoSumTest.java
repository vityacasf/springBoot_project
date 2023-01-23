import org.example.TwoSums;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TwoSumTest {

  @Test
  public void testCalculateMethodIfArrayNotNull() {
    TwoSums twoSums = new TwoSums();
    int[] array = {1, 2, 3, 4, 5, 6};
    int desiredResult = 5;
    int[] expectedArray = {1, 2};
    int[] answer = twoSums.calculate(array, desiredResult);
    Assertions.assertArrayEquals(expectedArray, answer);
  }

  @Test
  public void testCalculateMethodIfArrayNull() {
    TwoSums twoSums = new TwoSums();
    int desiredResult = 3;
    Assertions.assertNull(twoSums.calculate(null, desiredResult));
  }

  @Test
  public void testCalculateMethodIfNoSolution() {
    TwoSums twoSums = new TwoSums();
    int[] array = {1, 2, 3, 4};
    int desiredResult = 8;
    Assertions.assertNull(twoSums.calculate(array, desiredResult));
  }

  @ParameterizedTest
  @MethodSource("testValues")
  public void doTest(int[] givenArray, int desiredNumber, int[] expectedResult){
    TwoSums twoSums = new TwoSums();
    int[] receivedResult = twoSums.calculate(givenArray, desiredNumber);
    Assertions.assertArrayEquals(expectedResult, receivedResult);
  }

  private static Stream<Arguments> testValues() {
    return Stream.of(
        Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 5, new int[]{1,2}),
        Arguments.of(null, 3, null),
        Arguments.of(new int[]{1, 2, 3, 4}, 8, null)
    );
  }
}
