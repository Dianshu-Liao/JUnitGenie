package org.apache.commons.jxpath.ri.model.beans;
import org.apache.commons.jxpath.ri.model.beans.BeanPointer;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.JXPathBeanInfo;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_model_beans_BeanPointer_hashCode__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHashCodeWithNonNullName() {
        // Arrange
        QName qName = new QName("testName");
        JXPathBeanInfo beanInfo = null; // Assuming a valid JXPathBeanInfo instance is not required for this test
        BeanPointer beanPointer = new BeanPointer((NodePointer) null, qName, new Object(), beanInfo); // Specify Object type

        // Act
        int result = beanPointer.hashCode();

        // Assert
        assertEquals(qName.hashCode(), result);
    }

    @Test(timeout = 4000)
    public void testHashCodeWithNullName() {
        // Arrange
        BeanPointer beanPointer = new BeanPointer((NodePointer) null, null, new Object(), null); // Specify Object type

        // Act
        int result = 0;
        try {
            result = beanPointer.hashCode();
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertEquals(0, result);
    }


}