package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.io.output.CountingOutputStream;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.zip.CRC32;
import static org.junit.Assert.assertEquals;

public class archivers_sevenz_SevenZOutputFile_closeArchiveEntry__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCloseArchiveEntry() {
        // Setup
        try {
            File testFile = new File("test.7z");
            SevenZOutputFile sevenZOutputFile = new SevenZOutputFile(testFile);
            CountingOutputStream countingOutputStream = new CountingOutputStream(new java.io.ByteArrayOutputStream());

            // Use reflection to access private fields
            java.lang.reflect.Field currentOutputStreamField = SevenZOutputFile.class.getDeclaredField("currentOutputStream");
            currentOutputStreamField.setAccessible(true);
            currentOutputStreamField.set(sevenZOutputFile, countingOutputStream);

            java.lang.reflect.Field fileBytesWrittenField = SevenZOutputFile.class.getDeclaredField("fileBytesWritten");
            fileBytesWrittenField.setAccessible(true);
            fileBytesWrittenField.setInt(sevenZOutputFile, 100);

            SevenZArchiveEntry entry = new SevenZArchiveEntry();
            java.lang.reflect.Field filesField = SevenZOutputFile.class.getDeclaredField("files");
            filesField.setAccessible(true);
            ((java.util.List<SevenZArchiveEntry>) filesField.get(sevenZOutputFile)).add(entry);

            // Set the CRC values using reflection
            java.lang.reflect.Field crc32Field = SevenZOutputFile.class.getDeclaredField("crc32");
            crc32Field.setAccessible(true);
            CRC32 crc32 = (CRC32) crc32Field.get(sevenZOutputFile);
            crc32.update(new byte[100]);

            java.lang.reflect.Field compressedCrc32Field = SevenZOutputFile.class.getDeclaredField("compressedCrc32");
            compressedCrc32Field.setAccessible(true);
            CRC32 compressedCrc32 = (CRC32) compressedCrc32Field.get(sevenZOutputFile);
            compressedCrc32.update(new byte[100]);

            // Execute the method under test
            sevenZOutputFile.closeArchiveEntry();

            // Verify the results using reflection
            java.lang.reflect.Field numNonEmptyStreamsField = SevenZOutputFile.class.getDeclaredField("numNonEmptyStreams");
            numNonEmptyStreamsField.setAccessible(true);
            assertEquals(1, numNonEmptyStreamsField.getInt(sevenZOutputFile));
            assertEquals(100, entry.getSize());
            assertEquals(100, entry.getCompressedSize());
            assertEquals(crc32.getValue(), entry.getCrcValue());
            assertEquals(compressedCrc32.getValue(), entry.getCompressedCrcValue());
            assertEquals(true, entry.hasStream());
            // Corrected the following line to use the correct method for checking CRC
            assertEquals(true, entry.getCrcValue() != 0); // Assuming a non-zero CRC indicates presence

        } catch (IOException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}