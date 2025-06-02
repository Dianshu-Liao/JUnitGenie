package org.apache.commons.compress.archivers.zip;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;

public class UnrecognizedExtraField_getCentralDirectoryData_0_0_Test {

    private UnrecognizedExtraField unrecognizedExtraField;

    @BeforeEach
    public void setUp() {
        unrecognizedExtraField = new UnrecognizedExtraField();
    }

    @Test
    public void testGetCentralDirectoryData_WithCentralData() throws Exception {
        // Arrange
        byte[] expectedData = { 1, 2, 3 };
        setPrivateField(unrecognizedExtraField, "centralData", expectedData);
        // Act
        byte[] result = unrecognizedExtraField.getCentralDirectoryData();
        // Assert
        assertArrayEquals(expectedData, result);
    }

    @Test
    public void testGetCentralDirectoryData_WithoutCentralData() throws Exception {
        // Arrange
        byte[] expectedData = { 4, 5, 6 };
        setPrivateField(unrecognizedExtraField, "centralData", null);
        // Mock the behavior of getLocalFileDataData() using reflection
        UnrecognizedExtraField spy = spy(unrecognizedExtraField);
        doReturn(expectedData).when(spy).getLocalFileDataData();
        // Act
        byte[] result = spy.getCentralDirectoryData();
        // Assert
        assertArrayEquals(expectedData, result);
    }

    private void setPrivateField(Object target, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}
