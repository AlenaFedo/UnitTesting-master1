package shop;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VirtualItemTests {
    @BeforeAll
    static void setup() {
        System.out.println("VirtualItemTests: @BeforeAll executed");
    }

    @Test
    void verifySetGetSizeOnDisk() {
        VirtualItem item = new VirtualItem();
            item.setSizeOnDisk(9500);
        assertEquals(9500, item.getSizeOnDisk(), "Size should equal 9500");
    }

    @AfterAll
    static void tear() {
        System.out.println("VirtualItemTests: @AfterAll executed");
    }
}
