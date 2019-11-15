package SeleniumPractice.demoOpenCart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserFeatures {

	WebDriver driver;
	
	public UserFeatures(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//A[@href='https://demo.opencart.com/index.php?route=account/order'][text()='View your order history']")
	WebElement Order_History_Link;
	
	@FindBy(xpath="(//A[@href='https://demo.opencart.com/index.php?route=account/download'][text()='Downloads'][text()='Downloads'])[2]")
	WebElement Download_Link;
	
	@FindBy(xpath="//A[@href='https://demo.opencart.com/index.php?route=account/transaction'][text()='Your Transactions']")
	WebElement Transaction_Link;
	
	@FindBy(xpath="//H1[text()='Order History']")
	WebElement Order_History_Page_Verification;
	
	@FindBy(xpath="//H2[text()='Account Downloads']")
	WebElement Download_Page_Verification;
	
	@FindBy(xpath="//H1[text()='Your Transactions']")
	WebElement Transaction_Page_Verification;
	
	@FindBy(xpath="//A[@href='https://demo.opencart.com/index.php?route=account/account'][text()='Account']")
	WebElement Return_Dashboard;
	
	@FindBy(xpath="//I[@class='fa fa-home']")
	WebElement Home_Page_Button;
	
	@FindBy(xpath="(//I[@class='fa fa-heart'])[2]")
	WebElement Wishlist_Add_Button;
	
	@FindBy(xpath="(//A[@href='https://demo.opencart.com/index.php?route=account/wishlist'][text()='Wish List'][text()='Wish List'])[1]")
	WebElement Wishlist_View_Button;
	
	@FindBy(xpath="//SPAN[@class='hidden-xs hidden-sm hidden-md'][text()='Shopping Cart']")
	WebElement Shopping_Cart_View_Button;
	
	@FindBy(xpath="//IMG[@src='https://demo.opencart.com/image/cache/catalog/demo/iphone_1-200x200.jpg']")
	WebElement Iphone_Product_View_Button;
	
	@FindBy(xpath="//BUTTON[@id='button-cart']")
	WebElement Add_To_Cart_Button_From_Productview;
	
	@FindBy(xpath="(//I[@class='fa fa-shopping-cart'])[4]")
	WebElement Add_To_Cart_Button_From_Wishlist;
	
	@FindBy(xpath="(//INPUT[@type='text'])[2]")
	WebElement Shopping_Cart_Update_Input_Field;
	
	@FindBy(xpath="//I[@class='fa fa-refresh']")
	WebElement Shopping_Cart_Update_Button;
	
	@FindBy(xpath="//A[@href='https://demo.opencart.com/index.php?route=account/wishlist'][text()='wish list']")
	WebElement Verify_Wishlist_Add_Message;
	
	@FindBy(xpath="//A[@href='https://demo.opencart.com/index.php?route=checkout/cart'][text()='shopping cart']")
	WebElement Verify_Shoppingcart_Add_Message;

	@FindBy(xpath="//INPUT[@type='text']")
	WebElement SearchBox;
	
	@FindBy(xpath="(//BUTTON[@type='button'])[4]")
	WebElement SearchButton;
	
	@FindBy(xpath="//A[@href='https://demo.opencart.com/index.php?route=product/product&product_id=40&search=iphone'][text()='iPhone']")
	WebElement Verify_Search_Iphone;
	
	@FindBy(xpath="//A[@href='https://demo.opencart.com/index.php?route=product/product&product_id=30&search=canon'][text()='Canon EOS 5D']")
	WebElement Verify_Search_Canon;
	
	public void ProvideProductQuantity(String quantity ) {
		Shopping_Cart_Update_Input_Field.clear();
		Shopping_Cart_Update_Input_Field.sendKeys(quantity);
	}
	public void ProvideSearchInput(String search ) {
		SearchBox.sendKeys(search);
	}
	public void ClickSearchButton() {
		SearchButton.click();
	}
	public void ClickShoppingCartUpdateButton() {
		Shopping_Cart_Update_Button.click();
	}
	public void ClickShoppingCartViewButton() {
		Shopping_Cart_View_Button.click();
	}
	public void ClickWishlistViewButton() {
		Wishlist_View_Button.click();
	}
	public void ClickAddToCartButtonFromWishlist() {
		Add_To_Cart_Button_From_Wishlist.click();
	}
	public void ClickAddToCartButtonFromProductview() {
		Add_To_Cart_Button_From_Productview.click();
	}
	public void ClickIphoneProductViewButton() {
		Iphone_Product_View_Button.click();
	}
	public void ClickWishlistAddButton() {
		Wishlist_Add_Button.click();
	}
	public void ClickHomePageButton() {
		Home_Page_Button.click();
	}
	
	public void ClickOrderHistory() {
		Order_History_Link.click();
	}
	public void ClickDownload() {
		Download_Link.click();
	}
	public void ClickTransaction() {
		Transaction_Link.click();
	}
	public void ClickAccount() {
		Return_Dashboard.click();
	}
	public String verifyOrderHistoryPage() {
		Order_History_Page_Verification.getText();
		return Order_History_Page_Verification.getText();
		
	}
	public String verifyDownloadPage() {
		Download_Page_Verification.getText();
		return Download_Page_Verification.getText();
		
	}
	public String verifyTransactionPage() {
		Transaction_Page_Verification.getText();
		return Transaction_Page_Verification.getText();
		
	}
	public String VerifyWishlistAddMessage() {
		Verify_Wishlist_Add_Message.getText();
		return Verify_Wishlist_Add_Message.getText();
		
	}
	public String VerifyShoppingcartAddMessage() {
		Verify_Shoppingcart_Add_Message.getText();
		return Verify_Shoppingcart_Add_Message.getText();
		
	}
	public String VerifyShoppingcartQuantity() {
		Shopping_Cart_Update_Input_Field.getAttribute("value");
		return Shopping_Cart_Update_Input_Field.getAttribute("value");
		
	}
	public String VerifySearchIphone() {
		Verify_Search_Iphone.getText();
		return Verify_Search_Iphone.getText();
		
	}
	public String VerifySearchCanon() {
		Verify_Search_Canon.getText();
		return Verify_Search_Canon.getText();
		
	}
}
