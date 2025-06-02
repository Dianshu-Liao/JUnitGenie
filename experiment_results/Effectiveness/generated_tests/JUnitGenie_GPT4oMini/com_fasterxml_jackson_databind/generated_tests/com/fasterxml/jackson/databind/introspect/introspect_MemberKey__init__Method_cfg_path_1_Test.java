package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.MemberKey;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class introspect_MemberKey__init__Method_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testConstructorWithMethodHavingNoParameters() {
        try {
            // Arrange
            Method method = TestClass.class.getMethod("methodWithNoParameters");
            // Act
            MemberKey memberKey = new MemberKey(method);
            // Assert
            assertNotNull(memberKey);
        } catch (NoSuchMethodException e) {
            fail("Method not found: " + e.getMessage());
        }
    }

    // Sample class with a method to be used for testing
    public static class TestClass {
        public void methodWithNoParameters() {
            // This method has no parameters
        }
    }

}