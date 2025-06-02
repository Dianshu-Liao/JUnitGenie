package com.fasterxml.jackson.databind.deser.impl;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.PropertyName;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import static org.junit.Assert.assertNotNull;

public class deser_impl_BeanPropertyMap_withoutProperties_Collection_Collection_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWithoutProperties() {
        // Setup
        boolean caseInsensitive = false;
        Collection<SettableBeanProperty> propsInOrder = new ArrayList<>();
        Map<String, List<PropertyName>> aliasDefs = new HashMap<>();
        Locale locale = Locale.getDefault();
        
        BeanPropertyMap beanPropertyMap = new BeanPropertyMap(caseInsensitive, propsInOrder, aliasDefs, locale);
        
        Collection<String> toExclude = new ArrayList<>();
        Collection<String> toInclude = null;

        // Execute
        BeanPropertyMap result = null;
        try {
            result = beanPropertyMap.withoutProperties(toExclude, toInclude);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Verify
        assertNotNull(result);
    }


}