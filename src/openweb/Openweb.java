/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author abigail
 */
public class Openweb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
      // System.setProperty("webdriver.gecko.driver", "C:\\Gecko\\geckodriver.exe"); 
       System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe"); 
        
         WebDriver driver;          
         //driver = new FirefoxDriver();  
         driver = new ChromeDriver();  

         driver.get("https://portal.aait.edu.et/"); 
         //.sendkeys(keystosend,"")
         
         driver.findElement(By.name("UserName")).sendKeys("id");
         driver.findElement(By.name("Password")).sendKeys("password"); 
        driver.findElement(By.xpath("//*[@id=\"home\"]/div[2]/div[2]/form/div[4]/div/button")).click();
        
        driver.get("https://portal.aait.edu.et/Home"); 
        driver.findElement(By.xpath("//*[@id=\"m1\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"m1\"]/ul/li[1]/a")).click();
        
        String content=driver.findElement(By.xpath("/html/body")).getText();
        
        try {
			File file = new File("BasicInformation.txt");
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(content);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        
        
       
        
        
        
    }
    
}
