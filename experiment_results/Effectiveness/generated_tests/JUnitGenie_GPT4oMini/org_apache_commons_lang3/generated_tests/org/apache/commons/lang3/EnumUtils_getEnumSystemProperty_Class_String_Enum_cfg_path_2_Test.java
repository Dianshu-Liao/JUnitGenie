package org.apache.commons.lang3;
import org.apache.commons.lang3.EnumUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EnumUtils_getEnumSystemProperty_Class_String_Enum_cfg_path_2_Test {

    private enum TestEnum {
        VALUE1, VALUE2, DEFAULT
    }

    @Test(timeout = 4000)
    public void testGetEnumSystemPropertyWithValidInput() {
        // Set a system property for testing
        System.setProperty("test.enum.property", "VALUE1");
        
        try {
            TestEnum result = EnumUtils.getEnumSystemProperty(TestEnum.class, "test.enum.property", TestEnum.DEFAULT);
            assertEquals(TestEnum.VALUE1, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetEnumSystemPropertyWithNullEnumClass() {
        try {
            TestEnum result = EnumUtils.getEnumSystemProperty(null, "test.enum.property", TestEnum.DEFAULT);
            assertEquals(TestEnum.DEFAULT, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetEnumSystemPropertyWithNullPropertyName() {
        try {
            TestEnum result = EnumUtils.getEnumSystemProperty(TestEnum.class, null, TestEnum.DEFAULT);
            assertEquals(TestEnum.DEFAULT, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetEnumSystemPropertyWithNonExistentProperty() {
        try {
            TestEnum result = EnumUtils.getEnumSystemProperty(TestEnum.class, "non.existent.property", TestEnum.DEFAULT);
            assertEquals(TestEnum.DEFAULT, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}