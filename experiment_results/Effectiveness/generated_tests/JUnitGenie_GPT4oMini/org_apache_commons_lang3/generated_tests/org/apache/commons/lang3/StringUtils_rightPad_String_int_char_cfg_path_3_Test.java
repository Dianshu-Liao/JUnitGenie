package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_rightPad_String_int_char_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testRightPad() {
        // Test case where str is not null and pads are greater than 0
        String result = StringUtils.rightPad("test", 8, ' ');
        assertEquals("test    ", result);

        // Test case where str is not null and pads are 0
        result = StringUtils.rightPad("test", 4, ' ');
        assertEquals("test", result);

        // Test case where str is null
        result = StringUtils.rightPad(null, 8, ' ');
        assertEquals(null, result);

        // Test case where pads are greater than PAD_LIMIT (assuming PAD_LIMIT is defined)
        // This case requires a specific value for PAD_LIMIT, which is not defined in the provided code.
        // Uncomment and adjust the following line if PAD_LIMIT is known.
        // result = StringUtils.rightPad("test", 100, ' '); // Example for exceeding PAD_LIMIT
        // assertEquals("test" + " ".repeat(96), result); // Adjust based on actual PAD_LIMIT behavior
    }

}