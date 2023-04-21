package parser;

import org.junit.Ignore;
import org.junit.function.ThrowingRunnable;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.MethodSource;
import shop.Cart;
import shop.RealItem;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.jupiter.params.ParameterizedTest;
import shop.VirtualItem;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;


public class JsonParserTest {

    @Parameters
    public static Collection<Cart>  testData() {
        Object[][] objects = new Object[][] {
                new Object[] {"CartName1", 1600.0, "Audi", 45654.1,20000.0,"Windows", 12.0},
                new Object[] {"CartName2", 2000.0, "Audi", 5457.1,10000.0,"Windows", 13.0},
                new Object[] {"CartName3", 12345.0, "Audi", 1111.1,780000.0,"Windows", 14.0},
                new Object[] {"CartName4", 9999.0, "Audi", 49999.1,15000.0,"Windows", 15.0},
                new Object[] {"CartName5", 1515.0, "Audi", 99999.1,97000.0,"Windows", 16.0},
                new Object[] {"CartName6", 2222.0, "Audi", 10000.1,30000.0,"Windows", 17.0},
        };

        List<Cart> carts = new ArrayList<>();

        for (int i = 0; i < objects.length; i++) {
            Cart cart = new Cart((String)objects[i][0]);

            RealItem car = new RealItem();
            car.setName((String)objects[i][2]);
            car.setPrice((Double)objects[i][3]);
            car.setWeight((Double)objects[i][1]);

            VirtualItem disk = new VirtualItem();
            disk.setName((String)objects[i][5]);
            disk.setPrice((Double)objects[i][6]);
            disk.setSizeOnDisk((Double)objects[i][4]);

            cart.addRealItem(car);
            cart.addVirtualItem(disk);

            carts.add(cart);
        }

        return new ArrayList<Cart>(carts);
    }

    @BeforeAll
    static void setup() {
        System.out.println("JsonParserTests: @BeforeAll executed");
    }

    @Test
    @Tag("JsonParserTest")
    @Ignore
     void verifyCartExistOnDisk() {
        Parser parser = new JsonParser();
        String cartName = "testCartNme";

        parser.writeToFile(new Cart(cartName));

        assertTrue(new File("src/main/resources/" + cartName + ".json").exists(),
                "File with  name "+ cartName +"should exist");
    }


    @ParameterizedTest
    @MethodSource("testData")
    @Tag("JsonParserTest")
    void writeReadCart(Cart cart) {
        Parser parser = new JsonParser();

        parser.writeToFile(cart);

        String fileName = "src/main/resources/" + cart.getCartName()+".json";

        Cart readedCart = parser.readFromFile(new File(fileName));

        assertEquals("Wrote and readed cart name should be equal " + cart.getCartName(), cart.getCartName(), (Object) readedCart.getCartName() );
    }

    @Test
    @Tag("JsonParserTest")
    void verifyException()  throws NoSuchFileException {
        Parser parser = new JsonParser();
        assertThrows(NoSuchFileException.class, (ThrowingRunnable) () -> {
            parser.readFromFile(new File("c:/parser"));
        });
    }


    @AfterAll
    static void tear() {
        System.out.println("JsonParserTests: @AfterAll executed");
    }
}
