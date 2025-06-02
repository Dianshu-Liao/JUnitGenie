package org.joda.time.tz;
import org.joda.time.tz.ZoneInfoCompiler;
import org.junit.Test;

public class tz_ZoneInfoCompiler_main_String_____cfg_path_35_Test {

    @Test(timeout = 4000)
    public void testMain_NoSrcArgument() {
        String[] args = {"-dst", "outputDir", "file1.txt", "file2.txt"};
        try {
            ZoneInfoCompiler.main(args);
        } catch (Exception e) {
            // Handle the exception if needed
        }
    }

}