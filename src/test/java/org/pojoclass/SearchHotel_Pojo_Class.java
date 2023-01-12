package org.pojoclass;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotel_Pojo_Class extends BaseClass {

	public SearchHotel_Pojo_Class()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="location")
	private WebElement location;
	@FindBy(id="room_type")
	private WebElement roomType;
	@FindBy(id="room_nos")
	private WebElement roomNos;
	@FindBy(id="datepick_in")
	private WebElement checkIn;
	@FindBy(id="datepick_out")
	private WebElement checkOut;
	@FindBy(id="adult_room")
	private WebElement adultPerRoom;
	@FindBy(id="child_room")
	private WebElement childPerRoom;
	@FindBy(id="Submit")
	private WebElement submit;
	public WebElement getLocation() {
		return location;
	}
	public WebElement getRoomType() {
		return roomType;
	}
	public WebElement getRoomNos() {
		return roomNos;
	}
	public WebElement getCheckIn() {
		return checkIn;
	}
	public WebElement getCheckOut() {
		return checkOut;
	}
	public WebElement getAdultPerRoom() {
		return adultPerRoom;
	}
	public WebElement getChildPerRoom() {
		return childPerRoom;
	}
	public WebElement getSubmit() {
		return submit;
	}
	
	private void searchHotel(String location, String roomType,String roomNos,String checkIn,String checkOut,String adultPerRoom,String childPerRoom) {
		WebElement loc = getLocation();
		selectbyVisibletext(loc, location);
		
		
	}
	
	

}
 