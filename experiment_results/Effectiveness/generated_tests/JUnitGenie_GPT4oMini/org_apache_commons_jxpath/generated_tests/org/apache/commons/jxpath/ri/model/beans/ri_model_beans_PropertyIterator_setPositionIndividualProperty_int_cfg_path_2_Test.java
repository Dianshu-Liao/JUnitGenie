package org.apache.commons.jxpath.ri.model.beans;
import org.apache.commons.jxpath.ri.model.beans.PropertyIterator;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ri_model_beans_PropertyIterator_setPositionIndividualProperty_int_cfg_path_2_Test {


    private void setField(PropertyIterator propertyIterator, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = PropertyIterator.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(propertyIterator, value);
    }

}
