package org.apache.commons.jxpath.ri.model.dynabeans;

import java.util.Locale;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.beanutils.DynaBean;
// Removed the duplicate import statement
import org.apache.commons.jxpath.ri.QName;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;

public class DynaBeanPointer_hashCode_7_4_Test {

    private DynaBeanPointer dynaBeanPointerWithNullName;

    private DynaBeanPointer dynaBeanPointerWithNonNullName;

    @BeforeEach
    public void setUp() {
        QName nameNull = null;
        QName nameNonNull = new QName("namespaceURI", "localPart");
        // Use mock to instantiate DynaBean
        DynaBean dynaBean = mock(DynaBean.class);
        dynaBeanPointerWithNullName = new DynaBeanPointer(nameNull, dynaBean, Locale.getDefault());
        dynaBeanPointerWithNonNullName = new DynaBeanPointer(nameNonNull, dynaBean, Locale.getDefault());
    }

    @Test
    public void testHashCodeWithNullName() {
        int expectedHashCode = 0;
        assertEquals(expectedHashCode, dynaBeanPointerWithNullName.hashCode());
    }

    @Test
    public void testHashCodeWithNonNullName() {
        int expectedHashCode = new QName("namespaceURI", "localPart").hashCode();
        assertEquals(expectedHashCode, dynaBeanPointerWithNonNullName.hashCode());
    }
}
