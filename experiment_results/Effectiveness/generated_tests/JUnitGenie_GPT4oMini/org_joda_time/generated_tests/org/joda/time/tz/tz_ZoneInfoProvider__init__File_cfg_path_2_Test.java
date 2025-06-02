package org.joda.time.tz;
import org.joda.time.tz.ZoneInfoProvider;
import org.junit.Test;
import java.io.File;
import java.io.IOException;

public class tz_ZoneInfoProvider__init__File_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testConstructor_FileNotADirectory() {
        File file = new File("not_a_directory.txt"); // Assuming this file does not refer to a directory
        try {
            new ZoneInfoProvider(file);
        } catch (IOException e) {
            // Expected exception
            assert e.getMessage().equals("File doesn't refer to a directory: " + file);
        } catch (Exception e) {
            // Handle unexpected exceptions
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testConstructor_FileDoesNotExist() {
        File file = new File("non_existent_directory"); // Assuming this directory does not exist
        try {
            new ZoneInfoProvider(file);
        } catch (IOException e) {
            // Expected exception
            assert e.getMessage().equals("File directory doesn't exist: " + file);
        } catch (Exception e) {
            // Handle unexpected exceptions
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testConstructor_NullFile() {
        try {
            new ZoneInfoProvider((File) null); // Explicitly casting to File to resolve ambiguity
        } catch (IllegalArgumentException e) {
            // Expected exception
            assert e.getMessage().equals("No file directory provided");
        } catch (Exception e) {
            // Handle unexpected exceptions
            e.printStackTrace();
        }
    }


}