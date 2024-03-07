import java.util.HashMap;
import java.util.Map;
import java.util.List;

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

        List <String> transactions = BalanceExpense.settleBalances(balances);
        for (String transaction : transactions){
            System.out.println(transaction);
        }

        System.out.println();

        // assert balances.get("Ali") == 10.03;
        // assert balances.get("Bob") == 10.04;
        // assert balances.get("Charlie") == -20.07;
        
    }

    private static void test1personPay2ppl() {
        Map<String, Double> expenses = new HashMap<>();
        expenses.put("Ali", 40.0);
        expenses.put("Bob", 40.0);
        expenses.put("Charlie", 10.00);

        Map <String, Double> balances = BalanceExpense.balanceExpenses(expenses);
        
        List <String> transactions = BalanceExpense.settleBalances(balances);
        for (String transaction : transactions){
            System.out.println(transaction);
        }

        System.out.println();
        // assert balances.get("Ali") == 10.0;
        // assert balances.get("Bob") == 10.0;
        // assert balances.get("Charlie") == -20.0;
        
    }

    private static void test4ppl() {
        Map<String, Double> expenses = new HashMap<>();
        expenses.put("Ali", 10.0);
        expenses.put("Bob", 20.0);
        expenses.put("Charlie", 0.0);
        expenses.put("Don", 10.0);

        Map <String, Double> balances = BalanceExpense.balanceExpenses(expenses);
        
        List <String> transactions = BalanceExpense.settleBalances(balances);
        for (String transaction : transactions){
            System.out.println(transaction);
        }

        System.out.println();
        // assert balances.get("Ali") == 0.0;
        // assert balances.get("Bob") == 10.0;
        // assert balances.get("Charlie") == -10.0;
        // assert balances.get("Don") == 0.0;
        
    }

    private static void test4pplUnequalPay() {
        Map<String, Double> expenses = new HashMap<>();
        expenses.put("Alice", 40.0);
        expenses.put("Bob", 40.0);
        expenses.put("Charlie", 10.0);
        expenses.put("Don", 10.0);

        Map <String, Double> balances = BalanceExpense.balanceExpenses(expenses);
        
        List <String> transactions = BalanceExpense.settleBalances(balances);
        for (String transaction : transactions){
            System.out.println(transaction);
        }

        System.out.println();
        // assert balances.get("Alice") == 15.0;
        // assert balances.get("Bob") == 15.0;
        // assert balances.get("Charlie") == -15.0;
        // assert balances.get("Don") == -15.0;
        
    }

    private static void test4ppl1PayMore() {
        Map<String, Double> expenses = new HashMap<>();
        expenses.put("Alice", 200.0);
        expenses.put("Bob", 80.0);
        expenses.put("Charlie", 50.0);
        expenses.put("Don", 20.0);

        Map <String, Double> balances = BalanceExpense.balanceExpenses(expenses);
        
        List <String> transactions = BalanceExpense.settleBalances(balances);
        for (String transaction : transactions){
            System.out.println(transaction);
        }

        System.out.println();
        // assert balances.get("Alice") == 112.50;
        // assert balances.get("Bob") == -7.50;
        // assert balances.get("Charlie") == -37.50;
        // assert balances.get("Don") == -67.50;

    }

    private static void test4ppl2PayMore() {
        Map<String, Double> expenses = new HashMap<>();
        expenses.put("Alice", 160.0);
        expenses.put("Bob", 120.0);
        expenses.put("Charlie", 50.0);
        expenses.put("Don", 20.0);

        Map <String, Double> balances = BalanceExpense.balanceExpenses(expenses);
        
        List <String> transactions = BalanceExpense.settleBalances(balances);
        for (String transaction : transactions){
            System.out.println(transaction);
        }

        System.out.println();
        // assert balances.get("Alice") == 35.0;
        // assert balances.get("Bob") == 32.50;
        // assert balances.get("Charlie") == -37.30;
        // assert balances.get("Don") == -67.50;
    }
    
}