package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.ri.QName;
import java.lang.reflect.Constructor;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class NullPointer_hashCode_10_0_Test {

    @Test
    public void testHashCodeWithNullName() throws Exception {
        NullPointer nullPointer = createNullPointerWithLocale(null, null);
        assertEquals(0, nullPointer.hashCode());
    }

    @Test
    public void testHashCodeWithNonNullName() throws Exception {
        QName qName = new QName("prefix", "localName");
        NullPointer nullPointer = createNullPointerWithLocale(qName, null);
        assertEquals(qName.hashCode(), nullPointer.hashCode());
    }

    @Test
    public void testHashCodeWithDifferentQName() throws Exception {
        QName qName1 = new QName("prefix1", "localName1");
        NullPointer nullPointer1 = createNullPointerWithLocale(qName1, null);
        QName qName2 = new QName("prefix2", "localName2");
        NullPointer nullPointer2 = createNullPointerWithLocale(qName2, null);
        assertEquals(qName1.hashCode(), nullPointer1.hashCode());
        assertEquals(qName2.hashCode(), nullPointer2.hashCode());
        assertNotEquals(nullPointer1.hashCode(), nullPointer2.hashCode());
    }

    private NullPointer createNullPointerWithLocale(QName name, Locale locale) throws Exception {
        Constructor<NullPointer> constructor = NullPointer.class.getDeclaredConstructor(QName.class, Locale.class);
        constructor.setAccessible(true);
        return constructor.newInstance(name, locale);
    }

    private NullPointer createNullPointerWithNodePointer(QName name, NodePointer parent) throws Exception {
        Constructor<NullPointer> constructor = NullPointer.class.getDeclaredConstructor(NodePointer.class, QName.class);
        constructor.setAccessible(true);
        return constructor.newInstance(parent, name);
    }
}
