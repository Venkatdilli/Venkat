package org.pojoclass;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Pojo_Class extends BaseClass {
	public Login_Pojo_Class() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username")
	private WebElement userName;
	
	@FindBy(id="password")
	private WebElement passWord;
	
	@FindAll({@FindBy(id="login"),@FindBy(name="login")})
	private WebElement login;

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassWord() {
		return passWord;
	}

	public WebElement getLogin() {
		return login;
	}
	public void LoginPage(String userName,String passWord)
	{
		WebElement userName2 = getUserName();
		Sendkeys(userName2, userName);
		WebElement passWord2 = getPassWord();
		Sendkeys(passWord2, passWord);
		WebElement login2 = getLogin();
		click(login2);
	}
 
}
