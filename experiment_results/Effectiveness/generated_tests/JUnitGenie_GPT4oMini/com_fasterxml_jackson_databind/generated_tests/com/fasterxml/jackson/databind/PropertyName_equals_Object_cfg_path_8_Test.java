package com.fasterxml.jackson.databind;
import org.junit.Test;
import static org.junit.Assert.*;
import com.fasterxml.jackson.databind.PropertyName;

public class PropertyName_equals_Object_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        PropertyName propertyName = new PropertyName("name");
        assertTrue(propertyName.equals(propertyName));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        PropertyName propertyName = new PropertyName("name");
        assertFalse(propertyName.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        PropertyName propertyName = new PropertyName("name");
        Object other = new Object();
        assertFalse(propertyName.equals(other));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentSimpleName() {
        PropertyName propertyName1 = new PropertyName("name1");
        PropertyName propertyName2 = new PropertyName("name2");
        assertFalse(propertyName1.equals(propertyName2));
    }
    
    @Test(timeout = 4000)
    public void testEquals_NullSimpleName() {
        PropertyName propertyName1 = new PropertyName(null);
        PropertyName propertyName2 = new PropertyName("name");
        assertFalse(propertyName1.equals(propertyName2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameSimpleName() {
        PropertyName propertyName1 = new PropertyName("name");
        PropertyName propertyName2 = new PropertyName("name");
        assertTrue(propertyName1.equals(propertyName2));
    }

    @Test(timeout = 4000)
    public void testEquals_NullNamespace() {
        PropertyName propertyName1 = new PropertyName("name", null);
        PropertyName propertyName2 = new PropertyName("name", null);
        assertTrue(propertyName1.equals(propertyName2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentNamespace() {
        PropertyName propertyName1 = new PropertyName("name", "namespace1");
        PropertyName propertyName2 = new PropertyName("name", "namespace2");
        assertFalse(propertyName1.equals(propertyName2));
    }

}