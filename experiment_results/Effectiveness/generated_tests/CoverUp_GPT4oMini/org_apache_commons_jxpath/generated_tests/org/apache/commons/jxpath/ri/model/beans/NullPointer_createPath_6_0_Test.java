package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.lang.reflect.Method;
import java.util.Locale;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class NullPointer_createPath_6_0_Test {

    private NullPointer nullPointerWithParent;

    private NullPointer nullPointerWithoutParent;

    private JXPathContext context;

    private Object value;

    @BeforeEach
    public void setUp() {
        QName qName = new QName("testQName");
        context = JXPathContext.newContext(new Object());
        value = new Object();
        // Create a NullPointer with a parent
        nullPointerWithParent = new NullPointer(new QName("parentQName"), Locale.ENGLISH);
        // Create a NullPointer without a parent
        nullPointerWithoutParent = new NullPointer(qName, Locale.ENGLISH);
    }

    @Test
    public void testCreatePathWithParent() throws Exception {
        // Set up a mock parent
        NullPointer parentPointer = new NullPointer(new QName("parentQName"), Locale.ENGLISH);
        Method setParentMethod = NullPointer.class.getDeclaredMethod("setParent", NodePointer.class);
        setParentMethod.setAccessible(true);
        setParentMethod.invoke(nullPointerWithParent, parentPointer);
        NodePointer result = nullPointerWithParent.createPath(context, value);
        assertNotNull(result);
    }

    @Test
    public void testCreatePathWithoutParent() {
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> {
            nullPointerWithoutParent.createPath(context, value);
        });
        assertNotNull(exception);
        assertNotNull(exception.getMessage());
    }
}
