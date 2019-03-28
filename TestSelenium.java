package testSelenium;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestSelenium {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  ArrayList<String> idarr = new ArrayList ();
  ArrayList<String>  namearr = new ArrayList ();
  ArrayList<String>  gitarr =  new ArrayList ();
  

  
  @Before
  public void setUp() throws Exception {
	  String driverPath = System.getProperty("user.dir") + "/src/resources/driver/geckodriver.exe";
	  System.setProperty("webdriver.gecko.driver", driverPath);
	  driver = new FirefoxDriver();
	  baseUrl = "http://121.193.130.195:8800/login";
	  driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);// webdriver中执行所有命令的超时时间
  }

  
  @Test
  public void testselenium()  {  
	  try {
			ReadExcel();
		} catch (Exception e) {
			System.out.println("读取Excel文件出错");
			e.printStackTrace();
		}
	        int len = idarr.size();
	  		driver.get(baseUrl+ "/");
		    for(int i=0;i<len;i++)
		    {
	       	String id = idarr.get(i);//学号
	       	String password = id.substring(id.length() - 6);//密码
	       	String name = namearr.get(i);//名字
	        String url = gitarr.get(i);//github URL
	       	//System.out.println(id + "-" + password); 
	       	//System.out.println(url);
	       	//driver.get(baseUrl+ "/");
	       	driver.findElement(By.name("id")).clear();
	       	driver.findElement(By.name("id")).sendKeys(id);
	       	driver.findElement(By.name("password")).clear();
	       	driver.findElement(By.name("password")).sendKeys(password);
	       	driver.findElement(By.id("btn_login")).click();
	       	String webURL = driver.findElement(By.id("student-git")).getText(); 	
	       	String webid = driver.findElement(By.id("student-id")).getText(); 	
	       	String webname = driver.findElement(By.id("student-name")).getText(); 	   	
	       	driver.findElement(By.id("btn_logout")).click();
	     	driver.findElement(By.id("btn_return")).click();

//	       	int len = webURL.length();	
//	    	if(webURL.charAt(len - 1) == ' ')
//	    		webURL = webURL.substring(0, len - 1);
	    	
	       	assertEquals(url, webURL);//判断
	       	assertEquals(id, webid);
	       	assertEquals(name, webname);
	    }
  }

  @After
  public void tearDown() throws Exception {
//    driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
  
  public void ReadExcel() throws Exception //读取Excel表格中的内容并存入array list中
  {
	  	File file = new File("E:/软件测试/lab/lab2/软件测试名单.xlsx");        
		InputStream inputStream = null;        
		Workbook workbook = null; 
		

		try 
		{            
		inputStream = new FileInputStream(file);            
		workbook = WorkbookFactory.create(inputStream);            
		inputStream.close();            
		  
		Sheet sheet = workbook.getSheetAt(0);     //工作表对象                     
		int rowLength = 145;     //总行数                
		Row row = sheet.getRow(0);           //工作表的列    
		//int colLength = 4;     //总列数                         
		//Cell cell = row.getCell(0);      //得到指定的单元格                                 
		//System.out.println("行数：" + rowLength + ",列数：" + colLength);            
		for (int i = 2; i < rowLength; i++)
		{               
			row = sheet.getRow(i);                                    
			Cell cell1 = row.getCell(1); 
			Cell cell2 = row.getCell(2);
			Cell cell3 = row.getCell(3);
			if (cell3 != null)                        
			{
				cell1.setCellType(CellType.STRING);  
				cell2.setCellType(CellType.STRING); 
				cell3.setCellType(CellType.STRING);
				
			}
					    
				if(!cell1.getStringCellValue().equals("") && !cell3.getStringCellValue().equals(""))
				  {
					//ArrayList
				   idarr.add(cell1.getStringCellValue());
				   namearr.add(cell2.getStringCellValue());
				   gitarr.add(cell3.getStringCellValue());
				   //System.out.println(cell1.getStringCellValue()+" "+cell2.getStringCellValue()+" "+cell3.getStringCellValue()); 
		          	
		          }
				else 
				{
					System.out.println("学号为"+cell1.getStringCellValue()+"的同学无存储githuburl");
		          }
				                       
			}                   
		} 
		catch (Exception e) 
		{          
			e.printStackTrace();        
		}   
		
  }  
  
}

