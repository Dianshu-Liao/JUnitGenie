package org.apache.commons.jxpath;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.HashMap;
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

public class JXPathBasicBeanInfo_toString_5_0_Test {

    private JXPathBasicBeanInfo beanInfo;

    @BeforeEach
    public void setUp() {
        // Create a mock class for testing
        Class<TestBean> testClass = TestBean.class;
        beanInfo = new JXPathBasicBeanInfo(testClass);
    }

    @Test
    public void testToString() throws Exception {
        // Set up the property descriptors for the test
        PropertyDescriptor[] propertyDescriptors = new PropertyDescriptor[] { new PropertyDescriptor("property1", TestBean.class), new PropertyDescriptor("property2", TestBean.class) };
        // Use reflection to set the private field 'propertyDescriptors'
        setPrivateField(beanInfo, "propertyDescriptors", propertyDescriptors);
        setPrivateField(beanInfo, "clazz", TestBean.class);
        // Call the toString method
        String result = beanInfo.toString();
        // Assert the expected output
        String expectedOutput = "BeanInfo [class = " + TestBean.class.getName() + ", properties = \n    " + propertyDescriptors[0].getPropertyType() + ": " + propertyDescriptors[0].getName() + "\n    " + propertyDescriptors[1].getPropertyType() + ": " + propertyDescriptors[1].getName() + "]";
        assertEquals(expectedOutput, result);
    }

    @Test
    public void testToStringWithAtomic() throws Exception {
        // Set atomic to true using reflection
        setPrivateField(beanInfo, "atomic", true);
        // Call the toString method
        String result = beanInfo.toString();
        // Assert that atomic is included in the output
        assertTrue(result.contains(", atomic"));
    }

    @Test
    public void testToStringWithDynamic() throws Exception {
        // Set dynamic property handler class using reflection
        setPrivateField(beanInfo, "dynamicPropertyHandlerClass", Object.class);
        // Call the toString method
        String result = beanInfo.toString();
        // Assert that dynamic is included in the output
        assertTrue(result.contains(", dynamic"));
    }

    @Test
    public void testToStringWithNoProperties() throws Exception {
        // Set clazz to Object.class
        setPrivateField(beanInfo, "clazz", Object.class);
        // Call the toString method
        String result = beanInfo.toString();
        // Assert the expected output for no properties
        String expectedOutput = "BeanInfo [class = " + Object.class.getName() + ", properties = ]";
        assertEquals(expectedOutput, result);
    }

    private void setPrivateField(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    // Sample TestBean class for testing purposes
    public static class TestBean {

        private String property1;

        private String property2;

        public String getProperty1() {
            return property1;
        }

        public void setProperty1(String property1) {
            this.property1 = property1;
        }

        public String getProperty2() {
            return property2;
        }

        public void setProperty2(String property2) {
            this.property2 = property2;
        }
    }
}
