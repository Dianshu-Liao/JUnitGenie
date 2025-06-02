package org.apache.commons.jxpath.ri.model;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.NullPointer;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
import org.apache.commons.jxpath.JXPathException;
import org.junit.Test;
import java.util.Locale;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ri_model_NodePointer_newNodePointer_QName_Object_Locale_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testNewNodePointerWithNullBean() {
        QName name = new QName("testName");
        Object bean = null;
        Locale locale = Locale.ENGLISH;

        NodePointer pointer = NodePointer.newNodePointer(name, bean, locale);
        assertNotNull("Pointer should not be null when bean is null", pointer);
        // Additional assertions can be made to verify the type of pointer
        // For example, checking if it's an instance of NullPointer
        assertTrue("Pointer should be an instance of NullPointer", pointer instanceof NullPointer);
    }


}