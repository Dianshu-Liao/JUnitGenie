package com.fasterxml.jackson.databind.introspect;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.fasterxml.jackson.databind.introspect.AnnotationMap;
import java.lang.annotation.Annotation;
import java.util.HashMap;

public class introspect_AnnotationMap_merge_AnnotationMap_AnnotationMap_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testMergeWhenPrimaryIsNull() {
        AnnotationMap primary = null;
        HashMap<Class<?>, Annotation> secondaryMap = new HashMap<>();
        AnnotationMap secondary = new AnnotationMap(secondaryMap);

        try {
            AnnotationMap result = AnnotationMap.merge(primary, secondary);
            assertEquals(secondary, result);
        } catch (Exception e) {
            // Handle any exceptions that might be thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testMergeWhenSecondaryIsNull() {
        HashMap<Class<?>, Annotation> primaryMap = new HashMap<>();
        AnnotationMap primary = new AnnotationMap(primaryMap);
        AnnotationMap secondary = null;

        try {
            AnnotationMap result = AnnotationMap.merge(primary, secondary);
            assertEquals(primary, result);
        } catch (Exception e) {
            // Handle any exceptions that might be thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testMergeWhenBothAreNull() {
        AnnotationMap primary = null;
        AnnotationMap secondary = null;

        try {
            AnnotationMap result = AnnotationMap.merge(primary, secondary);
            assertEquals(null, result);
        } catch (Exception e) {
            // Handle any exceptions that might be thrown
            e.printStackTrace();
        }
    }


}