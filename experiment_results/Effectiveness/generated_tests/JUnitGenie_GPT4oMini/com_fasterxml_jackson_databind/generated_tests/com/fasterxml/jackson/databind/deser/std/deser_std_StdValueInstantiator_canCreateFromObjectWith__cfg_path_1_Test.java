package com.fasterxml.jackson.databind.deser.std;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.StdValueInstantiator;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class deser_std_StdValueInstantiator_canCreateFromObjectWith__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCanCreateFromObjectWith_WhenWithArgsCreatorIsNull() {
        // Arrange
        StdValueInstantiator instantiator = new StdValueInstantiator(null, (Class<?>) null);
        
        // Act
        boolean result = instantiator.canCreateFromObjectWith();
        
        // Assert
        assertFalse(result);
    }

}