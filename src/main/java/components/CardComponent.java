package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CardComponent extends AbsBaseComponent {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    List<WebElement> courses = driver.findElements(By.cssSelector(".sc-zzdkm7-0.hHWAES"));

    public CardComponent(WebDriver driver) {
        super(driver);
    }

    public CardComponent clickFirstCourse() {
        if (!courses.isEmpty()) {
            WebElement firstCourse = courses.get(0);
            firstCourse.click();
        } else {
            System.out.println("No courses found with the specified selector.");
        }
        return this;
    }

    public CardComponent checkName() {
        WebElement courseName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div > a.sc-zzdkm7-0.bBwNZb > h6 > div")));
        assertThat(courseName.isDisplayed()).isTrue();
        assertThat(courseName.getText()).isNotEmpty();
        return this;
    }

    public CardComponent checkDescription() {
        WebElement courseDescription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sc-1og4wiw-0.sc-157icee-0")));
        assertThat(courseDescription.isDisplayed()).isTrue();
        assertThat(courseDescription.getText()).isNotEmpty();
        return this;
    }

    public CardComponent checkDuration() {
        WebElement courseDuration = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[contains(text(), '4 месяца')]")));
        assertThat(courseDuration.isDisplayed()).isTrue();
        assertThat(courseDuration.getText()).isNotEmpty();
        return this;
    }

    public CardComponent checkFormat() {
        WebElement courseFormat = wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.cssSelector(".sc-1i9m15u-4.nIaJB")));
        assertThat(courseFormat.isDisplayed()).isTrue();
        assertThat(courseFormat.getText()).isNotEmpty();
        return this;
    }
}
