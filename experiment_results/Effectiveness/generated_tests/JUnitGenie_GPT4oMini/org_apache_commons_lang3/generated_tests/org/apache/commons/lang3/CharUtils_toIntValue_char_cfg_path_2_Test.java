package org.apache.commons.lang3;
import org.apache.commons.lang3.CharUtils;
import org.junit.Test;
import static org.junit.Assert.fail;

public class CharUtils_toIntValue_char_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToIntValueWithNonNumericChar() {
        char input = 'A'; // Input that is not between '0' and '9'
        try {
            CharUtils.toIntValue(input);
            fail("Expected IllegalArgumentException for non-numeric character");
        } catch (IllegalArgumentException e) {
            // Exception was expected
            assert(e.getMessage().equals("The character A is not in the range '0' - '9'"));
        }
    }

    @Test(timeout = 4000)
    public void testToIntValueWithNumericChar() {
        char input = '5'; // Valid input that is between '0' and '9'
        int result = CharUtils.toIntValue(input);
        assert(result == 5); // Expected output should be the numeric value of the char
    }

}