package com.fasterxml.jackson.databind.ext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ext.Java7HandlersImpl;
import com.fasterxml.jackson.databind.ext.NioPathSerializer;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class ext_Java7HandlersImpl_getSerializerForJavaNioFilePath_Class_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetSerializerForJavaNioFilePath() {
        // Arrange
        Java7HandlersImpl handlers = new Java7HandlersImpl();
        Class<?> rawType = java.nio.file.Path.class; // Assuming Path is assignable from _pathClass

        // Act
        JsonSerializer<?> serializer = handlers.getSerializerForJavaNioFilePath(rawType);

        // Assert
        assertNotNull("Serializer should not be null for assignable rawType", serializer);
    }

}