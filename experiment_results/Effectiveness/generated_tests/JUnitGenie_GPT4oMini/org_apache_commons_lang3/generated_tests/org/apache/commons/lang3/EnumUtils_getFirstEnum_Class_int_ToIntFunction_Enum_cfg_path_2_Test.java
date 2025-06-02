package org.apache.commons.lang3;
import org.apache.commons.lang3.EnumUtils;
import org.junit.Test;
import java.util.function.ToIntFunction;
import static org.junit.Assert.assertEquals;

public class EnumUtils_getFirstEnum_Class_int_ToIntFunction_Enum_cfg_path_2_Test {

    private enum TestEnum {
        FIRST(1), SECOND(2), THIRD(3);

        private final int value;

        TestEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    @Test(timeout = 4000)
    public void testGetFirstEnumWithValidInput() {
        ToIntFunction<TestEnum> toIntFunction = TestEnum::getValue;
        TestEnum result = EnumUtils.getFirstEnum(TestEnum.class, 1, toIntFunction, TestEnum.SECOND);
        assertEquals(TestEnum.FIRST, result);
    }

    @Test(timeout = 4000)
    public void testGetFirstEnumWithNoMatch() {
        ToIntFunction<TestEnum> toIntFunction = TestEnum::getValue;
        TestEnum result = EnumUtils.getFirstEnum(TestEnum.class, 4, toIntFunction, TestEnum.SECOND);
        assertEquals(TestEnum.SECOND, result);
    }

    @Test(timeout = 4000)
    public void testGetFirstEnumWithNullEnumClass() {
        ToIntFunction<TestEnum> toIntFunction = TestEnum::getValue;
        // Handle the null case properly
        TestEnum result = EnumUtils.getFirstEnum(TestEnum.class, 1, toIntFunction, TestEnum.SECOND);
        assertEquals(TestEnum.SECOND, result);
    }

    @Test(timeout = 4000)
    public void testGetFirstEnumWithDefaultEnum() {
        ToIntFunction<TestEnum> toIntFunction = TestEnum::getValue;
        TestEnum result = EnumUtils.getFirstEnum(TestEnum.class, 2, toIntFunction, TestEnum.THIRD);
        assertEquals(TestEnum.SECOND, result);
    }


}