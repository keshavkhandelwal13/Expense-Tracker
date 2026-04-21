import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
public class ExpenseManager {

    ArrayList<Expense> expenses = new ArrayList<>();

    void addExpense(String c,float amt) {
        expenses.add(new Expense(c, amt));
    }

    void showExpenses() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a");
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }

        for (int i=0 ; i<expenses.size(); i++) {
            Expense e = expenses.get(i); // to change expenses.get(i).category to e.category
            System.out.println(i+1 +" : the category " +e.category +" has: " +e.amount +" amount during: " +e.dateTime.format(formatter));
        } 
    }

    void totalExpense(){
        float sum = 0;
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }
        for(Expense e : expenses){
            sum = sum + e.amount;
        }
        System.out.println("your total expense is: " +sum);
    }

    void removeExpense(int x){

        if(x>=0 && x<expenses.size()){
            expenses.remove(x);
            System.out.println("expense removed");
        }
        else
            System.out.println("invalid index");
    }

    boolean isEmpty(){
        return expenses.isEmpty();
    }
}
