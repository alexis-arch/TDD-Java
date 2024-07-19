import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

@Test
public class TestCalculate {
    private Calculator calculator;

    @BeforeTest
    public void init() {
        calculator = new Calculator();
    }

    public void emptyStringReturnsZero() throws Exception {
        // Teste si une chaîne vide retourne 0 (étape 1)
        assertEquals(calculator.calculate(""), 0);
    }

    public void singleValueIsReplied() throws Exception {
        // Teste si une chaîne avec un seul nombre retourne ce nombre (étape 1)
        assertEquals(calculator.calculate("1"), 1);
    }

    public void twoNumbersCommaDelimitedReturnSum() throws Exception {
        // Teste si deux nombres séparés par des virgules retournent leur somme (étape 1)
        assertEquals(calculator.calculate("1,2"), 3);
    }

    public void twoNumbersNewLineDelimitedReturnSum() throws Exception {
        // Teste si deux nombres séparés par des nouvelles lignes retournent leur somme (étape 3)
        assertEquals(calculator.calculate("1\n2"), 3);
    }

    public void threeNumbersDelimitedWaysReturnSum() throws Exception {
        // Teste si trois nombres séparés de différentes façons retournent leur somme (étape 2)
        assertEquals(calculator.calculate("1,2,3"), 6);
    }

    @Test(expectedExceptions = Exception.class)
    public void negativeInputReturnsExceptions() throws Exception {
        // Teste si une entrée négative lève une exception (étape 6)
        calculator.calculate("-1");
    }

    public void ignoresNumbersGreaterThan1000() throws Exception {
        // Teste si les nombres supérieurs à 1000 sont ignorés (étape 8)
        assertEquals(calculator.calculate("10,10,1001"), 20);
    }
}
