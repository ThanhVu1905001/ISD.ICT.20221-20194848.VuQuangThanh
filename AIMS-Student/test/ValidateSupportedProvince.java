import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import controller.PlaceOrderController;
import controller.PlaceRushOrderController;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
public class ValidateSupportedProvince {
	private PlaceRushOrderController placeRushOrderController;
    @BeforeEach
    void setUp() throws Exception {
        placeRushOrderController = new PlaceRushOrderController();
    }
    @ParameterizedTest
    @CsvSource({
            "Ha Noi,true",
            "1234,false",
            "hanoi,true",
            "Hà Nội,true",
            "Quang Ninh, false",
            ",false"
    })

    public void test(String province, boolean expected) {
        boolean isValid = placeRushOrderController.validateSupportedProvince(province);
        assertEquals(expected, isValid);
    }

}
