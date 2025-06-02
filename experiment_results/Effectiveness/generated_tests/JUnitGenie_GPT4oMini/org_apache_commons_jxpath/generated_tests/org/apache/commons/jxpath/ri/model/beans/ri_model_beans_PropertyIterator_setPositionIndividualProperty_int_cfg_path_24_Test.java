package org.apache.commons.jxpath.ri.model.beans;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyIterator;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ri_model_beans_PropertyIterator_setPositionIndividualProperty_int_cfg_path_24_Test {


    // Helper methods to set private fields
    private void setPropertyIteratorEmpty(PropertyIterator propertyIterator, boolean empty) throws Exception {
        Method method = PropertyIterator.class.getDeclaredMethod("setEmpty", boolean.class);
        method.setAccessible(true);
        method.invoke(propertyIterator, empty);
    }

    private void setPropertyIteratorReverse(PropertyIterator propertyIterator, boolean reverse) throws Exception {
        Method method = PropertyIterator.class.getDeclaredMethod("setReverse", boolean.class);
        method.setAccessible(true);
        method.invoke(propertyIterator, reverse);
    }

}
