package cost;

/*
 ͨ������ѭ���ѻ�Ǯ�����з��������
 �������и���ֵ�ĸ����������������Χ����1��50Ԫ 1��20Ԫ 2��5Ԫ 3��1Ԫ��
 ���ж���ȷ
*/

public class cost {
	
	public boolean change(int x)
	{
	    boolean just=false; //�ж�����
	   
	    if(x<1||x>84)  //�����������Χ���жϴ���
	    	{
	    	  	just=false;
	    	}
	    else
	    	{
	    		for(int a=0;a<=x/50;a++)  //�������50�ĸ���
	    			{
	    				for(int b=0;b<=x/20;b++) //�������20�ĸ���
	    					{ 
	    						for(int c=0;c<=x/5;c++)  //�������5�ĸ���
	    							{
	    								for(int d=0;d<=x;d++)  //�������1�ĸ���
	    									{
	    										if(a*50+b*20+c*5+d==x&&a<2&&b<2&&c<3&&d<4)  //����������������ɷ�Χ���ж���ȷ 
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
   
