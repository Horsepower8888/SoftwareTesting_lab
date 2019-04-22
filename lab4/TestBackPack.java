
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestBackPack {
	
	private BackPack BP;
	int m=10;
    int n=3;
    int w1[] = {3,4,5};
    int p1[] = {4,5,6};
	int arr1[][] = {{0,0,4,4,4,4,4,4,4,4}, {0,0,4,5,5,5,9,9,9,9},{0,0,4,5,6,6,9,10,11,11}};
	int result1 = arr1[n-1][m-1];
	
	int w2[] = {2,3,4};
    int p2[] = {3,4,5};
	int arr2[][] = {{0,3,3,3,3,3,3,3,3,3}, {0,3,4,4,7,7,7,7,7,7},{0,3,4,5,7,8,9,9,12,12}};
	int result2 = arr2[n-1][m-1];
	
	@Before
	public void setup()
	{
		BP = new BackPack();
	}

	@Test
	public void testBackPack()
	{
		int value1=BP.BackPack_Solution(m, n, w1, p1)[n][m];
		assertEquals(result1, value1);
		int value2=BP.BackPack_Solution(m, n, w2, p2)[n][m];
		assertEquals(result2, value2);
	}
}
