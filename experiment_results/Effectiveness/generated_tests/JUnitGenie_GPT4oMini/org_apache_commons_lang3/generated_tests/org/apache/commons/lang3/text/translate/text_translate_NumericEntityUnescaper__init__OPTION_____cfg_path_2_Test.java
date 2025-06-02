package org.apache.commons.lang3.text.translate;
import org.apache.commons.lang3.text.translate.NumericEntityUnescaper;
import org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class text_translate_NumericEntityUnescaper__init__OPTION_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testConstructorWithOptions() {
        OPTION[] options = {OPTION.semiColonRequired};
        NumericEntityUnescaper unescaper = new NumericEntityUnescaper(options);
        assertNotNull("NumericEntityUnescaper instance should not be null", unescaper);
    }

    @Test(timeout = 4000)
    public void testConstructorWithNoOptions() {
        // This should trigger the else branch in the constructor
        OPTION[] options = {};
        NumericEntityUnescaper unescaper = new NumericEntityUnescaper(options);
        assertNotNull("NumericEntityUnescaper instance should not be null", unescaper);
    }

}