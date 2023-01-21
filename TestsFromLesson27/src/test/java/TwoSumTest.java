import org.example.TwoSums;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

}
