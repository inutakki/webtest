package parameters;
 
import org.testng.annotations.DataProvider;
 
public class FlightSearchInputDP {
 
        @DataProvider(name="FlightSearchInputDP")
        public static Object[][] getDataFromDataprovider(){
 
            return new Object[][] {
 
                { "ATL", "BOM", "10/30/2015", "11/30/2015" },
                //{ "SFO", "MUM", "10/30/2015", "11/30/2015" },
                //{ "BOS", "MUM", "10/30/2015", "11/30/2015" }
 
                };

        }}
