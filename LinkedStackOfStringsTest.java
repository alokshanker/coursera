import org.junit.Assert;
import org.junit.Test;


public class LinkedStackOfStringsTest {
	LinkedStackOfStrings stack = new LinkedStackOfStrings();
	@Test
	public void test() {
		 stack.push("To");
		 stack.push("be");
		 stack.push("or");
		 stack.push("not");
		 stack.push("to");
		 stack.push("be");
		 stack.pop();
		 stack.pop();
		 stack.pop();
		 stack.pop();
		 stack.pop();
		 Assert.assertTrue("LinkedStackOfStrings =  To".equals(stack.toString()));
	}
}
