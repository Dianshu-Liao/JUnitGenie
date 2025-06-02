package org.apache.commons.lang3;
import org.apache.commons.lang3.Strings;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Strings_replace_String_String_String_int_cfg_path_19_Test {

    private class ConcreteStrings {
        // No need to extend Strings, we can directly use its static methods


        public int compare(String str1, String str2) {
            return str1.compareTo(str2);
        }

        public boolean equals(CharSequence cs1, CharSequence cs2) {
            return cs1.toString().equals(cs2.toString());
        }

        public int lastIndexOf(CharSequence sequence, CharSequence searchChar, int start) {
            return sequence.toString().lastIndexOf(searchChar.toString(), start);
        }

        public boolean contains(CharSequence sequence, CharSequence searchChar) {
            return sequence.toString().contains(searchChar.toString());
        }

        public boolean equals(String str1, String str2) {
            return str1.equals(str2);
        }

        public int indexOf(CharSequence sequence, CharSequence searchChar, int start) {
            return sequence.toString().indexOf(searchChar.toString(), start);
        }
    }







}
