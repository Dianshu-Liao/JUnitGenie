package org.apache.commons.jxpath.ri.model.container;
import org.apache.commons.jxpath.ri.model.container.ContainerPointerFactory;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.util.Locale;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class ri_model_container_ContainerPointerFactory_createNodePointer_QName_Object_Locale_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCreateNodePointerWithNonContainerBean() {
        ContainerPointerFactory factory = new ContainerPointerFactory();
        QName name = new QName("testName");
        Object bean = new Object(); // Not an instance of Container
        Locale locale = Locale.ENGLISH;

        NodePointer result = factory.createNodePointer(name, bean, locale);
        assertNull(result); // Expecting null since bean is not a Container
    }


}