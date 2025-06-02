package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.PropertyMetadata;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class PropertyMetadata_hasDefaultValue__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHasDefaultValueWhenDefaultValueIsNull() {
        // Create an instance of PropertyMetadata using reflection
        PropertyMetadata propertyMetadata = null;
        try {
            java.lang.reflect.Constructor<PropertyMetadata> constructor = 
                PropertyMetadata.class.getDeclaredConstructor(Boolean.class, String.class, Integer.class, String.class, 
                PropertyMetadata.MergeInfo.class, com.fasterxml.jackson.annotation.Nulls.class, com.fasterxml.jackson.annotation.Nulls.class);
            constructor.setAccessible(true);
            propertyMetadata = constructor.newInstance(null, null, null, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Test the hasDefaultValue method
        if (propertyMetadata != null) {
            boolean result = propertyMetadata.hasDefaultValue();
            assertFalse(result); // Expecting false since _defaultValue is null
        }
    }

}