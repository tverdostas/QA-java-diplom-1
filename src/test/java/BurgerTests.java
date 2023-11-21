import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {
    Burger burger = new Burger();
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredientSecond;
    @Mock
    Database database;
    private final List<Bun> buns = Arrays.asList(new Bun("test bun",200.0F));
    private final String bunName = "test bun";

    @Before
    public void setDefaultBun() {
        Mockito.when(database.availableBuns()).thenReturn(buns);
    }

    @Test
    public void getPriceBurgerTest() {
        Mockito.when(ingredient.getPrice()).thenReturn(175.5F);
        Mockito.when(ingredientSecond.getPrice()).thenReturn(270F);
        burger.setBuns(database.availableBuns().get(0));
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientSecond);
        float expectedBurgerPrice = 845.5F;
        assertEquals("Неверная цена бургера с двумя ингредиентами", expectedBurgerPrice, burger.getPrice(), 0);
    }
    @Test
    public void getReceiptBurgerTest() {
       Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("test sauce");
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        Mockito.when(ingredientSecond.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientSecond.getName()).thenReturn("test filling");
        Mockito.when(ingredientSecond.getPrice()).thenReturn(300F);
        burger.setBuns(database.availableBuns().get(0));
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientSecond);
        String expected = String.format("(==== test bun ====)" + "%n"
                + "= sauce test sauce =" + "%n"
                + "= filling test filling ="+ "%n"
                + "(==== test bun ====)" + "%n%n"
                + "Price: 800.000000" + "%n");
        assertEquals(expected, burger.getReceipt());
    }
}
