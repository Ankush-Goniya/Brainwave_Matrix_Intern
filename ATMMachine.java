import java.util.Scanner;

public class ATMMachine {

    public static void main(String[] args) {
        int balance=100000;
        int pin=1345;
        boolean authenticated=false;
        int attempt=0;
        Scanner sc=new Scanner(System.in);

        //to enter the value
        System.out.println("welcome to ATM machine...");
        while(attempt<=3){
            System.out.println("please enter your pin :");
            int enterpin=sc.nextInt();


            attempt++;
            if(enterpin==pin){
                authenticated=true;
                break;
            }
            else{
                System.out.println("Please enter valid pin: ");
            }
        }
       if(!authenticated){
           System.out.println("Your card is blocked: ");
           return;
       }
        while(true){
            System.out.println("\n Main Menu");
            System.out.println(" 1. Check Balance ");
            System.out.println(" 2. Withdraw Balance ");
            System.out.println(" 3. Deposite Balance ");
            System.out.println(" 4. Exit ");

            System.out.println("\n please choose Your Option : ");
            int chooseOption=sc.nextInt();

            switch (chooseOption){
                case 1:
                    System.out.println("Your Balance is->"+balance);
                    break;
                case 2:
                    System.out.println("Enter Amount To Withdraw :");
                    int withdrawamount=sc.nextInt();
                    if(withdrawamount>balance){
                        System.out.println("Balance is not Sufficient !!");
                    }
                 else if (withdrawamount<=0){
                        System.out.println("Please Enter right amount :");
                    }else {
                     balance=balance-withdrawamount;
                        System.out.println("Transcation  successfull!!\n Your balance is :"+balance);
                        break;
                    }
                case 3:
                    System.out.println("Please Add Amount :");
                    int depositamount=sc.nextInt();
                    if(depositamount<=0){
                        System.out.println("please Enter Valid Amount :");
                    }else {
                        balance=depositamount+balance;
                        System.out.println("Add Balance Successfully \n Your Current Amount is :"+balance);
                    }
                        break;
                case 4:
                    System.out.println("Thank You Visit For ATM Machine ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please Enter Valid Option :");
            }
        }
    }
}
