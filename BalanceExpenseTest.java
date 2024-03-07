// import org.junit.jupiter.api.Test;
// import java.util.HashMap;
// import java.util.Map;
// import static org.junit.jupiter.api.Assertions.assertEquals;

// public class BalanceExpenseTest{

//     @Test
//     public void testpersonPay2ppl2dp(){
//         Map<String, Double> expenses = new HashMap<>();
//         expenses.put("Ali", 40.105);
//         expenses.put("Bob", 40.105);
//         expenses.put("Charlie", 10.00);

//         Map<String, Double> balances = BalanceExpense.balanceExpenses(expenses);

//         assertEquals(10.03, balances.get("Ali"));
//         assertEquals(10.04, balances.get("Bob"));
//         assertEquals(-20.07, balances.get("Charlie"));
//     }

//     @Test
//     public void test1personPay2ppl(){
//         Map<String, Double> expenses = new HashMap<>();
//         expenses.put("Ali", 40.0);
//         expenses.put("Bob", 40.0);
//         expenses.put("Charlie", 10.0);

//         Map<String, Double> balances = BalanceExpense.balanceExpenses(expenses);

//         assertEquals(10.0, balances.get("Ali"));
//         assertEquals(10.0, balances.get("Bob"));
//         assertEquals(-20.0, balances.get("Charlie"));
//     }


//     @Test
//     public void test4ppl(){
//         Map<String, Double> expenses = new HashMap<>();
//         expenses.put("Ali", 10.0);
//         expenses.put("Bob", 20.0);
//         expenses.put("Charlie", 0.0);
//         expenses.put("Don", 10.0);

//         Map<String, Double> balances = BalanceExpense.balanceExpenses(expenses);

//         assertEquals(0.0, balances.get("Ali"));
//         assertEquals(10.0, balances.get("Bob"));
//         assertEquals(-10.0, balances.get("Charlie"));
//         assertEquals(0.0, balances.get("Don"));
//     }

//     @Test
//     public void test4pplUnequalPay(){
//         Map<String, Double> expenses = new HashMap<>();
//         expenses.put("Alice", 40.0);
//         expenses.put("Bob", 40.0);
//         expenses.put("Charlie", 10.0);
//         expenses.put("Don", 10.0);

//         Map<String, Double> balances = BalanceExpense.balanceExpenses(expenses);

//         assertEquals(15.0, balances.get("Bob"));
//         assertEquals(-15.0, balances.get("Don"));
//         assertEquals(15.0, balances.get("Alice"));
//         assertEquals(-15.0, balances.get("Charlie"));
//     }

//     @Test
//     public void test4ppl1PayMore(){
//         Map<String, Double> expenses = new HashMap<>();
//         expenses.put("Alice", 200.0);
//         expenses.put("Bob", 80.0);
//         expenses.put("Charlie", 50.0);
//         expenses.put("Don", 20.0);

//         Map<String, Double> balances = BalanceExpense.balanceExpenses(expenses);

//         assertEquals(-7.50, balances.get("Bob"));
//         assertEquals(-37.50, balances.get("Charlie"));
//         assertEquals(-67.50, balances.get("Don"));
//         assertEquals(112.50, balances.get("Alice"));
//     }

//     @Test
//     public void test4ppl2PayMore(){
//         Map<String, Double> expenses = new HashMap<>();
//         expenses.put("Alice", 160.0);
//         expenses.put("Bob", 120.0);
//         expenses.put("Charlie", 50.0);
//         expenses.put("Don", 20.0);

//         Map<String, Double> balances = BalanceExpense.balanceExpenses(expenses);

//         assertEquals(-67.50, balances.get("Don"));
//         assertEquals(-37.30, balances.get("Charlie"));
//         assertEquals(35.0, balances.get("Alice"));
//         assertEquals(32.50, balances.get("Bob"));
//     }

// }



import java.util.HashMap;
import java.util.Map;

public class BalanceExpenseTest{
    public static void main(String[] args){
        testpersonPay2ppl2dp();
        test1personPay2ppl();
        test4ppl();
        test4pplUnequalPay();
        test4ppl1PayMore();
        test4ppl2PayMore();
    }

    private static void testpersonPay2ppl2dp() {
        Map<String, Double> expenses = new HashMap<>();
        expenses.put("Ali", 40.105);
        expenses.put("Bob", 40.105);
        expenses.put("Charlie", 10.00);

        Map <String, Double> balances = BalanceExpense.balanceExpenses(expenses);

        if (balances.get("Ali") == 10.03 && 
        balances.get("Bob") == 10.04 && 
        balances.get("Charlie") == -20.07){
            System.out.println("Test for 1 person paying 2 people with 2 dp passed");
        }

        else{
            System.out.println("Test for 1 person paying 2 people with 2 dp failed");
        }
    }

    private static void test1personPay2ppl() {
        Map<String, Double> expenses = new HashMap<>();
        expenses.put("Ali", 40.0);
        expenses.put("Bob", 40.0);
        expenses.put("Charlie", 10.00);

        Map <String, Double> balances = BalanceExpense.balanceExpenses(expenses);

        if (balances.get("Ali") == 10.0 && 
        balances.get("Bob") == 10.0 && 
        balances.get("Charlie") == -20.0){
            System.out.println("Test for 1 person paying 2 people passed");
        }
        
        else{
            System.out.println("Test for 1 person paying 2 people failed");
        }
    }

    private static void test4ppl() {
        Map<String, Double> expenses = new HashMap<>();
        expenses.put("Ali", 10.0);
        expenses.put("Bob", 20.0);
        expenses.put("Charlie", 0.0);
        expenses.put("Don", 10.0);

        Map <String, Double> balances = BalanceExpense.balanceExpenses(expenses);

        if (balances.get("Ali") == 0.0 && 
        balances.get("Bob") == 10.0 && 
        balances.get("Charlie") == -10.0 &&
        balances.get("Don") == 0.0){
            System.out.println("Test for 4 people passed");
        }
        
        else{
            System.out.println("Test for 4 people failed");
        }
    }

    private static void test4pplUnequalPay() {
        Map<String, Double> expenses = new HashMap<>();
        expenses.put("Alice", 40.0);
        expenses.put("Bob", 40.0);
        expenses.put("Charlie", 10.0);
        expenses.put("Don", 10.0);

        Map <String, Double> balances = BalanceExpense.balanceExpenses(expenses);

        if (balances.get("Alice") == 15.0 && 
        balances.get("Bob") == 15.0 && 
        balances.get("Charlie") == -15.0 &&
        balances.get("Don") == -15.0){
            System.out.println("Test for 4 people with unequal pay passed");
        }
        
        else{
            System.out.println("Test for 4 people with unequal pay failed");
        }
    }

    private static void test4ppl1PayMore() {
        Map<String, Double> expenses = new HashMap<>();
        expenses.put("Alice", 200.0);
        expenses.put("Bob", 80.0);
        expenses.put("Charlie", 50.0);
        expenses.put("Don", 20.0);

        Map <String, Double> balances = BalanceExpense.balanceExpenses(expenses);

        if (balances.get("Alice") == 112.50 && 
        balances.get("Bob") == -7.50 && 
        balances.get("Charlie") == -37.50 &&
        balances.get("Don") == -67.50){
            System.out.println("Test for 4 people with 1 person paying more passed");
        }
        
        else{
            System.out.println("Test for 4 people with 1 person paying more failed");
        }
    }

    private static void test4ppl2PayMore() {
        Map<String, Double> expenses = new HashMap<>();
        expenses.put("Alice", 160.0);
        expenses.put("Bob", 120.0);
        expenses.put("Charlie", 50.0);
        expenses.put("Don", 20.0);

        Map <String, Double> balances = BalanceExpense.balanceExpenses(expenses);

        if (balances.get("Alice") == 35.0 && 
        balances.get("Bob") == 32.50 && 
        balances.get("Charlie") == -37.30 &&
        balances.get("Don") == -67.50){
            System.out.println("Test for 4 people with 1 person paying more passed");
        }
        
        else{
            System.out.println("Test for 4 people with 1 person paying more failed");
        }
    }
    
}