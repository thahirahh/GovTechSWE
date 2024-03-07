import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalanceExpense{

    public static Map<String,Double> balanceExpenses(Map<String,Double> expenses){
        double totalExpense = 0;
        Map<String, Double> balances = new HashMap<>;

        for(double expense : expenses.values()){
            totalExpense += expense;
        }

        double averageExpense = totalExpense / expenses.size();

        for (Map.Entry<String,Double> entry : expenses.entrySet()){
            String person = entry.getKey();
            double amontPaid = entry.getValue();
            double balance = amountPaid - averageExpense;
            balances.put(person,balance);
        }

        return balances;
    }
    
}