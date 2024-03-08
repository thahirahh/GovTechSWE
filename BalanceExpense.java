import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BalanceExpense{

    public static Map<String,Double> balanceExpenses(Map<String,Double> expenses){
        double totalExpense = 0;                                                       // variable to store total expenses by everyone
                                         
        for(double expense : expenses.values()){                                       // calculate total expense by everyone
            totalExpense += expense;
        }

        if (totalExpense == 0){
            throw new IllegalArgumentException("Total expense cannot be zero");
        }

        double averageExpense = totalExpense / expenses.size();                        // averagee expense/person

        Map<String, Double> balances = new HashMap<>(); 

        for (Map.Entry<String,Double> entry : expenses.entrySet()){                    // calculate balance owed by each person
            String person = entry.getKey();                                            // input name
            Double amountPaid = entry.getValue();                                       // input amt paid by person

            if (amountPaid == null){
                throw new IllegalArgumentException("Expense amount cannot be null.");
            }

            double balance = amountPaid - averageExpense;                              // calculate balance by minus off average expense
            balances.put(person,balance);                                              // store balance in balance map
        }

        return balances;
    }

    public static List<String> settleBalances(Map<String, Double> balances){
        List<String> transactions = new ArrayList<>();                                // list to store transaction details

        Map<String, Double> creditors = new HashMap<>();
        Map<String, Double> debtors = new HashMap<>();

        for (Map.Entry<String, Double> entry : balances.entrySet()){
            String person =  entry.getKey();                                     // input person name
            Double balance = entry.getValue();                                   // get balancee

            if (balance < 0 ){                                                 //if less than 0 , person owes!!!!
                debtors.put(person, balance);
            } else {                                                           // if more than 0, person is owed!!!
                creditors.put(person, balance);
            }
        }

        for (Map.Entry<String, Double> creditor : creditors.entrySet()){
            String Creditorperson =  creditor.getKey();                                     // input person name
            Double Creditorbalance = creditor.getValue();                                   // get balancee

            for (Map.Entry<String, Double> debtor : debtors.entrySet()){
                String Debtorperson = debtor.getKey();
                double Debtorbalance = debtor.getValue();

                double transferAmount = Math.min(-Debtorbalance, Creditorbalance);
                transactions.add(Debtorperson + " pays " + Creditorperson + " $" + String.format("%.2f", transferAmount));

                Creditorbalance -= transferAmount;
                debtors.put(Debtorperson, Debtorbalance + transferAmount);

                if(Creditorbalance == 0){
                    break;
                }
            }
        }

        transactions.add("Number of transactions: " +  transactions.size());
        return transactions;
    }

    public static Map<String, Double> getInputExpenses(){
        Map<String, Double> expenses = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int numOfExpenses;

        System.out.print("Enter the number of expenses: ");
        numOfExpenses = scanner.nextInt();

        for (int i = 0; i < numOfExpenses; i++){
            System.out.print("Enter the name of the person: ");
            String name = scanner.next();

            System.out.print("Enter the amount paid by " + name + ": ");
            double amount = scanner.nextDouble();

            expenses.put(name, amount);
        }

        scanner.close();
        return expenses;
    }
}