package SeleniumPractice.demoOpenCart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-firstname")
	WebElement FirstName;
	
	@FindBy(id="input-lastname")
	WebElement LastName;
	
	@FindBy(id="input-email")
	WebElement Register_email;
	
	@FindBy(id="input-telephone")
	WebElement Register_telephone;
	
	@FindBy(id="input-password")
	WebElement Register_password;
	
	@FindBy(id="input-confirm")
	WebElement Register_password_confirm;
	
	@FindBy(xpath="//INPUT[@type='checkbox']")
	WebElement Privacy_Policy_Checkbox;
	
	@FindBy(xpath="//INPUT[@type='submit']")
	WebElement RegisterSubmitButton;
	
	@FindBy(xpath="//H1[text()='Your Account Has Been Created!']")
	WebElement MessageForSuccessfulRegister;
	
	@FindBy(xpath="//DIV[@class='text-danger'][text()='First Name must be between 1 and 32 characters!']")
	WebElement ErrorMessageForInvalidFnameLength;
	
	@FindBy(xpath="//DIV[@class='text-danger'][text()='Last Name must be between 1 and 32 characters!']")
	WebElement ErrorMessageForInvalidLnameLength;
	
	@FindBy(xpath="//DIV[@class='text-danger'][text()='E-Mail Address does not appear to be valid!']")
	WebElement ErrorMessageForBlankEmail;
	
	@FindBy(xpath="//DIV[@class='text-danger'][text()='Telephone must be between 3 and 32 characters!']")
	WebElement ErrorMessageForInvalidTelephoneNoLength;
	
	@FindBy(xpath="//DIV[@class='text-danger'][text()='Password confirmation does not match password!']")
	WebElement ErrorMessageForDifferentPassword;
	
	@FindBy(xpath="//DIV[@class='text-danger'][text()='Password must be between 4 and 20 characters!']")
	WebElement ErrorMessageForInvalidPasswordLength;
	
	@FindBy(xpath="//DIV[@class='alert alert-danger alert-dismissible']")
	WebElement ErrorMessageForUncheckedPrivacyPolicy;
	
	@FindBy(xpath="//DIV[@class='alert alert-danger alert-dismissible']")
	WebElement ErrorMessageForSameEmail;
	
	@FindBy(xpath="(//A[@href='https://demo.opencart.com/index.php?route=account/logout'][text()='Logout'][text()='Logout'])[2]")
	WebElement LogoutButton;
	
	
	@FindBy(xpath="//A[@href='https://demo.opencart.com/index.php?route=common/home'][text()='Continue']")
	WebElement AfterLogoutContinueButton;
	public void provideFname(String fname) {
		FirstName.sendKeys(fname);
	}
	
	public void provideLname(String lname) {
		LastName.sendKeys(lname);
	}
	
	public void provideEmail(String email) {
		Register_email.sendKeys(email);
	}
	public void provideTelephone(String tphone) {
		Register_telephone.sendKeys(tphone);
	}
	
	public void providePassword(String pass) {
		Register_password.sendKeys(pass);
	}
	public void provideConfirmPassword(String confirmpass) {
		Register_password_confirm.sendKeys(confirmpass);
	}
	public void ClickCheckbox() {
		Privacy_Policy_Checkbox.click();
	}
	public void ClickContinueButton() {
		RegisterSubmitButton.click();
	}
	
	public String verifySuccessRegister() {
		MessageForSuccessfulRegister.getText();
		return MessageForSuccessfulRegister.getText();
		//Your Account Has Been Created!
	}
	
	public String verifyFailedInvalidFnameLength() {
		ErrorMessageForInvalidFnameLength.getText();
		return ErrorMessageForInvalidFnameLength.getText();
		
	}
	
	public String verifyFailedInvalidLnameLength() {
		ErrorMessageForInvalidLnameLength.getText();
		return ErrorMessageForInvalidLnameLength.getText();
		
	}
	public String verifyBlankEmail() {
		ErrorMessageForBlankEmail.getText();
		return ErrorMessageForBlankEmail.getText();
		
	}
	public String verifyInvalidTelenoLength() {
		ErrorMessageForInvalidTelephoneNoLength.getText();
		return ErrorMessageForInvalidTelephoneNoLength.getText();
		
	}
	public String verifyErrorForDifferentPassword() {
		ErrorMessageForDifferentPassword.getText();
		return ErrorMessageForDifferentPassword.getText();
		
	}
	public String verifyErrorInvalidPasswordLength() {
		ErrorMessageForInvalidPasswordLength.getText();
		return ErrorMessageForInvalidPasswordLength.getText();
		
	}
	public String verifyErrorForUncheckedPrivacyPolicy() {
		ErrorMessageForUncheckedPrivacyPolicy.getText();
		return ErrorMessageForUncheckedPrivacyPolicy.getText();
		
	}
	public String verifyErrorForSameEmail() {
		ErrorMessageForSameEmail.getText();
		return ErrorMessageForSameEmail.getText();
		
	}
	public void ClickLogoutButton() {
		LogoutButton.click();
		AfterLogoutContinueButton.click();
	}
}
