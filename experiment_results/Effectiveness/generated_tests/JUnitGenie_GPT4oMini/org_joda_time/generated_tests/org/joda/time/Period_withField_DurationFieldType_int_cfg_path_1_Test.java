package org.joda.time;
import org.joda.time.Period;
import org.joda.time.DurationFieldType;
import org.junit.Test;
import static org.junit.Assert.*;

public class Period_withField_DurationFieldType_int_cfg_path_1_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testWithField_NullField() {
        Period period = new Period();
        // Attempting to call withField with a null DurationFieldType should throw IllegalArgumentException
        period.withField(null, 5);
    }

}