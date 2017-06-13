package com.tc.helper;
 
import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
import org.openqa.selenium.chrome.ChromeOptions;

 
@FixMethodOrder (MethodSorters.NAME_ASCENDING)
 
public class Parse {
    private static WebDriver driver;
	
	static String bts_url="";
	static int line;
	static String txt_note_row="";
	static String txt_result_row_start="";
	static String txt_result_row_end="";
	static String id="";
	static String pw="";
	
	static ArrayList<String> mArrayList =  new ArrayList<String>();

	
	
	public void login(String idTest, String pwText){
		// 
		id = idTest;
		pw = pwText;
	}
	
	
	public void inputUrl(String url, String note_row, String result_row_start, String result_row_end){
	      // 텍스트 필드값 가져오기
		bts_url = url;
		txt_note_row = note_row;
		txt_result_row_start = result_row_start;
		txt_result_row_end = result_row_end;
		System.out.println("txt_note_row "+txt_note_row );
		System.out.println("txt_result_row_start "+txt_result_row_start );
		System.out.println("txt_result_row_end "+txt_result_row_end );
		System.out.println("bts_url "+bts_url );
		
	}
	
 
    @BeforeClass
    public static void setUp() throws Exception {
//    	final ChromeOptions options = new ChromeOptions();
//    	 options.addArguments("start-fullscreen");
    	 
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
//        final ChromeDriver driver = new ChromeDriver(options);
		driver.get(bts_url); 
//		 driver.manage().window().maximize();
		  
		

    }
    
    public static void login() throws InterruptedException   {
//    	WebElement loginButton = driver.findElement(By.className("login-link"));
        driver.findElement(By.className("login-link")).click();
        
        
        driver.findElement(By.id("login-form-username")).sendKeys(id);
        driver.findElement(By.id("login-form-password")).sendKeys(pw);
		Thread.sleep(1000);
		driver.findElement(By.id("login-form-submit")).click();
        
        
    }
    
    
    
    public static void issueNumberParse() throws InterruptedException   {
    	
        
        WebElement issueList = driver.findElement(By.id("issuetable"));
        List<WebElement> numberList = issueList.findElements(By.className("issuerow"));
        System.out.println(numberList.size());
        String text;
        int i=0;
        for(WebElement item : numberList){
        	text = item.findElement(By.className("issuekey")).getText();
        	System.out.println(text);
        	mArrayList.add(text);
        	i++;
        	text ="";
        }
        System.out.println(mArrayList.get(0));
        	
        
        
    }

 
    @Test
    public static void run() throws Exception {
    	login();
    	issueNumberParse();
		Thread.sleep(500);
    }
 
    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }
 
}