package org.apache.commons.jxpath.ri.model.beans;
import org.apache.commons.jxpath.ri.model.beans.CollectionPointerFactory;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.Test;
import java.util.Locale;
import static org.junit.Assert.assertNull;

public class ri_model_beans_CollectionPointerFactory_createNodePointer_QName_Object_Locale_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCreateNodePointerWithNullBean() {
        CollectionPointerFactory factory = new CollectionPointerFactory();
        QName name = new QName("testName"); // Using the constructor with a single String parameter
        Object bean = null; // This satisfies the External_Method_Parameters_Constraints
        Locale locale = Locale.getDefault();

        try {
            NodePointer result = factory.createNodePointer(name, bean, locale);
            assertNull(result); // Expecting null as the return value
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }


}