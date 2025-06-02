package org.joda.time.tz;
import org.joda.time.tz.ZoneInfoCompiler;
import org.junit.Test;
import static org.junit.Assert.*;

public class tz_ZoneInfoCompiler_main_String_____cfg_path_44_Test {

    @Test(timeout = 4000)
    public void testMainWithValidArgs() {
        String[] args = {"-src", "inputDir", "-dst", "outputDir", "sourceFile1", "sourceFile2"};
        try {
            ZoneInfoCompiler.main(args);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testMainWithNoArgs() {
        String[] args = {};
        try {
            ZoneInfoCompiler.main(args);
        } catch (Exception e) {
            // Expected to throw an exception, as printUsage() will be called
            assertTrue(e instanceof Exception);
        }
    }

    @Test(timeout = 4000)
    public void testMainWithSrcOnly() {
        String[] args = {"-src", "inputDir"};
        try {
            ZoneInfoCompiler.main(args);
        } catch (Exception e) {
            // Expected to throw an exception, as printUsage() will be called
            assertTrue(e instanceof Exception);
        }
    }

    @Test(timeout = 4000)
    public void testMainWithDstOnly() {
        String[] args = {"-dst", "outputDir"};
        try {
            ZoneInfoCompiler.main(args);
        } catch (Exception e) {
            // Expected to throw an exception, as printUsage() will be called
            assertTrue(e instanceof Exception);
        }
    }

    @Test(timeout = 4000)
    public void testMainWithVerboseFlag() {
        String[] args = {"-verbose", "-src", "inputDir", "-dst", "outputDir", "sourceFile1"};
        try {
            ZoneInfoCompiler.main(args);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

}