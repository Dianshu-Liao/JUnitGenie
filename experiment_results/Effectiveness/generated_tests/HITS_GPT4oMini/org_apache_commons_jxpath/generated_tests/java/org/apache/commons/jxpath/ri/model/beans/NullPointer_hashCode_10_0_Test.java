package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.ri.QName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class NullPointer_hashCode_10_0_Test {

    @Test
    public void testHashCode_WithNullName() {
        // Create a mock NodePointer as the first parameter
        NodePointer nodePointerMock = mock(NodePointer.class);
        NullPointer nullPointer = new NullPointer(nodePointerMock, null);
        // Since name is null, hashCode should return 0
        assertEquals(0, nullPointer.hashCode());
    }

    @Test
    public void testHashCode_WithNonNullName() {
        QName qName = new QName("testName");
        // Create a mock NodePointer as the first parameter
        NodePointer nodePointerMock = mock(NodePointer.class);
        NullPointer nullPointer = new NullPointer(nodePointerMock, qName);
        // Since name is not null, hashCode should return the hashCode of QName
        assertEquals(qName.hashCode(), nullPointer.hashCode());
    }

    @Test
    public void testHashCode_WithDifferentNames() {
        QName qName1 = new QName("testName1");
        QName qName2 = new QName("testName2");
        // Create a mock NodePointer as the first parameter
        NodePointer nodePointerMock1 = mock(NodePointer.class);
        NodePointer nodePointerMock2 = mock(NodePointer.class);
        NullPointer nullPointer1 = new NullPointer(nodePointerMock1, qName1);
        NullPointer nullPointer2 = new NullPointer(nodePointerMock2, qName2);
        // Hash codes should be different for different QName instances
        assertEquals(qName1.hashCode(), nullPointer1.hashCode());
        assertEquals(qName2.hashCode(), nullPointer2.hashCode());
        assertNotEquals(nullPointer1.hashCode(), nullPointer2.hashCode());
    }
}
