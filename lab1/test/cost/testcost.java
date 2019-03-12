package cost;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.Test;

public class testcost {

	 cost cs;
	
	@Before
	public void setUp(){
		cs = new cost();
	}
	
	@Test
	public  void test()
	{
		assertEquals("1换钱有问题", true,cs.change(10));
		assertEquals("2换钱有问题", false,cs.change(14));
		assertEquals("3换钱有问题", false,cs.change(0));
		assertEquals("4换钱有问题", false,cs.change(84));
		assertEquals("5换钱有问题", true,cs.change(61));
		assertEquals("6换钱有问题", true,cs.change(55));
		
	}
	
}
