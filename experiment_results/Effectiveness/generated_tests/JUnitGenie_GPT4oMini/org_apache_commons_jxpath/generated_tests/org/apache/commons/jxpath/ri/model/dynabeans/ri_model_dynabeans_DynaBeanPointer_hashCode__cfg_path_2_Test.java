package org.apache.commons.jxpath.ri.model.dynabeans;
import org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.beanutils.DynaBean;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_model_dynabeans_DynaBeanPointer_hashCode__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHashCodeWithNullName() {
        // Arrange
        DynaBeanPointer dynaBeanPointer = new DynaBeanPointer(new QName("test"), (DynaBean) null, null);
        // Act
        int result = dynaBeanPointer.hashCode();
        // Assert
        assertEquals(0, result);
    }

    @Test(timeout = 4000)
    public void testHashCodeWithNonNullName() {
        // Arrange
        QName qName = new QName("test");
        DynaBeanPointer dynaBeanPointer = new DynaBeanPointer(qName, (DynaBean) null, null);
        // Act
        int result = dynaBeanPointer.hashCode();
        // Assert
        assertEquals(qName.hashCode(), result);
    }

}