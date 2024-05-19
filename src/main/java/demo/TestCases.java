package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public static void takeScreenShot(String screenshotType, String description){
        try{
            File theDir = new File("/screenshots");
            if(!theDir.exists()){
                theDir.mkdirs();
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://leetcode.com/");
        
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains("leetcode")){
            System.out.println("testCase01 : URL Verified Successfuly PASSED");
        } else {
            System.out.println("testCase01 : URL Verified unsuccessfuly FAILED");
        }
        System.out.println("end Test case: testCase02");
    }

    public void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");

        driver.get("https://leetcode.com/");

        WebElement signInButton = driver.findElement(By.xpath("//span[contains(text(),'Sign in')]"));
        signInButton.click();

        Thread.sleep(3000);
        WebElement problemButton = driver.findElement(By.xpath("//a[@href='/problemset/all/']"));
        problemButton.click();

        Thread.sleep(2000);

        if(driver.getCurrentUrl().contains("problemset")){
            System.out.println("testCase02 : Verification successful for problem set page PASSED");
        } else {
            System.out.println("testCase02 : Verification unsuccessful for problem set page FAILED");
        }

        List<String> myList = new ArrayList<>();
        myList.add("42. Trapping Rain Water");
        myList.add("1. Two Sum");
        myList.add("2. Add Two Numbers");
        myList.add("3. Longest Substring Without Repeating Characters");
        myList.add("4. Median of Two Sorted Arrays");
        myList.add("5. Longest Palindromic Substring");

        //5. Longest Palindromic Substring

        List<WebElement> problemList = driver.findElements(By.xpath("//a[@class='h-5 hover:text-blue-s dark:hover:text-dark-blue-s']"));
        Thread.sleep(3000);
        // for(int i = 0; i <= myList.size() - 1;i++){
        //     for(int j = 0; j < 5; j++){
        //         if(myList.get(i).contains(problemList.get(j).getText())){
        //             System.out.println("testCase02 : Question MAtched Successful PASSED");
        //         } else{
        //             System.out.println("testCase02 : Question MAtched unsuccessful FAILED");
        //             System.out.println(problemList.get(j).getText());
        //         }
        //     }
            
        // }

        // for(WebElement s : problemList){

        //     System.out.println(s.getText());
        // }
        boolean allMatched = true;
        for (int i = 1; i < myList.size(); i++) {
            boolean matched = false;
            for (int j = 1; j < 6; j++) {
                if (myList.get(i).contains(problemList.get(j).getText())) {
                    matched = true;
                    break;
                }
            }
            if (matched) {
                System.out.println("testCase02 : Question Matched Successfully - " + myList.get(i) + " PASSED");
            } else {
                System.out.println("testCase02 : Question Matched Unsuccessful - " + myList.get(i) + " FAILED");
                allMatched = false;
            }
        }
    
        if (allMatched) {
            System.out.println("All questions matched successfully.");
        } else {
            System.out.println("Some questions did not match.");
        }
        
        System.out.println("End Test case: testCase02");
    }

    public void testCase03() throws InterruptedException{
        System.out.println("Start Test case: testCase03");

        driver.get("https://leetcode.com/");

        WebElement signInButton = driver.findElement(By.xpath("//span[contains(text(),'Sign in')]"));
        signInButton.click();

        Thread.sleep(3000);
        WebElement problemButton = driver.findElement(By.xpath("//a[@href='/problemset/all/']"));
        problemButton.click();

        Thread.sleep(2000);

        WebElement twoSumQsnElem = driver.findElement(By.xpath("//a[@href='/problems/two-sum']"));
        twoSumQsnElem.click();

        Thread.sleep(3000);

        if(driver.getCurrentUrl().contains("two-sum")){
            System.out.println("testCase03 : Url verification PASSED");
        } else{
            System.out.println("testCase03 : Url verification FAILED");
        }

        System.out.println("End Test case: testCase03");
    }

    public void testCase04() throws InterruptedException{
        System.out.println("Start Test case: testCase04");

        driver.get("https://leetcode.com/");

        WebElement signInButton = driver.findElement(By.xpath("//span[contains(text(),'Sign in')]"));
        signInButton.click();

        Thread.sleep(3000);
        WebElement problemButton = driver.findElement(By.xpath("//a[@href='/problemset/all/']"));
        problemButton.click();

        Thread.sleep(2000);

        WebElement twoSumQsnElem = driver.findElement(By.xpath("//a[@href='/problems/two-sum']"));
        twoSumQsnElem.click();

        WebElement submitBtn = driver.findElement(By.xpath("(//div[@id='description_tabbar_outer']/descendant::div[@class='relative'][4]/div)[2]"));
        submitBtn.click();

        WebElement afterSubmit = driver.findElement(By.xpath("//a[@href='/accounts/login/?next=%2Fproblems%2Ftwo-sum%2Fsubmissions%2F']"));
        //String s = afterSubmit.getText().replaceAll("\\s+", " ").trim();
        // System.out.print(s);
        if(afterSubmit.getText().contains("Register or Sign In")){
            System.out.println("testCase04 : Verification PASSED");
        } else{
            System.out.println("testCase04 : Verification FAILED");
        }



    }


}
