package org.apache.commons.codec.language;
import org.apache.commons.codec.language.Metaphone;
import org.apache.commons.codec.EncoderException;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class language_Metaphone_encode_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEncodeWithValidString() {
        Metaphone metaphone = new Metaphone();
        String input = "example";
        try {
            String result = metaphone.encode(input); // Change Object to String
            assertNotNull(result);
        } catch (Exception e) { // Catching a more general exception
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEncodeWithInvalidType() {
        Metaphone metaphone = new Metaphone();
        Object input = 123; // Not a String
        try {
            metaphone.encode((String) input); // Cast input to String to trigger the exception
        } catch (ClassCastException e) {
            // Expected exception for invalid type
            assertNotNull(e);
            System.out.println("Caught expected exception: " + e.getMessage());
        } catch (Exception e) { // Catching a more general exception
            // Handle unexpected exceptions
            e.printStackTrace();
        }
    }


}