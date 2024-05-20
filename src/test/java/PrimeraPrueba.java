import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PrimeraPrueba {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Espera explícita
        try {
            driver.get("https://www.demoblaze.com/index.html");

            String title = driver.getTitle();
            System.out.println("El nombre del título es " + title);

            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

            WebElement celular = driver.findElement(By.linkText("Samsung galaxy s6"));
            celular.click();

            WebElement texto = driver.findElement(By.className("name"));
            String actual = texto.getText();
            System.out.println("El texto contiene " + actual);

            if (actual.equals("Samsung galaxy s6")) {
                System.out.println("Los textos coinciden");
            } else {
                System.out.println("Los textos no coinciden");
            }

            WebElement carrito = driver.findElement(By.xpath("//a[contains(@onclick, 'addToCart')]"));
            carrito.click();
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
        } catch (Exception e) {
            System.out.println("No se encontro");
            e.printStackTrace();
        }
        driver.quit();
    }
}

