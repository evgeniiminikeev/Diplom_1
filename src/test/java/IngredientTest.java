import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    private final String randomName = RandomStringUtils.randomAlphabetic(10);
    private final float randomPrice = Float.valueOf(RandomStringUtils.randomNumeric(5));

    @Test
    public void getTypeShouldReturnTypeOfIngredient() {
        Ingredient testIngredient = new Ingredient(SAUCE, randomName, randomPrice);
        IngredientType actualType = testIngredient.getType();
        assertEquals(SAUCE, actualType);
    }

    @Test
    public void getNameShouldReturnNameOfIngredient() {
        Ingredient testIngredient = new Ingredient(FILLING, randomName, randomPrice);
        String actualName = testIngredient.getName();
        assertEquals(randomName, actualName);
    }

    @Test
    public void getPriceShouldReturnPriceOfIngredient() {
        Ingredient testIngredient = new Ingredient(SAUCE, randomName, randomPrice);
        float actualPrice = testIngredient.getPrice();
        assertEquals(randomPrice, actualPrice, 0.0);

    }


}
