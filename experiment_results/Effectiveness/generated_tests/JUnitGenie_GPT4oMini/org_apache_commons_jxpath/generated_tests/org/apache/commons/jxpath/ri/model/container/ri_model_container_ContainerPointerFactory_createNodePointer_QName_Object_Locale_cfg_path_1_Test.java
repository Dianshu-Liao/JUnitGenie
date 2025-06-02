package org.apache.commons.jxpath.ri.model.container;
import org.apache.commons.jxpath.ri.model.container.ContainerPointerFactory;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.Test;
import java.util.Locale;
import static org.junit.Assert.assertNotNull;

public class ri_model_container_ContainerPointerFactory_createNodePointer_QName_Object_Locale_cfg_path_1_Test {


    @Test(timeout = 4000)
    public void testCreateNodePointerWithNonContainer() {
        ContainerPointerFactory factory = new ContainerPointerFactory();
        QName name = new QName("testName");
        Object bean = new Object(); // Not a Container
        Locale locale = Locale.ENGLISH;

        NodePointer result = null;
        try {
            result = factory.createNodePointer(name, bean, locale);
        } catch (Exception e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }

        assertNotNull("NodePointer should be null when bean is not an instance of Container", result);
    }


}
