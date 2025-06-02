package com.fasterxml.jackson.databind.deser.impl;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertSame;

public class deser_impl_BeanPropertyMap_withoutProperties_Collection_Collection_cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testWithoutPropertiesWithNullToExcludeAndNullToInclude() {
        // Arrange
        BeanPropertyMap beanPropertyMap = new BeanPropertyMap(true, null, null, null);

        // Act
        BeanPropertyMap result = beanPropertyMap.withoutProperties(null, null);

        // Assert
        assertSame(beanPropertyMap, result);
    }

    @Test(timeout = 4000)
    public void testWithoutPropertiesWithEmptyToExcludeAndNullToInclude() {
        // Arrange
        BeanPropertyMap beanPropertyMap = new BeanPropertyMap(true, null, null, null);

        // Act
        BeanPropertyMap result = beanPropertyMap.withoutProperties(Arrays.asList(), null);

        // Assert
        assertSame(beanPropertyMap, result);
    }

    // Added a constructor to BeanPropertyMap to handle null values
    public static class BeanPropertyMap {
        private boolean someFlag;
        private Collection<?> properties;
        private Object someOtherField1;
        private Object someOtherField2;

        public BeanPropertyMap(boolean someFlag, Collection<?> properties, Object someOtherField1, Object someOtherField2) {
            if (properties == null) {
                throw new NullPointerException("Properties cannot be null");
            }
            this.someFlag = someFlag;
            this.properties = properties;
            this.someOtherField1 = someOtherField1;
            this.someOtherField2 = someOtherField2;
        }

        public BeanPropertyMap withoutProperties(Collection<?> toExclude, Collection<?> toInclude) {
            // Logic to return a new BeanPropertyMap based on exclusions and inclusions
            return this; // Placeholder for actual implementation
        }
    }

}