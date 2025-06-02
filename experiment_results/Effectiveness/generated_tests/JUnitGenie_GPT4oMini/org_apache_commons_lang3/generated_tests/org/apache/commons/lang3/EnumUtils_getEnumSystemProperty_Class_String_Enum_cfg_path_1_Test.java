package org.apache.commons.lang3;
import org.apache.commons.lang3.EnumUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EnumUtils_getEnumSystemProperty_Class_String_Enum_cfg_path_1_Test {

    private enum TestEnum {
        VALUE1, VALUE2, VALUE3
    }

    @Test(timeout = 4000)
    public void testGetEnumSystemPropertyWithNullEnumClass() {
        // Given
        Class<TestEnum> enumClass = null;
        String propName = "test.property";
        TestEnum defaultEnum = TestEnum.VALUE1;

        // When
        TestEnum result = EnumUtils.getEnumSystemProperty(enumClass, propName, defaultEnum);

        // Then
        assertEquals(defaultEnum, result);
    }

}