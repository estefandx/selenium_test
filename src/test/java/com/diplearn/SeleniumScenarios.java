package com.diplearn;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.time.Duration;

public class SeleniumScenarios {

    private WebDriver driver;
    private static long startTime;

    @BeforeClass
    public static void time(){
        startTime = System.currentTimeMillis();
    }


    @BeforeMethod
    public void setUp() {
        driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationtesting.co.uk/accordion.html");
        System.out.println("se abrio el navegador");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @AfterClass
    public static void timeEnd(){
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Tiempo total de ejecución de pruebas: " + executionTime + " milisegundos");
    }

    @Test
    public void Calculadora (){
        driver.findElement(By.xpath("//a[text()='Calculator (JS)']")).click();
        driver.findElement(By.xpath("//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='3']")).click();
        driver.findElement(By.xpath("//input[@value='4']")).click();
        driver.findElement(By.xpath("//input[@value='5']")).click();
        driver.findElement(By.xpath("//input[@value='+']")).click();
        driver.findElement(By.xpath("//input[@value='6']")).click();
        driver.findElement(By.xpath("//input[@value='7']")).click();
        driver.findElement(By.xpath("//input[@value='8']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
    }

    @Test
    public  void CargarArchivo(){
        driver.findElement(By.xpath("//a[text()='File Upload']")).click();
        String archivoASubir = "test.txt";
        String rutaArchivo = new File("src/main/resources/" + archivoASubir).getAbsolutePath();
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        fileInput.sendKeys(rutaArchivo);
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();
    }

    @Test
    public void loader(){
        driver.findElement(By.xpath("//a[text()='Loader']")).click();
        WebElement btnLoader  = driver.findElement(By.id("loaderBtn"));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(btnLoader));
        btnLoader.click();
    }

}
