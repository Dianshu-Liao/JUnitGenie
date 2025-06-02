package org.apache.commons.jxpath;

import java.beans.PropertyDescriptor;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class JXPathBasicBeanInfo_toString_5_0_Test {

    private JXPathBasicBeanInfo beanInfo;

    @BeforeEach
    public void setUp() {
        // Set up a test class for the bean info
        beanInfo = new JXPathBasicBeanInfo(TestClass.class);
    }

    @Test
    public void testToString() {
        String expectedOutput = "BeanInfo [class = " + TestClass.class.getName() + ", properties = \n    " + String.join("\n    ", getExpectedPropertyDescriptors()) + "]";
        String actualOutput = beanInfo.toString();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testToStringWithDynamic() {
        beanInfo = new JXPathBasicBeanInfo(TestClass.class, TestDynamicPropertyHandler.class);
        String expectedOutput = "BeanInfo [class = " + TestClass.class.getName() + ", dynamic, properties = \n    " + String.join("\n    ", getExpectedPropertyDescriptors()) + "]";
        String actualOutput = beanInfo.toString();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testToStringWithAtomic() {
        beanInfo = new JXPathBasicBeanInfo(TestClass.class, true);
        String expectedOutput = "BeanInfo [class = " + TestClass.class.getName() + ", atomic, properties = \n    " + String.join("\n    ", getExpectedPropertyDescriptors()) + "]";
        String actualOutput = beanInfo.toString();
        assertEquals(expectedOutput, actualOutput);
    }

    private String[] getExpectedPropertyDescriptors() {
        return new String[] { "java.lang.String: name", "int: age" };
    }

    // Test class for property descriptors
    public static class TestClass {

        private String name;

        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    // Dummy dynamic property handler class
    public static class TestDynamicPropertyHandler {
    }
}
