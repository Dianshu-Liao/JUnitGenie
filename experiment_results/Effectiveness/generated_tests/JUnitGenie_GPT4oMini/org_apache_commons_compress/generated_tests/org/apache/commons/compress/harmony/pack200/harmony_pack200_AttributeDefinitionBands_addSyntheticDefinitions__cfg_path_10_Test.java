package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands;
import org.apache.commons.compress.harmony.pack200.ClassBands;
import org.apache.commons.compress.harmony.pack200.CpBands;
import org.apache.commons.compress.harmony.pack200.Segment;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class harmony_pack200_AttributeDefinitionBands_addSyntheticDefinitions__cfg_path_10_Test {


    private Object getPrivateField(AttributeDefinitionBands instance, String fieldName) {
        try {
            java.lang.reflect.Field field = AttributeDefinitionBands.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(instance);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
