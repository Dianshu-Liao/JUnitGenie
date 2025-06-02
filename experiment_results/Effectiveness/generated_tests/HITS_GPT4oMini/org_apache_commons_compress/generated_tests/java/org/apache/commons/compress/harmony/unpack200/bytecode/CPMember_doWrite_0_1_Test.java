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

@ExtendWith(MockitoExtension.class)
class CPMember_doWrite_0_1_Test {

    private CPMember member;

    private CPUTF8 name;

    private CPUTF8 descriptor;

    private List<Attribute> attributes;

    @BeforeEach
    void setUp() {
        name = new CPUTF8("testName");
        descriptor = new CPUTF8("testDescriptor");
        attributes = new ArrayList<>();
        // Create a mock for the actual Attribute class
        Attribute attributeMock = mock(Attribute.class);
        attributes.add(attributeMock);
        member = new CPMember(name, descriptor, 1, attributes);
    }

    @Test
    void testDoWrite() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(byteArrayOutputStream);
        member.doWrite(dos);
        byte[] result = byteArrayOutputStream.toByteArray();
        // Verify the output
        assertEquals(6, result.length);
        // Additional assertions can be made here based on the expected byte array content
        // Verify that doWrite was called on the mock
        verify(attributes.get(0)).doWrite(dos);
    }
}
