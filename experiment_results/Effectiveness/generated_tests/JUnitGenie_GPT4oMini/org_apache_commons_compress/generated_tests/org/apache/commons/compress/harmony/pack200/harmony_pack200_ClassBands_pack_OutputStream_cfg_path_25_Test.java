package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.ClassBands;
import org.apache.commons.compress.harmony.pack200.CPClass;
import org.apache.commons.compress.harmony.pack200.CPNameAndType;
import org.apache.commons.compress.harmony.pack200.PackingUtils;
import org.apache.commons.compress.harmony.pack200.Codec;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.junit.Test;

public class harmony_pack200_ClassBands_pack_OutputStream_cfg_path_25_Test {
    

    private void setField(ClassBands classBands, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = ClassBands.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(classBands, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
