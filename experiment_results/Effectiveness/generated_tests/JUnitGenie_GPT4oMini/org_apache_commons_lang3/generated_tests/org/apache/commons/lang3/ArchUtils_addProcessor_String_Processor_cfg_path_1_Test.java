package org.apache.commons.lang3;
import org.apache.commons.lang3.ArchUtils;
import org.apache.commons.lang3.arch.Processor;
import org.apache.commons.lang3.arch.Processor.Arch;
import org.apache.commons.lang3.arch.Processor.Type;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.fail;

public class ArchUtils_addProcessor_String_Processor_cfg_path_1_Test {


    private void invokeAddProcessor(String key, Processor processor) throws Exception {
        Method method = ArchUtils.class.getDeclaredMethod("addProcessor", String.class, Processor.class);
        method.setAccessible(true);
        method.invoke(null, key, processor);
    }


}
