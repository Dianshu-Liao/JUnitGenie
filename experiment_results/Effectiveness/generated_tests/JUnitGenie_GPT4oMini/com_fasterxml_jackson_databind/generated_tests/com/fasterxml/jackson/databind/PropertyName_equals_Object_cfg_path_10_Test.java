package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.PropertyName;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PropertyName_equals_Object_cfg_path_10_Test {

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
        String differentClassObject = "Not a PropertyName";
        assertFalse(propertyName.equals(differentClassObject));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentSimpleName() {
        PropertyName propertyName1 = new PropertyName("name1");
        PropertyName propertyName2 = new PropertyName("name2");
        assertFalse(propertyName1.equals(propertyName2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameSimpleNameDifferentNamespace() {
        PropertyName propertyName1 = new PropertyName("name");
        PropertyName propertyName2 = new PropertyName("name", "namespace2");
        assertFalse(propertyName1.equals(propertyName2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameSimpleNameSameNamespace() {
        PropertyName propertyName1 = new PropertyName("name", "namespace1");
        PropertyName propertyName2 = new PropertyName("name", "namespace1");
        assertTrue(propertyName1.equals(propertyName2));
    }

}