package org.apache.commons.jxpath.ri.model.dynabeans;
import org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.beanutils.DynaBean;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_model_dynabeans_DynaBeanPointer_hashCode__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHashCodeWithNonNullName() {
        QName qName = new QName("testName");
        DynaBean dynaBean = null; // Assuming DynaBean can be null for this test
        DynaBeanPointer dynaBeanPointer = new DynaBeanPointer(qName, dynaBean, null);
        
        int expectedHashCode = qName.hashCode();
        int actualHashCode = dynaBeanPointer.hashCode();
        
        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test(timeout = 4000)
    public void testHashCodeWithNullName() {
        DynaBean dynaBean = null; // Assuming DynaBean can be null for this test
        DynaBeanPointer dynaBeanPointer = new DynaBeanPointer(null, dynaBean, null);
        
        int actualHashCode = dynaBeanPointer.hashCode();
        
        assertEquals(0, actualHashCode);
    }

}