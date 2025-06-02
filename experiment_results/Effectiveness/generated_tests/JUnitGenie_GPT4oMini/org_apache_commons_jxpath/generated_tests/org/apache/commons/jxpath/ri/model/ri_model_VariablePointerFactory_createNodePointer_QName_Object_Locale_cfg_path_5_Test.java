package org.apache.commons.jxpath.ri.model;
import org.apache.commons.jxpath.ri.model.VariablePointerFactory;
import org.apache.commons.jxpath.ri.QName;
import org.junit.Test;
import java.util.Locale;
import static org.junit.Assert.assertNull;

public class ri_model_VariablePointerFactory_createNodePointer_QName_Object_Locale_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testCreateNodePointerWithNonVariableContextWrapper() {
        VariablePointerFactory factory = new VariablePointerFactory();
        QName name = new QName("testName");
        Object object = new Object(); // Not an instance of VariableContextWrapper
        Locale locale = Locale.ENGLISH;

        // Execute the focal method
        NodePointer result = null;
        try {
            result = factory.createNodePointer(name, object, locale);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        // Verify the result is null as expected
        assertNull(result);
    }


}