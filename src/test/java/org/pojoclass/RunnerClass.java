package org.pojoclass;

import org.base.BaseClass;
import org.testng.annotations.Test;

public class RunnerClass extends BaseClass {
	@Test
	public void adactinPage()
	{
		getdriver("chrome");
		launchUrl("https://adactinhotelapp.com/");
	}
	@Test
	public void login() {
		Login_Pojo_Class login=new Login_Pojo_Class();
		//login.LoginPage(GetDataFromExcel("sheet4", 0, 0));
	}
	
			
	

}
