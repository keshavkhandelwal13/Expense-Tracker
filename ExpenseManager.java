import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
public class ExpenseManager {

    ArrayList<Expense> expenses = new ArrayList<>();

    void addExpense(String c,double amt) {
        expenses.add(new Expense(c, amt));
        addtoFile();
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
        double sum = 0;
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

        addtoFile();
    }

    boolean isEmpty(){
        return expenses.isEmpty();
    }
    
    void addtoFile(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("expense.txt"));

            for(Expense e : expenses){
            bw.write(e.category + "," + e.amount + "," + e.dateTime);
            bw.newLine();
        }
            bw.close();

        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }

    void loadfromFile(){
        expenses.clear();
        try {
            BufferedReader br = new BufferedReader(new FileReader("expense.txt"));
            String line;
            while((line = br.readLine())!= null){
                String[] parts = line.split(",");
                if (parts.length < 3) continue;

                String category = parts[0];
                double amount = Double.parseDouble(parts[1]);
                LocalDateTime dateTime = LocalDateTime.parse(parts[2]);

                Expense e = new Expense(category, amount, dateTime);
                expenses.add(e);
            }
            br.close();

        } catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
