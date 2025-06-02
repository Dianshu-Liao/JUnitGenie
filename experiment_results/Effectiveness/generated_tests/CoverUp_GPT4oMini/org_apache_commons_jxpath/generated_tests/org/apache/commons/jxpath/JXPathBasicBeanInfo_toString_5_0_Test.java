package org.apache.commons.jxpath;

import org.apache.commons.jxpath.JXPathBasicBeanInfo;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
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
        beanInfo = new JXPathBasicBeanInfo(TestBean.class);
    }

    @Test
    public void testToString() throws Exception {
        String expectedOutput = "BeanInfo [class = " + TestBean.class.getName() + ", properties = \n    java.lang.String: name\n    int: age\n]";
        String actualOutput = beanInfo.toString();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testToStringWithDynamic() throws Exception {
        beanInfo = new JXPathBasicBeanInfo(TestBean.class, true);
        String expectedOutput = "BeanInfo [class = " + TestBean.class.getName() + ", atomic, properties = \n    java.lang.String: name\n    int: age\n]";
        String actualOutput = beanInfo.toString();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testToStringWithNoProperties() throws Exception {
        beanInfo = new JXPathBasicBeanInfo(Object.class);
        String expectedOutput = "BeanInfo [class = java.lang.Object, properties = ]";
        String actualOutput = beanInfo.toString();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testToStringWithDynamicProperties() throws Exception {
        beanInfo = new JXPathBasicBeanInfo(TestDynamicBean.class);
        String expectedOutput = "BeanInfo [class = " + TestDynamicBean.class.getName() + ", dynamic, properties = \n    java.lang.String: dynamicProperty\n]";
        String actualOutput = beanInfo.toString();
        assertEquals(expectedOutput, actualOutput);
    }

    // Test bean classes
    public static class TestBean {

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

    public static class TestDynamicBean {

        private String dynamicProperty;

        public String getDynamicProperty() {
            return dynamicProperty;
        }

        public void setDynamicProperty(String dynamicProperty) {
            this.dynamicProperty = dynamicProperty;
        }
    }
}
