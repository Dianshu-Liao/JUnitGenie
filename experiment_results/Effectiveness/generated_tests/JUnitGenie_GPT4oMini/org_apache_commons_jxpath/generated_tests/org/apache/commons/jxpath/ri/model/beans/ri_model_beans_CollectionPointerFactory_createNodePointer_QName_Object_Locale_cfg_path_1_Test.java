package org.apache.commons.jxpath.ri.model.beans;
import org.apache.commons.jxpath.ri.model.beans.CollectionPointerFactory;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.Test;
import java.util.Locale;
import static org.junit.Assert.assertNull;

public class ri_model_beans_CollectionPointerFactory_createNodePointer_QName_Object_Locale_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCreateNodePointer_NullBean() {
        CollectionPointerFactory factory = new CollectionPointerFactory();
        QName name = new QName("testName");
        Object bean = null; // satisfies the constraint of parameter0
        Locale locale = Locale.getDefault();

        try {
            NodePointer result = factory.createNodePointer(name, bean, locale);
            assertNull(result); // Ensure that null is returned when bean is null
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception, if any
        }
    }


}