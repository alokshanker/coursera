import org.junit.Assert;
import org.junit.Test;


public class SortTest {

	@Test
	public void test() {
		Comparable[] inputArray1=  {1,5,7,9,3,4,57,8,9};
		Insertion.sort(inputArray1);
		Comparable [] inputArray2 =  {1,5,7,9,3,4,57,8,9};
		SelectionSort.sort(inputArray2);
		Assert.assertArrayEquals(inputArray1, inputArray2);
		Comparable [] inputArray3 =  {1,5,7,9,3,4,57,8,9};
		Shell.sort(inputArray3);
		Assert.assertArrayEquals(inputArray1, inputArray3);
	}
}
