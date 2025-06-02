package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import org.junit.Test;
import static org.junit.Assert.*;

class util_ValueUtils_setValue_Object_PropertyDescriptor_int_Object_cfg_path_13_Test {
    private String[] myProperty = new String[10]; // Example indexed property
    private String nonIndexedProperty; // Example non-indexed property

    public String[] getMyProperty() {
        return myProperty;
    }

    public void setMyProperty(int index, String value) {
        myProperty[index] = value;
    }

    public String getNonIndexedProperty() {
        return nonIndexedProperty;
    }

    public void setNonIndexedProperty(String value) {
        this.nonIndexedProperty = value;
    }

}