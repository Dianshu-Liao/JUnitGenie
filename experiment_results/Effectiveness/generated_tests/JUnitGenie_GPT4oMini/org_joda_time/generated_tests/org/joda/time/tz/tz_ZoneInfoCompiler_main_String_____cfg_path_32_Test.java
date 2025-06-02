package org.joda.time.tz;
import org.joda.time.tz.ZoneInfoCompiler;
import java.io.File;

public class tz_ZoneInfoCompiler_main_String_____cfg_path_32_Test {

    @org.junit.Test
    public void testMainWithValidArgs() {
        String[] args = {"-src", "inputDir", "-dst", "outputDir", "-verbose", "sourceFile1", "sourceFile2"};
        try {
            ZoneInfoCompiler.main(args);
        } catch (Exception e) {
            org.junit.Assert.fail("An exception was thrown: " + e.getMessage());
        }
    }
    
    @org.junit.Test
    public void testMainWithNoArgs() {
        String[] args = {};
        try {
            ZoneInfoCompiler.main(args);
        } catch (Exception e) {
            org.junit.Assert.assertTrue(e instanceof Exception);
        }
    }
    
    @org.junit.Test
    public void testMainWithMissingSourceDir() {
        String[] args = {"-src"};
        try {
            ZoneInfoCompiler.main(args);
        } catch (Exception e) {
            org.junit.Assert.assertTrue(e instanceof Exception);
        }
    }
    
    @org.junit.Test
    public void testMainWithUnknownArgument() {
        String[] args = {"-unknown"};
        try {
            ZoneInfoCompiler.main(args);
        } catch (Exception e) {
            org.junit.Assert.assertTrue(e instanceof Exception);
        }
    }
    
    @org.junit.Test
    public void testMainWithMissingDestinationDir() {
        String[] args = {"-dst"};
        try {
            ZoneInfoCompiler.main(args);
        } catch (Exception e) {
            org.junit.Assert.assertTrue(e instanceof Exception);
        }
    }

}