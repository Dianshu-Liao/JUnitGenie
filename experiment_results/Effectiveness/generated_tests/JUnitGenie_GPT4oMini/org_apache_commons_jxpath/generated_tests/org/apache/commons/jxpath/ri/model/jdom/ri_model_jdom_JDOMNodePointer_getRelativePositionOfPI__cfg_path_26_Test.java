package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Element;
import org.jdom.ProcessingInstruction;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Locale;
import static org.junit.Assert.assertEquals;

public class ri_model_jdom_JDOMNodePointer_getRelativePositionOfPI__cfg_path_26_Test {

    @Test(timeout = 4000)
    public void testGetRelativePositionOfPI_whenParentIsNull() {
        try {
            // Arrange
            // Corrected the constructor call for ProcessingInstruction
            ProcessingInstruction processingInstruction = new ProcessingInstruction("target", "data");
            // Set the node field to processingInstruction via reflection
            JDOMNodePointer jdomNodePointer = new JDOMNodePointer(processingInstruction, Locale.getDefault());
            java.lang.reflect.Field field = JDOMNodePointer.class.getDeclaredField("node");
            field.setAccessible(true);
            field.set(jdomNodePointer, processingInstruction);

            // Set the parent to null
            Method method = JDOMNodePointer.class.getDeclaredMethod("getRelativePositionOfPI");
            method.setAccessible(true);

            // Act
            int position = (int) method.invoke(jdomNodePointer);

            // Assert
            assertEquals(1, position);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}