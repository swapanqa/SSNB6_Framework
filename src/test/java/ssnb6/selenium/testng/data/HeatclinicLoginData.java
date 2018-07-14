package ssnb6.selenium.testng.data;

import org.testng.annotations.DataProvider;

public class HeatclinicLoginData {

	@DataProvider
	public Object[][] getTestData(){
		Object[][] data = {
				
				            {"Y","shiftqa01@gmail.com","shiftedtech","Shift"},
							{"Y","nefaur.rb@gmail.com","123456nrbxx","Nefaur"},
							{"N","arifurkh64@yahoo.com","iq9006564","Arifur"}
				           
						   };
		
		return data;
	}

}
