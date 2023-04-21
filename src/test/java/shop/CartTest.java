package shop;

import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

class CartTest {
    @BeforeAll
    static void setup() {
        System.out.println("CartTests: @BeforeAll executed");
    }
    @BeforeEach
    void setUp() {
    }

    @Test
    void getCartName() {
        Cart cart = new Cart("cart1");
        assertEquals("cart1", cart.getCartName(), "CartName should equal 'cart1'");
    }

    @Test
    void getTotalPrice() {
        Cart cart = new Cart("cart1");
        RealItem item = new RealItem();
        item.setPrice(1000);
        cart.addRealItem(item);
        assertEquals(1200, cart.getTotalPrice(), "TotalPrice should equal 1200");
    }

    @AfterAll
    static void tear() {
        System.out.println("CartTests: @AfterAll executed");
    }

    @AfterEach
    void tearDown() {
    }

}
