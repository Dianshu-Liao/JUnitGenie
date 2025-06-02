package org.apache.commons.jxpath.ri.model.dynabeans;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.util.Locale;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;

public class DynaBeanPointerFactory_createNodePointer_1_0_Test {

    @Test
    public void testCreateNodePointerWithDynaBean() {
        // Arrange
        DynaBean dynaBean = mock(DynaBean.class);
        QName qName = new QName("testName");
        Locale locale = Locale.ENGLISH;
        DynaBeanPointerFactory factory = new DynaBeanPointerFactory();
        // Act
        NodePointer result = factory.createNodePointer(qName, dynaBean, locale);
        // Assert
        assertNotNull(result, "Expected a non-null NodePointer for DynaBean.");
    }

    @Test
    public void testCreateNodePointerWithNonDynaBean() {
        // Arrange
        Object nonDynaBean = new Object();
        QName qName = new QName("testName");
        Locale locale = Locale.ENGLISH;
        DynaBeanPointerFactory factory = new DynaBeanPointerFactory();
        // Act
        NodePointer result = factory.createNodePointer(qName, nonDynaBean, locale);
        // Assert
        assertNull(result, "Expected a null NodePointer for non-DynaBean.");
    }

    @Test
    public void testCreateNodePointerWithNullBean() {
        // Arrange
        QName qName = new QName("testName");
        Locale locale = Locale.ENGLISH;
        DynaBeanPointerFactory factory = new DynaBeanPointerFactory();
        // Act
        NodePointer result = factory.createNodePointer(qName, null, locale);
        // Assert
        assertNull(result, "Expected a null NodePointer for null bean.");
    }
}
