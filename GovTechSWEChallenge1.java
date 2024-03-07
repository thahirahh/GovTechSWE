import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalanceExpense{

    public static Map<String,Double> balanceExpenses(Map<String,Double> expenses){
        double totalExpense = 0;                                                       // variable to store total expenses by everyone
        Map<String, Double> balances = new HashMap<>;                                  // map to store balance owed by each person

        for(double expense : expenses.values()){                                       // calculate total expense by everyone
            totalExpense += expense;
        }

        double averageExpense = totalExpense / expenses.size();                        // averagee expense/person

        for (Map.Entry<String,Double> entry : expenses.entrySet()){                    // calculate balance owed by each person
            String person = entry.getKey();                                            // input name
            double amontPaid = entry.getValue();                                       // input amt paid by person
            double balance = amountPaid - averageExpense;                              // calculate balance by minus off average expense
            balances.put(person,balance);                                              // store balance in balance map
        }

        return balances;
    }

    public static List<String> settleBalances(Map<String, Double> balances){
        List<String> transactions = new ArrayList<>();                                // list to store transaction details

        while (!balances.isEmpty()){                                                  // iterate untill all balance sttled
            String debtor = null;                                                     // person owes money
            String owedMoney = null;                                                  // person owed money
            double minDebt = Double.MAX_VALUE;                                        // min debt amt
            double maxCredit = Double.MIN_VALUE;                                     // max credit amt

            for (Map.Entry<String, Double> entry : balances.entrySet()){
                String person =  entry.getKey();                                     // input person name
                double balance = entry.getValue();                                   // get balancee

                if (balance < minDebt){                                              // update debtor & minDebt if balance<current minDebt
                    debtor = person;
                    minDebt = balance;
                }

                if (balance > maxCredit){                                            //update owedMoney and maxCredit if balance>current maxCredit
                    owedMoney = person;
                    maxCredit = balance;
                }
            }
        }
    }
}