import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        ExpenseManager manager = new ExpenseManager();
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.println("select what you want to do:");
            System.out.println("1 : add an expense");
            System.out.println("2 : view your expenses");
            System.out.println("3 : total of your expenses");
            System.out.println("4 : remove the desired expense");
            System.out.println("5 : exit");
            System.out.println("enter your choice:");
            int choice = s.nextInt();
            s.nextLine();
            switch(choice){
                case 1:
                    System.out.println("enter category:");
                    String c = s.nextLine();
                    System.out.println("enter amount:");
                    float amt = s.nextFloat();
                    s.nextLine();
                    manager.addExpense(c,amt);
                    break;

                case 2:
                    manager.showExpenses();
                    break;

                case 3:
                    manager.totalExpense();
                    break;

                case 4:
                    manager.showExpenses();
                    if (manager.isEmpty()) {
                        System.out.println("No expenses to remove.");
                        break;
                    } 
                    System.out.println("enter the expense number you want to remove : ");
                    int expenseNumber = s.nextInt();
                    s.nextLine();
                    System.out.println("you sure you want to remove the expense number : " +expenseNumber + " ? ");
                    System.out.println("answer with yes to continue otherwise type anything");
                    String answer = s.nextLine();
                    if (answer.equals("yes")) {
                        manager.removeExpense(expenseNumber - 1);
                        } else {
                        System.out.println("Deletion cancelled.");
                        }
                        break;

                case 5:
                    System.out.println("exiting");
                    s.close();
                    return;
              
                default : 
                    System.out.println("invalid argument");
            }
        }    
    }
}