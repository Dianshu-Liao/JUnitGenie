package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import org.junit.Test;
import static org.junit.Assert.*;

class util_ValueUtils_setValue_Object_PropertyDescriptor_int_Object_cfg_path_17_Test {
    private String[] myProperty = new String[10]; // Example property

    public String getMyProperty(int index) {
        return myProperty[index];
    }

    public void setMyProperty(int index, String value) {
        myProperty[index] = value;
    }

}