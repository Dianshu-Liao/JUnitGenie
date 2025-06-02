package com.fasterxml.jackson.databind;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import com.fasterxml.jackson.databind.PropertyName;

public class PropertyName_equals_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        PropertyName propertyName = new PropertyName("namespace", "simpleName");
        assertTrue(propertyName.equals(propertyName));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        PropertyName propertyName = new PropertyName("namespace", "simpleName");
        assertFalse(propertyName.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        PropertyName propertyName = new PropertyName("namespace", "simpleName");
        assertFalse(propertyName.equals("Not A PropertyName"));
    }

    @Test(timeout = 4000)
    public void testEquals_NonMatchingSimpleName() {
        PropertyName propertyName1 = new PropertyName("namespace", "simpleName1");
        PropertyName propertyName2 = new PropertyName("namespace", "simpleName2");
        assertFalse(propertyName1.equals(propertyName2));
    }

    @Test(timeout = 4000)
    public void testEquals_NullSimpleName() {
        PropertyName propertyName1 = new PropertyName("namespace", null);
        PropertyName propertyName2 = new PropertyName("namespace", "simpleName");
        assertFalse(propertyName1.equals(propertyName2));
    }

    @Test(timeout = 4000)
    public void testEquals_NullNamespace() {
        PropertyName propertyName1 = new PropertyName(null, "simpleName");
        PropertyName propertyName2 = new PropertyName(null, "simpleName");
        assertTrue(propertyName1.equals(propertyName2));
    }

    @Test(timeout = 4000)
    public void testEquals_MatchingNamespaces() {
        PropertyName propertyName1 = new PropertyName("namespace", "simpleName");
        PropertyName propertyName2 = new PropertyName("namespace", "simpleName");
        assertTrue(propertyName1.equals(propertyName2));
    }

}