package org.apache.commons.lang3;
import org.apache.commons.lang3.EnumUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EnumUtils_getEnumSystemProperty_Class_String_Enum_cfg_path_3_Test {

    private enum TestEnum {
        VALUE1, VALUE2, VALUE3
    }

    @Test(timeout = 4000)
    public void testGetEnumSystemPropertyWithNullEnumClass() {
        String propName = "test.property";
        TestEnum defaultEnum = TestEnum.VALUE1;

        // Simulating the scenario where enumClass is null
        TestEnum result = EnumUtils.getEnumSystemProperty(null, propName, defaultEnum);
        assertEquals(defaultEnum, result);
    }

    @Test(timeout = 4000)
    public void testGetEnumSystemPropertyWithNullPropName() {
        Class<TestEnum> enumClass = TestEnum.class;
        TestEnum defaultEnum = TestEnum.VALUE1;

        // Simulating the scenario where propName is null
        TestEnum result = EnumUtils.getEnumSystemProperty(enumClass, null, defaultEnum);
        assertEquals(defaultEnum, result);
    }

    @Test(timeout = 4000)
    public void testGetEnumSystemPropertyWithValidInputs() {
        Class<TestEnum> enumClass = TestEnum.class;
        String propName = "test.property";
        TestEnum defaultEnum = TestEnum.VALUE1;

        // Simulating the scenario where the property is set to "VALUE2"
        System.setProperty(propName, "VALUE2");
        TestEnum result = EnumUtils.getEnumSystemProperty(enumClass, propName, defaultEnum);
        assertEquals(TestEnum.VALUE2, result);

        // Clean up the property after the test
        System.clearProperty(propName);
    }

    @Test(timeout = 4000)
    public void testGetEnumSystemPropertyWithInvalidEnumValue() {
        Class<TestEnum> enumClass = TestEnum.class;
        String propName = "test.property";
        TestEnum defaultEnum = TestEnum.VALUE1;

        // Simulating the scenario where the property is set to an invalid value
        System.setProperty(propName, "INVALID_VALUE");
        TestEnum result = EnumUtils.getEnumSystemProperty(enumClass, propName, defaultEnum);
        assertEquals(defaultEnum, result);

        // Clean up the property after the test
        System.clearProperty(propName);
    }

}