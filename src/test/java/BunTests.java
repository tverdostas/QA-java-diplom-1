import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTests {

    int TEST_BUN_PRICE = 200;
    String TEST_BUN_NAME = "test bun";
    @Test
    public void getBunNameTest() {
        Bun bun = new Bun(TEST_BUN_NAME, TEST_BUN_PRICE);
        assertEquals(TEST_BUN_NAME, bun.getName());
    }

    @Test
    public void getBunPriceTest() {
        Bun bun = new Bun(TEST_BUN_NAME, TEST_BUN_PRICE);
        assertEquals(TEST_BUN_PRICE, bun.getPrice(), 0.01);
    }
}
