import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BalanceExpenseTest{

    @Test
    public void personPay2ppl2dp(){
        Map<String, Double> expenses = new HashMap<>();
        expenses.put("Ali", 40.105);
        expenses.put("Bob", 40.105);
        expenses.put("Charlie", 10.00);

        Map<String, Double> balances = BalanceExpense.balanceExpenses(expenses);

        assertEquals(10.03, balances.get("Ali"));
        assertEquals(10.04, balances.get("Bob"));
        assertEquals(-20.07, balances.get("Charlie"));
    }

    @Test
    public void 1personPay2ppl(){
        Map<String, Double> expenses = new HashMap<>();
        expenses.put("Ali", 40.0);
        expenses.put("Bob", 40.0);
        expenses.put("Charlie", 10.0);

        Map<String, Double> balances = BalanceExpense.balanceExpenses(expenses);

        assertEquals(10.0, balances.get("Ali"));
        assertEquals(10.0, balances.get("Bob"));
        assertEquals(-20.0, balances.get("Charlie"));
    }


    @Test
    public void 4ppl(){
        Map<String, Double> expenses = new HashMap<>();
        expenses.put("Ali", 10.0);
        expenses.put("Bob", 20.0);
        expenses.put("Charlie", 0.0);
        expenses.put("Don", 10.0);

        Map<String, Double> balances = BalanceExpense.balanceExpenses(expenses);

        assertEquals(0.0, balances.get("Ali"));
        assertEquals(10.0, balances.get("Bob"));
        assertEquals(-10.0, balances.get("Charlie"));
        assertEquals(0.0, balances.get("Don"));
    }

    @Test
    public void 4pplUnequalPay(){
        Map<String, Double> expenses = new HashMap<>();
        expenses.put("Alice", 40.0);
        expenses.put("Bob", 40.0);
        expenses.put("Charlie", 10.0);
        expenses.put("Don", 10.0);

        Map<String, Double> balances = BalanceExpense.balanceExpenses(expenses);

        assertEquals(15.0, balances.get("Bob"));
        assertEquals(-15.0, balances.get("Don"));
        assertEquals(15.0, balances.get("Alice"));
        assertEquals(-15.0, balances.get("Charlie"));
    }

    @Test
    public void 4ppl1PayMore(){
        Map<String, Double> expenses = new HashMap<>();
        expenses.put("Alice", 200.0);
        expenses.put("Bob", 80.0);
        expenses.put("Charlie", 50.0);
        expenses.put("Don", 20.0);

        Map<String, Double> balances = BalanceExpense.balanceExpenses(expenses);

        assertEquals(-7.50, balances.get("Bob"));
        assertEquals(-37.50, balances.get("Charlie"));
        assertEquals(-67.50, balances.get("Don"));
        assertEquals(112.50, balances.get("Alice"));
    }

    @Test
    public void 4ppl2PayMore(){
        Map<String, Double> expenses = new HashMap<>();
        expenses.put("Alice", 160.0);
        expenses.put("Bob", 120.0);
        expenses.put("Charlie", 50.0);
        expenses.put("Don", 20.0);

        Map<String, Double> balances = BalanceExpense.balanceExpenses(expenses);

        assertEquals(-67.50, balances.get("Don"));
        assertEquals(-37.30, balances.get("Charlie"));
        assertEquals(35.0, balances.get("Alice"));
        assertEquals(32.50, balances.get("Bob"));
    }

}