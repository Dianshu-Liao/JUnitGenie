package org.joda.time.tz;
import org.joda.time.tz.ZoneInfoCompiler;
import org.junit.Test;

public class tz_ZoneInfoCompiler_main_String_____cfg_path_33_Test {

    @Test(timeout = 4000)
    public void testMainWithNoArguments() {
        String[] args = {}; // No arguments to trigger printUsage
        try {
            ZoneInfoCompiler.main(args);
        } catch (Exception e) {
            // Handle the exception if needed
        }
    }

    @Test(timeout = 4000)
    public void testMainWithInvalidArguments() {
        String[] args = {"-src", "inputDir", "-dst", "outputDir", "-verbose", "-?"}; // Invalid argument to trigger printUsage
        try {
            ZoneInfoCompiler.main(args);
        } catch (Exception e) {
            // Handle the exception if needed
        }
    }

    @Test(timeout = 4000)
    public void testMainWithValidArguments() {
        String[] args = {"-src", "inputDir", "file1.txt", "file2.txt"}; // Valid arguments to test normal execution
        try {
            ZoneInfoCompiler.main(args);
        } catch (Exception e) {
            // Handle the exception if needed
        }
    }

}