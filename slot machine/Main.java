import java.util.* ;

public class Main {
    
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        double balance = 100 ;
        double bet ;
        String playing = "Y";

        System.out.println("****************************");
        System.out.println("WELCOME TO THE SLOT MACHINE !!");
        System.out.println("****************************");
   
        String[] slots = {"_","X" , "*","$"};
        System.out.println("your current balance is : $"+balance);
        
        
        while(playing.equalsIgnoreCase("Y")){
        System.out.print("enter your bet amount :");    
        bet = sc.nextDouble();
        sc.nextLine();
        if(bet > balance){
            System.out.println("insufficient balance");
        }
        else {
            balance -= bet ;
          balance =   slotmachine(bet , slots , balance );
        }
        System.out.print("Your balance is : "+balance);
        System.out.print("do you want to play again ? (Y/N) :");
        playing = sc.nextLine();

        }
        




    }

    static double slotmachine(double bet , String[] slots , double balance ){
        Random random = new Random();
        String[] result = new String[3];
    System.out.println();
    System.out.println("***************************************************");
    for(int i = 0 ; i < 3 ; i++){
        int pull = random.nextInt(slots.length);
        result[i] = slots[pull];
        System.out.print(" "+slots[pull]+" |");
    }  
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
    if(result[0].equals(result[1]) && result[1].equals(result[2])){
        switch (result[0]) {
            case "_" :{
                System.out.println("you won !!");
                return balance = balance + bet*3;
            } 
                
            case "X" :{
                System.out.println("you won !!");
                return balance = balance + bet*0;
            }
             
            case "$" :{
                System.out.println("you won !!");
               return  balance = balance + bet*10;
            } 

            case "*" :{
                System.out.println("you won !!");
               return  balance = balance + bet*5;
            } 
        }
    }

    else if(result[0].equals(result[1]) || result[1].equals(result[2]) || result[0].equals(result[2])){

        switch (result[0]) {
            case "_" :{
                System.out.println("you won !!");
               return  balance = balance + bet*1;
            } 
                

            case "X" :{
                System.out.println("you won !!........... SIKEEEEEEEEEEEEEEEEEE");
               return  balance = balance + (bet)*0;
            }

            case "$" :{
                System.out.println("you won !!");
               return  balance = balance + bet*5;
            } 

            case "*" :{
                System.out.println("you won !!");
              return   balance = balance + bet*3;
            } 
         
        }
    }
    else{
        System.out.println("you lost !!");
    }
    return balance;
    }
}
