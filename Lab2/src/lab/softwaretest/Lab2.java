package lab.softwaretest;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Lab2 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
  private String name;
  private String password;
  private String github;
  
  private Lab2 personInfo;
  

  public Lab2(String name, String password, String github)
  {
	  this.name = name;
	  this.password = password;
	  this.github = github;
  }
  
  @Parameters
  public static Collection data()
  {
	  Object[][] oa = new Object[117][3];
	  
	  File dataFile = new File("E:\\University\\»Ìº˛≤‚ ‘\\Lab\\Lab2\\inputgit.csv");
	  if(dataFile.exists() && dataFile.isFile())
	  {
		  try
		  {
			  FileReader fr = new FileReader(dataFile);
			  BufferedReader br = new BufferedReader(fr);
			  String content = br.readLine();
			  int count = 0;
			  String[] pieces = new String[3];
			  while ((content = br.readLine())!=null)
			  {
				  pieces = content.split(",");
				  oa[count][0] = pieces[0];
				  oa[count][1] = pieces[0].substring(4);
				  oa[count][2] = pieces[2];
				  count = count + 1;
			  }
			  br.close();
			  fr.close();
		  }catch(FileNotFoundException e)
		  {
			  System.out.println("Cann't find file, error info: " + e.getMessage());
		  }catch(IOException e)
		  {
			  e.printStackTrace();
		  }
	  }
	  else
	  {
		  System.out.println("Can not find file!");
	  }
	  return Arrays.asList(oa);
  }

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "D:\\Program Files\\Selenium reference\\geckodriver-v0.15.0-win64\\geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "http://121.193.130.195:8080";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
  }

  @Test
  public void test() throws Exception {
    driver.get(baseUrl + "/index.html");
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys(name);
    driver.findElement(By.id("pwd")).clear();
    driver.findElement(By.id("pwd")).sendKeys(password);
    driver.findElement(By.id("submit")).click();
    assertEquals(github, driver.findElement(By.xpath("//tbody[@id='table-main']/tr[3]/td[2]")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
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
}
