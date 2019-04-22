
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestBubbleSort {
	
	BubbleSort BS;
	public int arr[] = {1,3,6,9,2,8};
	public int result[] = {1,2,3,6,8,9};

	@Before
	public void setup(){
		BS = new BubbleSort();
	}
	
	@Test
	public void testSort(){
	assertArrayEquals(result, BS.BubbleSort(arr));
	}
}
