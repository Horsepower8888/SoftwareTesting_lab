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
		assertEquals("1��Ǯ������", true,cs.change(10));
		assertEquals("2��Ǯ������", false,cs.change(14));
		assertEquals("3��Ǯ������", false,cs.change(0));
		assertEquals("4��Ǯ������", false,cs.change(84));
		assertEquals("5��Ǯ������", true,cs.change(61));
		assertEquals("6��Ǯ������", true,cs.change(55));
		
	}
	
}
