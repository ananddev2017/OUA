package enh.web.pages;

import org.openqa.selenium.By;

public class PaymentPage extends HomePage{
	public enum PaymentOptions { CREDIT_CARD, DEBIT_CARD, NET_BANKING, WALLETS}
	
	public static By listPaymentMethod = By.xpath("//ul[@class='payment-method-list']");
	public static By txtTotalAmountPaybleLibe = By.xpath("//div[@class='payment-header']/span[contains(.,'Total amount payable')]");
	
	public static boolean isPaymentPageLoaded(){
		return isWebElementPresent(listPaymentMethod);
	}
	
	public static boolean totalAmountPayableIsDisplayed(){
		return isWebElementVisible(txtTotalAmountPaybleLibe);
	}
	public static String getTotalAmountPayableLine(){
		return getElementText(txtTotalAmountPaybleLibe);
	}
	
	public static boolean verifyPaymentOptionIsDisplayed(PaymentOptions paymentOpt ){
		String option="";
		switch(paymentOpt){
		case CREDIT_CARD :
			option ="Credit Card";
			break;
		case DEBIT_CARD :
			option ="Debit Card";
			break;
		case NET_BANKING :
			option ="Net Banking";
			break;
		case WALLETS :
			option ="Wallets";
			break;	
		}
		String xpath =String.format("//div[contains(@class,'payment-method-wrapper')]/ul/li[contains(.,'%s')][contains(@class,'active')]", option);
		return  isWebElementPresent(By.xpath(xpath));
	}
	
	public static void inputCreditCardNumber(String number) throws Exception{
		executeStep(inputText(By.xpath("//*[@id='credit-card']//input[@name='ccnum']"), number), "Input credit card number: "+number);
	}
	
	public static boolean verifyCardTypeIsMasterCard() throws Exception{
		return isWebElementPresent(By.xpath("//*[@id='credit-card']//i[contains(@class,'mastercard')]"));
	}
	
	
	

}
