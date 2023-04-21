package shop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RealItemTests {

    @BeforeAll
    static void setup() {
        System.out.println("RealItemTests: @BeforeAll executed");
    }

    @Test
    void verifySetGetWeight() {
        RealItem car = new RealItem();
         car.setWeight(1560);
        assertEquals(1560, car.getWeight(), "Weight should equal 1560");
    }

    @AfterAll
    static void tear() {
        System.out.println("RealItemTests: @AfterAll executed");
    }
}
