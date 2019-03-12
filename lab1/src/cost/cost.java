package cost;

/*
 通过暴力循环把换钱的所有方案都求出
 若方案中各面值的个数均在题干所给范围（即1张50元 1张20元 2张5元 3张1元）
 则判断正确
*/

public class cost {
	
	public boolean change(int x)
	{
	    boolean just=false; //判断正误
	   
	    if(x<1||x>84)  //若超过总数额范围则判断错误
	    	{
	    	  	just=false;
	    	}
	    else
	    	{
	    		for(int a=0;a<=x/50;a++)  //计算面额50的个数
	    			{
	    				for(int b=0;b<=x/20;b++) //计算面额20的个数
	    					{ 
	    						for(int c=0;c<=x/5;c++)  //计算面额5的个数
	    							{
	    								for(int d=0;d<=x;d++)  //计算面额1的个数
	    									{
	    										if(a*50+b*20+c*5+d==x&&a<2&&b<2&&c<3&&d<4)  //若各面额个数均在题干范围则判断正确 
	    											{
	    											   
	    												just=true;
	    											}
	    									}
	    							}
	    					}
	    			}
	    	}
		
		return just;
	}
     

/*public static void main (String[] args) 
{
System.out.println(change(15));
}*/

}
   
