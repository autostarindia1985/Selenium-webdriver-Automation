package pom;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name="Search")
    public static Object[][] getDataFromDataprovider(){
        return new Object[][] {
            { "Indira nagar"},
            { "Krishna"},
            { "Bhupesh"},
            { "Guru99"},
            { "Krishna"},
            { "Bhupesh"},
            { "Guru99"},
            
            
        };  

}}
