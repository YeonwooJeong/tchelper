package com.tc.helper;
 
import java.io.File;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

 
@FixMethodOrder (MethodSorters.NAME_ASCENDING)
 
public class Parse {
    private static WebDriver driver;
	
	static String bts_url="";
	static int line;
	static String txt_note_row="";
	static String txt_result_row_start="";
	static String txt_result_row_end="";
	
	
	public void inputUrl(String bts_url, String txt_note_row, String txt_result_row_start, String txt_result_row_end){
	      // 텍스트 필드값 가져오기
		bts_url = bts_url;
		txt_note_row = txt_note_row;
		txt_result_row_start = txt_result_row_start;
		txt_result_row_end = txt_result_row_end;
		System.out.println("txt_note_row "+txt_note_row );
		System.out.println("txt_result_row_start "+txt_result_row_start );
		System.out.println("txt_result_row_end "+txt_result_row_end );
		System.out.println("bts_url "+bts_url );
		
	}
	
 
    @BeforeClass
    public static void setUp() throws Exception {
    	
    	File file = new File("c:/chromedriver.exe");
    	File file2 = new File("d:/chromedriver.exe");
   		if(file.isFile()){         
   			System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe"); //크롬 드라이버 파일 경로설정
		}else if(file2.isFile()){
			System.setProperty("webdriver.chrome.driver", "d:/chromedriver.exe"); //크롬 드라이버 파일 경로설정	
		}else{
			//안내문
			runner.labelIntroduce.setText("chromedriver가 없습니다.\n");
		}
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		driver.get(bts_url); 
		 driver.manage().window().maximize();
//	    System.setProperty("selenide.browser", "Chrome");
//	    open(url);
		

    }
    
    public static void login() throws InterruptedException   {
    	boolean boo = true;
    	WebElement NextButton = driver.findElement(By.id("NextButton"));
    	NextButton.click();   
    	
        driver.findElement(By.className("login-link")).sendKeys("nt11062");  //ID
		Thread.sleep(1000);
		driver.findElement(By.id("NextButton")).click();
        
		
		int i = 0;
        while(boo){
        	try{

        	}catch (NoSuchElementException e){
        		
        	}
           
 
        }
        
    }
    
 
    @Test
    public static void run() throws Exception {
    	login();
		Thread.sleep(500);
    }
 
    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }
 
}