package SeleniumPractice.demoOpenCart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	WebElement Login_email;
	
	@FindBy(id="input-password")
	WebElement Login_pass;
	
	@FindBy(xpath="//INPUT[@type='submit']")
	WebElement LoginSubmitButton;
	
	@FindBy(xpath="//DIV[@class='alert alert-danger alert-dismissible']")
	WebElement ErrorMesageForFailedLogin;
	
	@FindBy(xpath="//A[@href='https://demo.opencart.com/index.php?route=account/account'][text()='Account']")
	WebElement MessageForSuccessfulLogin;
	
	@FindBy(xpath="//SPAN[@class='caret']")
	WebElement LogoutMenuButton;

	@FindBy(xpath="(//A[@href='https://demo.opencart.com/index.php?route=account/logout'][text()='Logout'][text()='Logout'])[1]")
	WebElement LogoutButton;
	
	@FindBy(xpath="//A[@href='https://demo.opencart.com/index.php?route=common/home'][text()='Continue']/self::A")
	WebElement AfterLogoutContinueButton;
	
	public void provideEmail(String email) {
		Login_email.sendKeys(email);
	}
	
	public void providePassword(String pass) {
		Login_pass.sendKeys(pass);
	}
	
	public void ClickSubmitButton() {
		LoginSubmitButton.click();
	}
	
	public void ClickLogoutButton() {
		LogoutMenuButton.click();
		LogoutButton.click();
		AfterLogoutContinueButton.click();
	}
	
	public String verifyFailedLogin() {
		ErrorMesageForFailedLogin.getText();
		return ErrorMesageForFailedLogin.getText();
		
	}
	public String verifySuccessLogin() {
		MessageForSuccessfulLogin.getText();
		return MessageForSuccessfulLogin.getText();
		
	}
}
