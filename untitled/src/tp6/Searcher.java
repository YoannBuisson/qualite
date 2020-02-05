package tp6;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Searcher {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        // TODO Auto-generated method stub

        // Création d'une nouvelle instance du driver de firefox
        System.setProperty("webdriver.chrome.driver",
                "utils/chromedriver_linux64/chromedriver");


        WebDriver driver;
        driver = new ChromeDriver();

        // visite de Google
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Recherche d'un lment ici par son nom,
        //peut tre fait par son id, par sa classe, par css, par xpath
        WebElement element = driver.findElement(By.name("q"));

        // On rentre le texte suivant dans l'lment Web
        element.sendKeys("Thierry Poppers");

        // On submit le formulaire, Webriver le recherche pour vous
        element.submit();

        List<WebElement> webElements = driver.findElements(By.xpath("//h3[@class='LC20lb']//parent::a"));
        for (int i = 0; i < webElements.size(); i++) {
            webElements = driver.findElements(By.xpath("//h3[@class='LC20lb']//parent::a"));
            webElements.get(i).click();
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            // Now you can do whatever you need to do with it, for example copy somewhere
            try {
                FileUtils.copyFile(scrFile, new File(String.format("/screenshots/screenshot%d.png", i)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Titre : " + driver.getTitle());
            driver.navigate().back();
        }

        // Attente de chargement, timeout aprs 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Fermeture de Firefox
        driver.quit();
    }
}