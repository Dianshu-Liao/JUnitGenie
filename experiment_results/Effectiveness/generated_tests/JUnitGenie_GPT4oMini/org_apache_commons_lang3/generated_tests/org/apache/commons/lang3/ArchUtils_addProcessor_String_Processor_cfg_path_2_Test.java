package org.apache.commons.lang3;
import org.apache.commons.lang3.arch.Processor;
import org.apache.commons.lang3.arch.Processor.Arch;
import org.apache.commons.lang3.arch.Processor.Type;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ArchUtils_addProcessor_String_Processor_cfg_path_2_Test {

    private static Map<String, Processor> ARCH_TO_PROCESSOR = new HashMap<>();



    private void clearARCH_TO_PROCESSOR() throws Exception {
        // Use reflection to clear the ARCH_TO_PROCESSOR map
        Field field = ArchUtils.class.getDeclaredField("ARCH_TO_PROCESSOR");
        field.setAccessible(true);
        Map<String, Processor> map = (Map<String, Processor>) field.get(null);
        map.clear();
    }


}
