package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.PropertyName;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PropertyName_equals_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEqualsSameInstance() {
        PropertyName propertyName = new PropertyName("simpleName", "namespace");
        assertTrue(propertyName.equals(propertyName));
    }

    @Test(timeout = 4000)
    public void testEqualsNull() {
        PropertyName propertyName = new PropertyName("simpleName", "namespace");
        assertFalse(propertyName.equals(null));
    }

    @Test(timeout = 4000)
    public void testNotEqualsDifferentClass() {
        PropertyName propertyName = new PropertyName("simpleName", "namespace");
        assertFalse(propertyName.equals(new Object()));
    }

    @Test(timeout = 4000)
    public void testEqualsDifferentSimpleName() {
        PropertyName propertyName1 = new PropertyName("simpleName1", "namespace");
        PropertyName propertyName2 = new PropertyName("simpleName2", "namespace");
        assertFalse(propertyName1.equals(propertyName2));
    }

    @Test(timeout = 4000)
    public void testEqualsDifferentNamespace() {
        PropertyName propertyName1 = new PropertyName("simpleName", "namespace1");
        PropertyName propertyName2 = new PropertyName("simpleName", "namespace2");
        assertFalse(propertyName1.equals(propertyName2));
    }

    @Test(timeout = 4000)
    public void testEqualsBothSimpleNameNull() {
        PropertyName propertyName1 = new PropertyName(null, "namespace");
        PropertyName propertyName2 = new PropertyName(null, "namespace");
        assertTrue(propertyName1.equals(propertyName2));
    }

    @Test(timeout = 4000)
    public void testEqualsBothNamespaceNull() {
        PropertyName propertyName1 = new PropertyName("simpleName", null);
        PropertyName propertyName2 = new PropertyName("simpleName", null);
        assertTrue(propertyName1.equals(propertyName2));
    }

    @Test(timeout = 4000)
    public void testEqualsOneSimpleNameNull() {
        PropertyName propertyName1 = new PropertyName(null, "namespace");
        PropertyName propertyName2 = new PropertyName("simpleName", "namespace");
        assertFalse(propertyName1.equals(propertyName2));
    }

    @Test(timeout = 4000)
    public void testEqualsOneNamespaceNull() {
        PropertyName propertyName1 = new PropertyName("simpleName", null);
        PropertyName propertyName2 = new PropertyName("simpleName", "namespace");
        assertFalse(propertyName1.equals(propertyName2));
    }

}