import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import controller.PlaceOrderController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class ValidateAddressTest {
	 private PlaceOrderController placeOrderController;
	    @BeforeEach
	    void setUp() throws Exception {
	        placeOrderController = new PlaceOrderController();
	    }
	    @ParameterizedTest
	    @CsvSource({
	            "hanoi,true",
	            "so 10/64 Hai Ba Trung Ha Noi,true",
	            "$#Ha-oi,false",
	            "12334,false"
	    })

	    public void test(String address, boolean expected) {
	        boolean isValid = placeOrderController.validateAddress(address);
	        assertEquals(expected, isValid);
	    }
}
