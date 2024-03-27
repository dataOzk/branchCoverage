import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestUtil {

    // ilkk if statementı, bir argüman olduğu case 
    @Test
    public void testCompute_OneArgument_ReturnsFalse() {
        Util util = new Util();
        boolean result = util.compute(1);
        assertFalse(result);
    }

    // İkinci if statementı, argüman sayısının çift olmasına bakıyor
    @Test
    public void testCompute_EvenNumberOfArguments_ReturnsFalse() {
        Util util = new Util();
        boolean result = util.compute(1, 2);
        assertFalse(result);
    }

    




    @Test
    public void testCompute_SumDivisibleByArgument_ReturnsTrue() {
        Util util = new Util();
        boolean result = util.compute(1, 2, 3, 4, 5);
        assertTrue(result);
    }


    @Test
    public void testCompute_SumZero_ReturnsFalse() {
      Util util = new Util();
      boolean result = util.compute(0, 1, 2, 3);
      assertFalse(result);
    }

    @Test
    public void testCompute_SumNotDivisibleByArgument_ReturnsFalse() {
      Util util = new Util();
      boolean result = util.compute(11, 3, 4, 5, 6);
      assertFalse(result);
    }


    @Test(expected = RuntimeException.class)
    public void testCompute_ThrowsRuntimeExceptionWhenZeroArgument() {
        Util util = new Util();
        util.compute(0,0,0);
    }


}
