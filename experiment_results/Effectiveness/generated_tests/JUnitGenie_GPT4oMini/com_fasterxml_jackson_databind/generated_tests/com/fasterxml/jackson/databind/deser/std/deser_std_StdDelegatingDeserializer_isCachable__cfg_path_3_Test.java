package com.fasterxml.jackson.databind.deser.std;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import com.fasterxml.jackson.databind.util.Converter;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class deser_std_StdDelegatingDeserializer_isCachable__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIsCachableWhenDelegateDeserializerIsNull() {
        // Arrange
        StdDelegatingDeserializer<Object> deserializer = new StdDelegatingDeserializer<Object>((Converter<?, Object>) null);

        // Act
        boolean result = deserializer.isCachable();

        // Assert
        assertFalse(result);
    }


}