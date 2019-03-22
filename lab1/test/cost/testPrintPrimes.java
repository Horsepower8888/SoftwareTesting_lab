package cost;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class testPrintPrimes {
  public static  PrintPrimes pp;
  @Before
	public void setUp(){
		pp = new PrintPrimes();
	}
	
	@Test
	public void test()
	{
		  int [] test =new int [100];
		  test[0]=2; test[1]=3; test[2]=5; test[3]=7; test[4]=11;
	      assertArrayEquals(test, pp.printPrimes(5));
	}
}
