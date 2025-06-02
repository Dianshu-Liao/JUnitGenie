package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class introspect_POJOPropertyBuilder_getPrimaryMember__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetPrimaryMember_whenForSerializationIsFalse() {
        // Arrange
        POJOPropertyBuilder builder = new POJOPropertyBuilder(null, null, false, null);
        
        // Act
        AnnotatedMember result = builder.getPrimaryMember();
        
        // Assert
        assertNotNull(result);
    }

}