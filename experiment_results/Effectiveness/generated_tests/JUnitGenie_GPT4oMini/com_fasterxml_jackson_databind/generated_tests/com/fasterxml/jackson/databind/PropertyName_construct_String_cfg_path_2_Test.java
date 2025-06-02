package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.PropertyName;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PropertyName_construct_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testConstructWithNull() {
        PropertyName result = PropertyName.construct(null);
        assertEquals(PropertyName.USE_DEFAULT, result);
    }

    @Test(timeout = 4000)
    public void testConstructWithEmptyString() {
        PropertyName result = PropertyName.construct("");
        assertEquals(PropertyName.USE_DEFAULT, result);
    }

}