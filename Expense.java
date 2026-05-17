import java.time.LocalDateTime;
class Expense {
    double amount;
    String category;
    LocalDateTime dateTime;

    Expense(String c, double amt){    //for expense (current time) : to show user time in formatted value
        amount = amt;
        category = c;
        dateTime = LocalDateTime.now();
    }

    Expense(String c, double amt, LocalDateTime dt){  //for file(custom time) : to save time into string 
        amount = amt;
        category = c;
        dateTime = dt;
    }
}

