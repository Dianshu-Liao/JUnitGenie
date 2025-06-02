package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;
import java.util.Objects;

class CPMember_doWrite_0_0_Test {

    private CPMember cpMember;

    private CPUTF8 name;

    private CPUTF8 descriptor;

    private List<Attribute> attributes;

    private Attribute mockAttribute;

    @BeforeEach
    void setUp() {
        name = mock(CPUTF8.class);
        descriptor = mock(CPUTF8.class);
        attributes = new ArrayList<>();
        mockAttribute = mock(Attribute.class);
        attributes.add(mockAttribute);
        cpMember = new CPMember(name, descriptor, 0xFFFF, attributes);
    }

    @Test
    void testDoWrite() throws IOException {
        // Arrange
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        // Mocking behavior for attributes
        doNothing().when(mockAttribute).doWrite(dataOutputStream);
        // Set the nameIndex and descriptorIndex for testing
        setPrivateField(cpMember, "nameIndex", 1);
        setPrivateField(cpMember, "descriptorIndex", 2);
        // Act
        cpMember.doWrite(dataOutputStream);
        // Assert
        byte[] result = byteArrayOutputStream.toByteArray();
        // Verify the output stream content based on expected values
        // The expected byte array would need to be constructed based on the flags, nameIndex, descriptorIndex, and attributes
        // For simplicity, we're just checking the length here
        // flags, nameIndex, descriptorIndex, attributeCount, and one attribute
        assertEquals(2 + 2 + 2 + 2 + 1, result.length);
        verify(mockAttribute, times(1)).doWrite(dataOutputStream);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) {
        try {
            // Fixed the buggy line by using 'Field' instead of 'var'
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
