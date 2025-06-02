package org.joda.time.chrono;
import org.joda.time.Instant;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.GJCacheKey;
import org.junit.Test;
import static org.junit.Assert.*;

public class chrono_GJCacheKey_equals_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testEquals_TrueCondition() {
        // Arrange
        Instant instant1 = Instant.now();
        Instant instant2 = Instant.now();
        GJCacheKey key1 = new GJCacheKey(DateTimeZone.UTC, instant1, 5);
        GJCacheKey key2 = new GJCacheKey(DateTimeZone.UTC, instant2, 5);
        
        // Act
        boolean result = key1.equals(key2);

        // Assert
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testEquals_FalseCondition_DifferentMinDays() {
        // Arrange
        Instant instant = Instant.now();
        GJCacheKey key1 = new GJCacheKey(DateTimeZone.UTC, instant, 5);
        GJCacheKey key2 = new GJCacheKey(DateTimeZone.UTC, instant, 10);

        // Act
        boolean result = key1.equals(key2);

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testEquals_FalseCondition_Null() {
        // Arrange
        Instant instant = Instant.now();
        GJCacheKey key = new GJCacheKey(DateTimeZone.UTC, instant, 5);
        
        // Act
        boolean result = key.equals(null);

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testEquals_FalseCondition_DifferentType() {
        // Arrange
        Instant instant = Instant.now();
        GJCacheKey key = new GJCacheKey(DateTimeZone.UTC, instant, 5);
        
        // Act
        boolean result = key.equals("Not a GJCacheKey");

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testEquals_FalseCondition_DifferentZone() {
        // Arrange
        Instant instant = Instant.now();
        GJCacheKey key1 = new GJCacheKey(DateTimeZone.UTC, instant, 5);
        GJCacheKey key2 = new GJCacheKey(DateTimeZone.forID("America/New_York"), instant, 5);

        // Act
        boolean result = key1.equals(key2);

        // Assert
        assertFalse(result);
    }

}