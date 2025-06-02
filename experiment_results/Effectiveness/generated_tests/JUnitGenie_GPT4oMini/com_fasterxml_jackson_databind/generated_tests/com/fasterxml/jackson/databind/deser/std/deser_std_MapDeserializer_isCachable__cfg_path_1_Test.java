package com.fasterxml.jackson.databind.deser.std;
import com.fasterxml.jackson.databind.deser.std.MapDeserializer;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import org.junit.Test;
import java.util.Collections;
import static org.junit.Assert.assertTrue;

public class deser_std_MapDeserializer_isCachable__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsCachable() {
        // Create an instance of MapDeserializer with all fields set to null
        MapDeserializer mapDeserializer = new MapDeserializer(
                null, // JavaType
                null, // ValueInstantiator
                null, // KeyDeserializer
                null, // JsonDeserializer
                null  // TypeDeserializer
        );

        // Set the protected fields to null using reflection
        try {
            java.lang.reflect.Field valueDeserializerField = MapDeserializer.class.getDeclaredField("_valueDeserializer");
            valueDeserializerField.setAccessible(true);
            valueDeserializerField.set(mapDeserializer, JsonDeserializer.None.class);

            java.lang.reflect.Field keyDeserializerField = MapDeserializer.class.getDeclaredField("_keyDeserializer");
            keyDeserializerField.setAccessible(true);
            keyDeserializerField.set(mapDeserializer, KeyDeserializer.None.class);

            java.lang.reflect.Field valueTypeDeserializerField = MapDeserializer.class.getDeclaredField("_valueTypeDeserializer");
            valueTypeDeserializerField.setAccessible(true);
            valueTypeDeserializerField.set(mapDeserializer, null); // Set to null instead of TypeDeserializer.None.class

            java.lang.reflect.Field ignorablePropertiesField = MapDeserializer.class.getDeclaredField("_ignorableProperties");
            ignorablePropertiesField.setAccessible(true);
            ignorablePropertiesField.set(mapDeserializer, Collections.emptySet());

            java.lang.reflect.Field includablePropertiesField = MapDeserializer.class.getDeclaredField("_includableProperties");
            includablePropertiesField.setAccessible(true);
            includablePropertiesField.set(mapDeserializer, Collections.emptySet());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Call the isCachable method and assert the result
        boolean result = mapDeserializer.isCachable();
        assertTrue(result);
    }

}