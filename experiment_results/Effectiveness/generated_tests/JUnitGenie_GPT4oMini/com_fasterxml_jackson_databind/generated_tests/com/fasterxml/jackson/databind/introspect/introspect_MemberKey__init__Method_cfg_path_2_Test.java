package com.fasterxml.jackson.databind.introspect;
import org.junit.Test;
import java.lang.reflect.Method;
import com.fasterxml.jackson.databind.introspect.MemberKey;
import static org.junit.Assert.*;

public class introspect_MemberKey__init__Method_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testMemberKeyWithMethodHavingParameters() {
        try {
            // Arrange
            Method method = SampleClass.class.getMethod("sampleMethod", String.class, Integer.class);
            MemberKey memberKey = new MemberKey(method);

            // Act
            String expectedName = "sampleMethod";
            Class<?>[] expectedParameterTypes = {String.class, Integer.class};

            // Assert
            assertEquals(expectedName, method.getName());
            assertArrayEquals(expectedParameterTypes, method.getParameterTypes());

        } catch (Exception e) {
            fail("Exception should not have occurred: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testMemberKeyWithMethodWithoutParameters() {
        try {
            // Arrange
            Method method = SampleClass.class.getMethod("sampleMethodNoParams");
            MemberKey memberKey = new MemberKey(method);

            // Act
            String expectedName = "sampleMethodNoParams";
            Class<?>[] expectedParameterTypes = {}; // NO_CLASSES

            // Assert
            assertEquals(expectedName, method.getName());
            assertArrayEquals(expectedParameterTypes, method.getParameterTypes());

        } catch (Exception e) {
            fail("Exception should not have occurred: " + e.getMessage());
        }
    }

    public static class SampleClass {
        public void sampleMethod(String str, Integer num) { }
        public void sampleMethodNoParams() { }
    }

}