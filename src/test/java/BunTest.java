import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.apache.commons.lang3.RandomStringUtils;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private static final String randomName = RandomStringUtils.randomAlphabetic(10);
    private static final float randomPrice = Float.valueOf(RandomStringUtils.randomNumeric(5));
    private static final String STRANGENAME = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {randomName, randomPrice},
                {"", randomPrice},
                {null, randomPrice},
                {STRANGENAME, randomPrice},
                {randomName, 0},
                {randomName, Float.MAX_VALUE},
                {randomName, Float.MIN_VALUE}
        };
    }

    @Test
    public void getNameShouldReturnNameOfBun() {
        Bun testBun = new Bun(name, price);
        assertEquals(name, testBun.getName());
    }

    @Test
    public void getPriceShouldReturnPriceOfBun() {
        Bun testBun = new Bun(name, price);
        assertEquals(price, testBun.getPrice(), 0);
    }

}
