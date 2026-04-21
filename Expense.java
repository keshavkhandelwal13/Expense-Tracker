import java.time.LocalDateTime;
class Expense {
    float amount;
    String category;
    LocalDateTime dateTime;

    Expense(String c, float amt){
        amount = amt;
        category = c;
        dateTime = LocalDateTime.now();
    }
}

