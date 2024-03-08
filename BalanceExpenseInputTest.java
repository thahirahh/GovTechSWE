import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalanceExpenseInputTest {
    public static void main(String[] args){
        Map<String, Double> expenses = BalanceExpense.getInputExpenses();
        Map<String, Double> balances = BalanceExpense.balanceExpenses(expenses);
        List<String> transactions = BalanceExpense.settleBalances(balances);

        for(String transaction : transactions){
            System.out.println(transaction);
        }
    }
    
}
