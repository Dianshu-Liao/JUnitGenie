package com.fasterxml.jackson.databind.deser.std;
import com.fasterxml.jackson.databind.deser.std.MapDeserializer;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.util.Collections;
import java.util.Set;

public class deser_std_MapDeserializer_isCachable__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsCachable() {
        // Create a MapDeserializer instance with all fields set to null
        JsonDeserializer<Object> valueDeserializer = null;
        KeyDeserializer keyDeserializer = null;
        TypeDeserializer valueTypeDeserializer = null;
        Set<String> ignorableProperties = Collections.emptySet(); // Initialize to empty set
        Set<String> includableProperties = Collections.emptySet(); // Initialize to empty set

        MapDeserializer mapDeserializer = new MapDeserializer(
                null, // JavaType
                null, // ValueInstantiator
                keyDeserializer,
                valueDeserializer,
                valueTypeDeserializer
        );

        // Set the protected fields using reflection
        try {
            java.lang.reflect.Field ignorableField = MapDeserializer.class.getDeclaredField("_ignorableProperties");
            ignorableField.setAccessible(true);
            ignorableField.set(mapDeserializer, ignorableProperties);

            java.lang.reflect.Field includableField = MapDeserializer.class.getDeclaredField("_includableProperties");
            includableField.setAccessible(true);
            includableField.set(mapDeserializer, includableProperties);

            // Call the isCachable method and assert the result
            boolean result = mapDeserializer.isCachable();
            assertTrue(result); // Expecting true since all fields are effectively empty
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}