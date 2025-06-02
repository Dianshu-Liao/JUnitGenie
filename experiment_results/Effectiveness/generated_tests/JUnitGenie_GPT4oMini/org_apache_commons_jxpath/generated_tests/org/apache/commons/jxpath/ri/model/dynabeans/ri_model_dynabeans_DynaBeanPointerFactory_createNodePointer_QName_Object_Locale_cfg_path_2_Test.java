package org.apache.commons.jxpath.ri.model.dynabeans;
import org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointerFactory;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.util.Locale;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class ri_model_dynabeans_DynaBeanPointerFactory_createNodePointer_QName_Object_Locale_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCreateNodePointerWithNonDynaBean() {
        DynaBeanPointerFactory factory = new DynaBeanPointerFactory();
        QName name = new QName("testName");
        Object bean = new Object(); // Not a DynaBean
        Locale locale = Locale.ENGLISH;

        NodePointer result = null;
        try {
            result = factory.createNodePointer(name, bean, locale);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        assertNull(result); // Expecting null since bean is not an instance of DynaBean
    }


}