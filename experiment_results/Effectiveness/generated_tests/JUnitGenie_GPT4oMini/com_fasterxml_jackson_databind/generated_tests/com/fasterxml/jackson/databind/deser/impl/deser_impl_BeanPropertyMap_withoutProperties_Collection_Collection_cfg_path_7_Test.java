package com.fasterxml.jackson.databind.deser.impl;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.PropertyName;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertNotNull;

public class deser_impl_BeanPropertyMap_withoutProperties_Collection_Collection_cfg_path_7_Test {

    private final boolean caseInsensitive = false;
    private final Collection<SettableBeanProperty> properties = new ArrayList<>();
    private final Map<String, List<PropertyName>> aliasDefs = new HashMap<>();
    private final Locale locale = Locale.getDefault();
    private final BeanPropertyMap beanPropertyMap = new BeanPropertyMap(caseInsensitive, properties, aliasDefs, locale);

    @Test(timeout = 4000)
    public void testWithoutProperties_withNonEmptyToExclude() {
        Collection<String> toExclude = new ArrayList<>();
        toExclude.add("property1");
        toExclude.add("property2");
        Collection<String> toInclude = null;

        BeanPropertyMap result = null;
        try {
            result = beanPropertyMap.withoutProperties(toExclude, toInclude);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertNotNull("Result should not be null", result);
    }

    @Test(timeout = 4000)
    public void testWithoutProperties_withOnlyNullToInclude() {
        Collection<String> toExclude = null;
        Collection<String> toInclude = null;

        BeanPropertyMap result = null;
        try {
            result = beanPropertyMap.withoutProperties(toExclude, toInclude);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertNotNull("Result should not be null when both parameters are null", result);
    }

    @Test(timeout = 4000)
    public void testWithoutProperties_withEmptyToExclude() {
        Collection<String> toExclude = new ArrayList<>();
        Collection<String> toInclude = null;

        BeanPropertyMap result = null;
        try {
            result = beanPropertyMap.withoutProperties(toExclude, toInclude);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertNotNull("Result should not be null when toExclude is empty", result);
    }

}