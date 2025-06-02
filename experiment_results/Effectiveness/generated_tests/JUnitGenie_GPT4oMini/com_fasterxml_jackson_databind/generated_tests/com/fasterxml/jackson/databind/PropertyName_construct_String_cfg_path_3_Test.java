package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.PropertyName;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PropertyName_construct_String_cfg_path_3_Test {

    private static final PropertyName USE_DEFAULT = new PropertyName("default");

    @Test(timeout = 4000)
    public void testConstructWithNull() {
        PropertyName result = PropertyName.construct(null);
        assertEquals(USE_DEFAULT, result);
    }

    @Test(timeout = 4000)
    public void testConstructWithEmptyString() {
        PropertyName result = PropertyName.construct("");
        assertEquals(USE_DEFAULT, result);
    }

    @Test(timeout = 4000)
    public void testConstructWithValidString() {
        String simpleName = "validName";
        PropertyName result = PropertyName.construct(simpleName);
        PropertyName expected = new PropertyName(simpleName, null); // Removed InternCache
        assertEquals(expected, result);
    }


}