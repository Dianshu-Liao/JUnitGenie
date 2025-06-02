package com.fasterxml.jackson.databind.deser.impl;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import static org.junit.Assert.assertSame;

public class deser_impl_BeanPropertyMap_withoutProperties_Collection_Collection_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testWithoutPropertiesWithNullToExcludeAndNullToInclude() {
        // Arrange
        Collection<String> toExclude = null;
        Collection<String> toInclude = null;
        BeanPropertyMap originalMap = new BeanPropertyMap(true, new ArrayList<>(), null, null);

        // Act
        BeanPropertyMap result = originalMap.withoutProperties(toExclude, toInclude);

        // Assert
        assertSame(originalMap, result);
    }

    @Test(timeout = 4000)
    public void testWithoutPropertiesWithEmptyToExcludeAndNullToInclude() {
        // Arrange
        Collection<String> toExclude = new ArrayList<>();
        Collection<String> toInclude = null;
        BeanPropertyMap originalMap = new BeanPropertyMap(true, new ArrayList<>(), null, null);

        // Act
        BeanPropertyMap result = originalMap.withoutProperties(toExclude, toInclude);

        // Assert
        assertSame(originalMap, result);
    }

}