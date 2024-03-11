import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void numberOfIngredientType() {
        int expectedNumberOfIngredientType = 2;
        int actualNumberOfIngredientType = IngredientType.values().length;
        assertEquals(expectedNumberOfIngredientType, actualNumberOfIngredientType);
    }

    @Test
    public void valuesOfIngredientType() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}
