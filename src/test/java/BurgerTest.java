import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.*;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun mockBun;
    @Mock
    Ingredient mockIngredient1;
    @Mock
    Ingredient mockIngredient2;
    @Mock
    Ingredient mockIngredient3;
    Burger testBurger;
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        testBurger = new Burger();
    }

    @Test
    public void addIngredientTest() {
        int expectedNumberOfIngredients = testBurger.ingredients.size() + 1;
        testBurger.addIngredient(mockIngredient1);
        assertEquals(expectedNumberOfIngredients, testBurger.ingredients.size());
    }

    @Test
    public void removeFirstIngredientTest() {
        testBurger.addIngredient(mockIngredient1);
        testBurger.addIngredient(mockIngredient2);
        testBurger.addIngredient(mockIngredient3);
        int expectedNumberOfIngredients = testBurger.ingredients.size() - 1;
        testBurger.removeIngredient(0);
        assertEquals(expectedNumberOfIngredients, testBurger.ingredients.size());
        assertFalse(testBurger.ingredients.contains(mockIngredient1));
    }
    @Test
    public void removeLastIngredientTest() {
        testBurger.addIngredient(mockIngredient1);
        testBurger.addIngredient(mockIngredient2);
        testBurger.addIngredient(mockIngredient3);
        int expectedNumberOfIngredients = testBurger.ingredients.size() - 1;
        testBurger.removeIngredient(testBurger.ingredients.size() - 1);
        assertEquals(expectedNumberOfIngredients, testBurger.ingredients.size());
        assertFalse(testBurger.ingredients.contains(mockIngredient3));
    }

    @Test
    public void moveIngredientTest() {
        testBurger.addIngredient(mockIngredient1);
        testBurger.addIngredient(mockIngredient2);
        testBurger.addIngredient(mockIngredient3);
        testBurger.moveIngredient(0, 2);
        assertEquals(mockIngredient1, testBurger.ingredients.get(2));
    }

    @Test
    public void getPrice() {
        float priceBun = Float.valueOf(RandomStringUtils.randomNumeric(5));
        float priceIngredient = Float.valueOf(RandomStringUtils.randomNumeric(5));
        testBurger.setBuns(mockBun);
        testBurger.addIngredient(mockIngredient1);
        Mockito.when(mockBun.getPrice()).thenReturn(priceBun);
        Mockito.when(mockIngredient1.getPrice()).thenReturn(priceIngredient);
        float exptecteBurgerPrice = priceBun * 2 + priceIngredient;
        float actualPrice = testBurger.getPrice();
        assertEquals(exptecteBurgerPrice, actualPrice, 0);

    }

    @Test
    public void getReciept() {
        String nameBun = RandomStringUtils.randomAlphabetic(10);
        String nameIngredient = RandomStringUtils.randomAlphabetic(10);
        float priceBun = Float.valueOf(RandomStringUtils.randomNumeric(5));
        float priceIngredient = Float.valueOf(RandomStringUtils.randomNumeric(5));
        testBurger.setBuns(mockBun);
        testBurger.addIngredient(mockIngredient1);
        Mockito.when(mockBun.getName()).thenReturn(nameBun);
        Mockito.when(mockIngredient1.getType()).thenReturn(SAUCE);
        Mockito.when(mockIngredient1.getName()).thenReturn(nameIngredient);
        Mockito.when(mockBun.getPrice()).thenReturn(priceBun);
        Mockito.when(mockIngredient1.getPrice()).thenReturn(priceIngredient);
        float expectedBurgerPrice = priceBun * 2 + priceIngredient;
        String expectedReceipt = String.format(
                "(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                nameBun, SAUCE.toString().toLowerCase(),
                nameIngredient, nameBun, expectedBurgerPrice
        );
        assertEquals(expectedReceipt, testBurger.getReceipt());
    }

}
