package SeleniumPractice.demoOpenCart;

import java.io.IOException;
import java.util.concurrent.TimeUnit;



import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class pageFactory_Tests {

	WebDriver driver = new ChromeDriver();
	
	HomePage homePage = new HomePage(driver);
	LoginPage loginPage = new LoginPage(driver);
	RegisterPage registerPage = new RegisterPage(driver);
	UserFeatures userfeaturePage = new UserFeatures(driver);
	static PredefineData testdata;
	
	String positivefname =RandomStringUtils.randomAlphabetic(10); 
	String longfname =RandomStringUtils.randomAlphabetic(33); 
	String positivelname =RandomStringUtils.randomAlphabetic(10); 
	String longlname =RandomStringUtils.randomAlphabetic(33); 
	String positiveemail =RandomStringUtils.randomAlphabetic(10)+"@gmail.com"; 
	String positiveemail1 =RandomStringUtils.randomAlphabetic(10)+"@gmail.com"; 
	String negativeemail =RandomStringUtils.randomAlphabetic(10)+"@gmail"; 
	String unregistertedemail =RandomStringUtils.randomAlphabetic(10)+"@gmail";
	String duplicateemail ="valid@valid.valid";
	String positivetele ="011"+RandomStringUtils.random(9, false, true) ;
	String shorttele ="01"; 
	String longtele ="011"+RandomStringUtils.random(30, false, true) ;
	String pass =RandomStringUtils.randomAlphanumeric(8); 
	String shortpass =RandomStringUtils.randomAlphanumeric(3); 
	String longpass =RandomStringUtils.randomAlphanumeric(3);
	String comfirmpass =pass;
	String shortcomfirmpass =shortpass;
	String longcomfirmpass =longpass;
	String negativecomfirmpass =RandomStringUtils.randomAlphanumeric(8);
	String Productquantity=RandomStringUtils.random(1, false, true);
	
	@BeforeTest
	public void before_test() throws IOException {
		testdata =new PredefineData();
		driver.get(testdata.property.getProperty("Baseurl"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	}
	@Test(priority=1)
	public void login_Positive() {
		homePage.Click_login_from_MyAccount();
		loginPage.provideEmail(testdata.property.getProperty("Email"));
		loginPage.providePassword(testdata.property.getProperty("password"));
		loginPage.ClickSubmitButton();
		Assert.assertEquals(loginPage.verifySuccessLogin(), "Account");
		loginPage.ClickLogoutButton();
	}
	@Test(priority=2)
	public void login_Negative_InvalidEmail() {
		homePage.Click_login_from_MyAccount();
		loginPage.provideEmail(unregistertedemail);
		loginPage.providePassword(testdata.property.getProperty("password"));
		loginPage.ClickSubmitButton();
		Assert.assertEquals(loginPage.verifyFailedLogin(), "Warning: No match for E-Mail Address and/or Password.");
	}
	@Test(priority=3)
	public void login_Negative_InvalidPassword() {
		homePage.Click_login_from_MyAccount();
		loginPage.provideEmail(testdata.property.getProperty("Email"));
		loginPage.providePassword(pass);
		loginPage.ClickSubmitButton();
		Assert.assertEquals(loginPage.verifyFailedLogin(), "Warning: No match for E-Mail Address and/or Password.");
	}
	
	@Test(priority=4)
	public void login_Negative_InvalidEmail_InvalidPassword() {
		homePage.Click_login_from_MyAccount();
		loginPage.provideEmail(unregistertedemail);
		loginPage.providePassword(shortpass);
		loginPage.ClickSubmitButton();
		Assert.assertEquals(loginPage.verifyFailedLogin(), "Warning: No match for E-Mail Address and/or Password.");
	}
	@Test(priority=5)
	public void login_Negative_Blank() {
		homePage.Click_login_from_MyAccount();
		loginPage.provideEmail("");
		loginPage.providePassword("");
		loginPage.ClickSubmitButton();
		Assert.assertEquals(loginPage.verifyFailedLogin(), "Warning: No match for E-Mail Address and/or Password.");
	}
	@Test(priority=6)
	public void login_Negative_WrongFormatEmail() {
		homePage.Click_login_from_MyAccount();
		loginPage.provideEmail(negativeemail);
		loginPage.providePassword(pass);
		loginPage.ClickSubmitButton();
		Assert.assertEquals(loginPage.verifyFailedLogin(), "Warning: No match for E-Mail Address and/or Password.");
	}
	
	@Test(priority=7)
	public void Register_All_Positive() {
		homePage.Click_register_from_MyAccount();
		registerPage.provideFname(positivefname);
		registerPage.provideLname(positivelname);
		registerPage.provideEmail(positiveemail);
		registerPage.provideTelephone(positivetele);
		registerPage.providePassword(pass);
		registerPage.provideConfirmPassword(comfirmpass);
		registerPage.ClickCheckbox();
		registerPage.ClickContinueButton();
		Assert.assertEquals(registerPage.verifySuccessRegister(), "Your Account Has Been Created!");
		registerPage.ClickLogoutButton();
	}
	@Test(priority=8)
	public void Register_Negative_InvalidFname_Length() {
		homePage.Click_register_from_MyAccount();
		registerPage.provideFname(longfname);
		registerPage.provideLname(positivelname);
		registerPage.provideEmail(positiveemail1);
		registerPage.provideTelephone(positivetele);
		registerPage.providePassword(pass);
		registerPage.provideConfirmPassword(comfirmpass);
		registerPage.ClickCheckbox();
		registerPage.ClickContinueButton();
		Assert.assertEquals(registerPage.verifyFailedInvalidFnameLength(), "First Name must be between 1 and 32 characters!");
	}
	@Test(priority=9)
	public void Register_Negative_Blank_Fname() {
		homePage.Click_register_from_MyAccount();
		registerPage.provideFname("");
		registerPage.provideLname(positivelname);
		registerPage.provideEmail(positiveemail1);
		registerPage.provideTelephone(positivetele);
		registerPage.providePassword(pass);
		registerPage.provideConfirmPassword(comfirmpass);
		registerPage.ClickCheckbox();
		registerPage.ClickContinueButton();
		Assert.assertEquals(registerPage.verifyFailedInvalidFnameLength(), "First Name must be between 1 and 32 characters!");
	}
	@Test(priority=10)
	public void Register_Negative_InvalidLname_Length() {
		homePage.Click_register_from_MyAccount();
		registerPage.provideFname(positivefname);
		registerPage.provideLname(longlname);
		registerPage.provideEmail(positiveemail1);
		registerPage.provideTelephone(positivetele);
		registerPage.providePassword(pass);
		registerPage.provideConfirmPassword(comfirmpass);
		registerPage.ClickCheckbox();
		registerPage.ClickContinueButton();
		Assert.assertEquals(registerPage.verifyFailedInvalidLnameLength(), "Last Name must be between 1 and 32 characters!");
	}
	@Test(priority=11)
	public void Register_Negative_Blank_Lname() {
		homePage.Click_register_from_MyAccount();
		registerPage.provideFname(positivefname);
		registerPage.provideLname("");
		registerPage.provideEmail(positiveemail1);
		registerPage.provideTelephone(positivetele);
		registerPage.providePassword(pass);
		registerPage.provideConfirmPassword(comfirmpass);
		registerPage.ClickCheckbox();
		registerPage.ClickContinueButton();
		Assert.assertEquals(registerPage.verifyFailedInvalidLnameLength(), "Last Name must be between 1 and 32 characters!");
	}
	@Test(priority=12)
	public void Register_Negative_Invalid_Email() {
		homePage.Click_register_from_MyAccount();
		registerPage.provideFname(positivefname);
		registerPage.provideLname(positivelname);
		registerPage.provideEmail(negativeemail);
		registerPage.provideTelephone(positivetele);
		registerPage.providePassword(pass);
		registerPage.provideConfirmPassword(comfirmpass);
		registerPage.ClickCheckbox();
		registerPage.ClickContinueButton();
		Assert.assertEquals(registerPage.verifyBlankEmail(),"E-Mail Address does not appear to be valid!");
	}
	@Test(priority=13)
	public void Register_Negative_Blank_Email() {
		homePage.Click_register_from_MyAccount();
		registerPage.provideFname(positivefname);
		registerPage.provideLname(positivelname);
		registerPage.provideEmail("");
		registerPage.provideTelephone(positivetele);
		registerPage.providePassword(pass);
		registerPage.provideConfirmPassword(comfirmpass);
		registerPage.ClickCheckbox();
		registerPage.ClickContinueButton();
		Assert.assertEquals(registerPage.verifyBlankEmail(),"E-Mail Address does not appear to be valid!");
	}
	@Test(priority=14)
	public void Register_Negative_Duplicate_Email() {
		homePage.Click_register_from_MyAccount();
		registerPage.provideFname(positivefname);
		registerPage.provideLname(positivelname);
		registerPage.provideEmail(duplicateemail);
		registerPage.provideTelephone(positivetele);
		registerPage.providePassword(pass);
		registerPage.provideConfirmPassword(comfirmpass);
		registerPage.ClickCheckbox();
		registerPage.ClickContinueButton();
		Assert.assertEquals(registerPage.verifyErrorForSameEmail(),"Warning: E-Mail Address is already registered!");
	}
	@Test(priority=15)
	public void Register_Negative_Invalid_Teleno_LengthShort() {
		homePage.Click_register_from_MyAccount();
		registerPage.provideFname(positivefname);
		registerPage.provideLname(positivelname);
		registerPage.provideEmail(positiveemail1);
		registerPage.provideTelephone(shorttele);
		registerPage.providePassword(pass);
		registerPage.provideConfirmPassword(comfirmpass);
		registerPage.ClickCheckbox();
		registerPage.ClickContinueButton();
		Assert.assertEquals(registerPage.verifyInvalidTelenoLength(),"Telephone must be between 3 and 32 characters!");
	}
	@Test(priority=16)
	public void Register_Negative_Blank_Teleno_Length() {
		homePage.Click_register_from_MyAccount();
		registerPage.provideFname(positivefname);
		registerPage.provideLname(positivelname);
		registerPage.provideEmail(positiveemail1);
		registerPage.provideTelephone("");
		registerPage.providePassword(pass);
		registerPage.provideConfirmPassword(comfirmpass);
		registerPage.ClickCheckbox();
		registerPage.ClickContinueButton();
		Assert.assertEquals(registerPage.verifyInvalidTelenoLength(),"Telephone must be between 3 and 32 characters!");
	}
	@Test(priority=17)
	public void Register_Negative_Invalid_Teleno_LengthLong() {
		homePage.Click_register_from_MyAccount();
		registerPage.provideFname(positivefname);
		registerPage.provideLname(positivelname);
		registerPage.provideEmail(positiveemail1);
		registerPage.provideTelephone(longtele);
		registerPage.providePassword(pass);
		registerPage.provideConfirmPassword(comfirmpass);
		registerPage.ClickCheckbox();
		registerPage.ClickContinueButton();
		Assert.assertEquals(registerPage.verifyInvalidTelenoLength(),"Telephone must be between 3 and 32 characters!");
	}
	@Test(priority=18)
	public void Register_Negative_Different_Password() {
		homePage.Click_register_from_MyAccount();
		registerPage.provideFname(positivefname);
		registerPage.provideLname(positivelname);
		registerPage.provideEmail(positiveemail1);
		registerPage.provideTelephone(positivetele);
		registerPage.providePassword(pass);
		registerPage.provideConfirmPassword(negativecomfirmpass);
		registerPage.ClickCheckbox();
		registerPage.ClickContinueButton();
		Assert.assertEquals(registerPage.verifyErrorForDifferentPassword(),"Password confirmation does not match password!");
	}
	@Test(priority=19)
	public void Register_Negative_Short_Password_Length() {
		homePage.Click_register_from_MyAccount();
		registerPage.provideFname(positivefname);
		registerPage.provideLname(positivelname);
		registerPage.provideEmail(positiveemail1);
		registerPage.provideTelephone(positivetele);
		registerPage.providePassword(shortpass);
		registerPage.provideConfirmPassword(shortcomfirmpass);
		registerPage.ClickCheckbox();
		registerPage.ClickContinueButton();
		Assert.assertEquals(registerPage.verifyErrorInvalidPasswordLength(),"Password must be between 4 and 20 characters!");
	}
	@Test(priority=20)
	public void Register_Negative_Long_Password_Length() {
		homePage.Click_register_from_MyAccount();
		registerPage.provideFname(positivefname);
		registerPage.provideLname(positivelname);
		registerPage.provideEmail(positiveemail1);
		registerPage.provideTelephone(positivetele);
		registerPage.providePassword(longpass);
		registerPage.provideConfirmPassword(longcomfirmpass);
		registerPage.ClickCheckbox();
		registerPage.ClickContinueButton();
		Assert.assertEquals(registerPage.verifyErrorInvalidPasswordLength(),"Password must be between 4 and 20 characters!");
	}
	@Test(priority=21)
	public void Register_Negative_Blank_Password_Length() {
		homePage.Click_register_from_MyAccount();
		registerPage.provideFname(positivefname);
		registerPage.provideLname(positivelname);
		registerPage.provideEmail(positiveemail1);
		registerPage.provideTelephone(positivetele);
		registerPage.providePassword("");
		registerPage.provideConfirmPassword("");
		registerPage.ClickCheckbox();
		registerPage.ClickContinueButton();
		Assert.assertEquals(registerPage.verifyErrorInvalidPasswordLength(),"Password must be between 4 and 20 characters!");
	}
	@Test(priority=22)
	public void Register_Negative_Unchecked_Privacy_Policy() {
		homePage.Click_register_from_MyAccount();
		registerPage.provideFname(positivefname);
		registerPage.provideLname(positivelname);
		registerPage.provideEmail(positiveemail1);
		registerPage.provideTelephone(positivetele);
		registerPage.providePassword(pass);
		registerPage.provideConfirmPassword(comfirmpass);
		registerPage.ClickContinueButton();
		Assert.assertEquals(registerPage.verifyErrorForUncheckedPrivacyPolicy(),"Warning: You must agree to the Privacy Policy!");
	}
	@Test(priority=23)
	public void Order_History_View() {
		homePage.Click_login_from_MyAccount();
		loginPage.provideEmail(testdata.property.getProperty("Email"));
		loginPage.providePassword(testdata.property.getProperty("password"));
		loginPage.ClickSubmitButton();
		Assert.assertEquals(loginPage.verifySuccessLogin(), "Account");
		userfeaturePage.ClickOrderHistory();
		Assert.assertEquals(userfeaturePage.verifyOrderHistoryPage(),"Order History");
		userfeaturePage.ClickAccount();
		loginPage.ClickLogoutButton();
	}
	@Test(priority=24)
	public void Download_Page_View() {
		homePage.Click_login_from_MyAccount();
		loginPage.provideEmail(testdata.property.getProperty("Email"));
		loginPage.providePassword(testdata.property.getProperty("password"));
		loginPage.ClickSubmitButton();
		Assert.assertEquals(loginPage.verifySuccessLogin(), "Account");
		userfeaturePage.ClickDownload();
		Assert.assertEquals(userfeaturePage.verifyDownloadPage(),"Account Downloads");
		userfeaturePage.ClickAccount();
		loginPage.ClickLogoutButton();
	}
	@Test(priority=25)
	public void Transaction_Page_View() {
		homePage.Click_login_from_MyAccount();
		loginPage.provideEmail(testdata.property.getProperty("Email"));
		loginPage.providePassword(testdata.property.getProperty("password"));
		loginPage.ClickSubmitButton();
		Assert.assertEquals(loginPage.verifySuccessLogin(), "Account");
		userfeaturePage.ClickTransaction();
		Assert.assertEquals(userfeaturePage.verifyTransactionPage(),"Your Transactions");
		userfeaturePage.ClickAccount();
		loginPage.ClickLogoutButton();
	}
	@Test(priority=26)
	public void Add_To_Wishlist() {
		homePage.Click_login_from_MyAccount();
		loginPage.provideEmail(testdata.property.getProperty("Email"));
		loginPage.providePassword(testdata.property.getProperty("password"));
		loginPage.ClickSubmitButton();
		Assert.assertEquals(loginPage.verifySuccessLogin(), "Account");
		userfeaturePage.ClickHomePageButton();
		userfeaturePage.ClickIphoneProductViewButton();
		userfeaturePage.ClickWishlistAddButton();
		Assert.assertEquals(userfeaturePage.VerifyWishlistAddMessage(), "wish list");
		userfeaturePage.ClickHomePageButton();
		loginPage.ClickLogoutButton();
	}
	@Test(priority=27)
	public void Add_To_Cart_From_Productview() {
		userfeaturePage.ClickIphoneProductViewButton();
		userfeaturePage.ClickAddToCartButtonFromProductview();
		Assert.assertEquals(userfeaturePage.VerifyShoppingcartAddMessage(), "shopping cart");
		userfeaturePage.ClickHomePageButton();
	}
	@Test(priority=28)
	public void Add_To_Cart_From_Wishlist() {
		homePage.Click_login_from_MyAccount();
		loginPage.provideEmail(testdata.property.getProperty("Email"));
		loginPage.providePassword(testdata.property.getProperty("password"));
		loginPage.ClickSubmitButton();
		Assert.assertEquals(loginPage.verifySuccessLogin(), "Account");
		userfeaturePage.ClickWishlistViewButton();
		userfeaturePage.ClickAddToCartButtonFromWishlist();
		Assert.assertEquals(userfeaturePage.VerifyShoppingcartAddMessage(), "shopping cart");
		loginPage.ClickLogoutButton();
	}
	@Test(priority=29)
	public void Update_Cart_From_Shopping_Cart() {
		homePage.Click_login_from_MyAccount();
		loginPage.provideEmail(testdata.property.getProperty("Email"));
		loginPage.providePassword(testdata.property.getProperty("password"));
		loginPage.ClickSubmitButton();
		Assert.assertEquals(loginPage.verifySuccessLogin(), "Account");
		userfeaturePage.ClickShoppingCartViewButton();
		userfeaturePage.ProvideProductQuantity(Productquantity);
		userfeaturePage.ClickShoppingCartUpdateButton();
		Assert.assertEquals(userfeaturePage.VerifyShoppingcartQuantity(), Productquantity);
		userfeaturePage.ClickHomePageButton();
		loginPage.ClickLogoutButton();
	}
	@Test(priority=30)
	public void Search_by_loggedin() {
		homePage.Click_login_from_MyAccount();
		loginPage.provideEmail(testdata.property.getProperty("Email"));
		loginPage.providePassword(testdata.property.getProperty("password"));
		loginPage.ClickSubmitButton();
		Assert.assertEquals(loginPage.verifySuccessLogin(), "Account");
		userfeaturePage.ProvideSearchInput(testdata.property.getProperty("iphone"));
		userfeaturePage.ClickSearchButton();
		Assert.assertEquals(userfeaturePage.VerifySearchIphone(), "iPhone");
		loginPage.ClickLogoutButton();
	}
	@Test(priority=31)
	public void Search_without_loggedin() {
		userfeaturePage.ProvideSearchInput(testdata.property.getProperty("canon"));
		userfeaturePage.ClickSearchButton();
		Assert.assertEquals(userfeaturePage.VerifySearchCanon(), "Canon EOS 5D");
		userfeaturePage.ClickHomePageButton();
	}
	@AfterTest
	public void after_test() {
		driver.close();
	}
}
