package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;


public class JavaJitsuGroupTest extends BaseTest {



    @Test
    public void testNewItem() {
        WebElement newItem = getDriver().findElement(By.xpath("//*[@id=\"tasks\"]/div[1]/span/a"));
        newItem.click();
        getWait2().until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.xpath("//input[@id=\"name\"]")))).sendKeys("JavaTest");
        WebElement freProject = getDriver().findElement(By.xpath("//span[text() =\"Freestyle project\"]"));
        freProject.click();
        WebElement okButton = getDriver().findElement(By.id("ok-button"));
        okButton.click();
        WebElement configElement = getDriver().findElement(By.xpath("//div[@class = 'jenkins-app-bar__content']/h1"));
        Assert.assertEquals(configElement.getText(), "Configure");
    }
    @Test
    public void testCreateJob() {
        WebElement creJob = getDriver().findElement(By.xpath("//span[text()=\"Create a job\"]"));
        creJob.click();
        getWait2().until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.cssSelector("input#name")))).sendKeys("JavaTest");

        WebElement pipeLine = getDriver().findElement(By.xpath("//span[text() =\"Pipeline\"]"));
        pipeLine.click();
        WebElement okButton = getDriver().findElement(By.id("ok-button"));
        okButton.click();
        WebElement butSave = getDriver().findElement(By.cssSelector("button[name=\"Submit\"]"));
        butSave.click();
        WebElement nameJob = getDriver().findElement(By.xpath("//h1[text() =\"Pipeline JavaTest\"]"));
        Assert.assertEquals(nameJob.getText(), "Pipeline JavaTest");
    }

    @Test
    public void testAddDescription() {
        final String text = "text";
        WebElement addLink = getDriver().findElement(By.xpath("//a[@id='description-link']"));
        addLink.click();
        WebElement textInput = getWait2().until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.cssSelector("textarea[name='description']"))));
        textInput.clear();
        textInput.sendKeys(text);
        WebElement buttonSave = getDriver().findElement(By.cssSelector("button[formnovalidate='formNoValidate' ]"));
        buttonSave.click();
        WebElement inputAdd = getDriver().findElement(By.xpath("//div[@id='description']/div[1]"));
        Assert.assertEquals(inputAdd.getText(), text);
    }

    @Test
    public void testBuildExecutorStatus() {
        getDriver().findElement(By.xpath("//a[text()='Build Executor Status']")).click();
        getDriver().findElement(By.className("jenkins-button")).click();
        final String text = "New node name";
        getDriver().findElement(By.cssSelector("input[id = 'name']")).sendKeys(text);
        getDriver().findElement(By.className("jenkins-radio__label")).click();
        getDriver().findElement(By.cssSelector("#ok")).click();
        getDriver().findElement(By.cssSelector("button[name='Submit']")).click();
        WebElement ManageNodes = getDriver().findElement(By.xpath("//h1[text() = 'Manage nodes and clouds']"));
        Assert.assertEquals(ManageNodes.getText(),"Manage nodes and clouds");
    }
}
