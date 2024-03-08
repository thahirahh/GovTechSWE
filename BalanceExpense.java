import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalanceExpense{

    public static Map<String,Double> balanceExpenses(Map<String,Double> expenses){
        double totalExpense = 0;                                                       // variable to store total expenses by everyone
                                         // map to store balance owed by each person

        // System.out.println(balances);

        for(double expense : expenses.values()){                                       // calculate total expense by everyone
            totalExpense += expense;
        }

        if (totalExpense == 0){
            throw new IllegalArgumentException("Total expense cannot be zero");
        }

        double averageExpense = totalExpense / expenses.size();       // averagee expense/person

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
        // int numOfTransactions = 0;
        Map<String, Double> creditors = new HashMap<>();
        Map<String, Double> debtors = new HashMap<>();

        // while (!balances.isEmpty()){                                                  // iterate untill all balance sttled
            // String debtor = "";                                                     // person owes money
            // String owedMoney = "";                                                  // person owed money
            // double minDebt = Double.MAX_VALUE;                                        // min debt amt
            // double maxOwed = Double.MIN_VALUE;                                     // max credit amt

        for (Map.Entry<String, Double> entry : balances.entrySet()){
            String person =  entry.getKey();                                     // input person name
            Double balance = entry.getValue();                                   // get balancee

            // if (balance == null){
            //     throw new IllegalArgumentException("Balance amount cannot be null.");
            // }

            if (balance < 0 ){ //if less than 0 , person owes!!!!
                debtors.put(person, balance);
            } else {
                creditors.put(person, balance);
            }
        }

               
                

                // double balanceValue = balance.doubleValue();

                // if (balanceValue < minDebt){                                              // update debtor & minDebt if balance<current minDebt
                //     // debtor = person;
                //     minDebt = balance;
                // }

                // if (balance > maxOwed){                                            //update owedMoney and maxCredit if balance>current maxCredit
                //     // owedMoney = person;
                //     maxOwed = balance;
                // }

            
            // System.out.println("debtors:" + debtors);
            // System.out.println("creditors:" + creditors);
            // Map<String, Double> tempCreditors = new HashMap<>();
            // creditors.putAll(tempCreditors);

            // while (!creditors.isEmpty()){                                                  // iterate untill all creditors sttled
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

            //         balance += debtor.getValue();       //by default, negative balance means debtor owes money
            //         if (balance == 0){                  //ok debt is settled, no more creditor
            //             transactions.add(debtor.getKey() + " pays " + person + "$" + String.format("%.2f", debtor.getValue()));
            //             tempCreditors.remove(person);
            //             debtors.remove(debtor.getKey());
            //         } else if (balance > 0){            //creditor still got balance to get paid, continue the debtor list
            //             transactions.add(debtor.getKey() + " pays " + person + "$" + String.format("%.2f", debtor.getValue()));    // add transaction details to list
            //             tempCreditors.put(person, balance);
            //             debtors.remove(debtor.getKey());
            //         } else {                            //creditor got paid too much, become a debtor
            //             transactions.add(debtor.getKey() + " pays " + person + "$" + String.format("%.2f", creditor.getValue()));    // add transaction details to list
            //             tempCreditors.remove(person);
            //             debtors.put(debtor.getKey(), balance);
            //         }
            //         break;
            //     }
            //     creditors.putAll(tempCreditors);
            // } 

        //     // System.out.println("test minDebt" + minDebt);
        //     // var amount = Math.min(-minDebt, maxOwed);                           // calculate amt to transfer

        //     balances.put(owedMoney, balances.get(owedMoney) - amount);               // update balance aft transaction
        //     balances.put(debtor, balances.get(debtor) + amount);


        //     if (balances.get(debtor) == 0.0){                                        // remove ppl with 0 balance
        //         balances.remove(debtor);
        //     }

        //     if (balances.remove(owedMoney) == 0.0){
        //         balances.remove(owedMoney);
        //     }
        // // }

        transactions.add("Number of transactions: " +  transactions.size());
        return transactions;
    }
}