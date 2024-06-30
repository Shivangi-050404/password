import java.util.Scanner;

public class Generator {
    Alphabet alphabet;
    public static Scanner keyboard;
    public Generator(Scanner sc){
        keyboard=sc;
    }
    public Generator(boolean isUpper,boolean isLower,boolean isNumber,boolean isSpecial){
        alphabet=new Alphabet(isUpper,isLower,isNumber,isSpecial);
    }
    public static void mainLoop(){
   printMenu();
   int choice=0;
   while(choice!=4){
       choice=keyboard.nextInt();
   switch(choice) {
       case 1 ->{
        requestpassword();
        printMenu();
       }
       case 2->{
           checkPassword();
           printMenu();
       }
       case 3-> {
           printUsefulInfo();
           printMenu();
       }
       case 4->printQuitMessage();
       default -> {
           System.out.println();
           System.out.println("Kindly select one of the available commands");
           printMenu();
       }
   }
   }

    }
    private Password generatePassword(int length){
       StringBuilder pass=new StringBuilder("");
     int min=0;
     int max=alphabet.getAlphabet().length()-1;
int range=max-min+1;
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * range) + min;  
            pass.append(alphabet.getAlphabet().charAt(index));
        }
        return new Password(pass.toString());
    }
    private static void printUsefulInfo(){
        System.out.println();
        System.out.println("Use a minimum password length of 8 or more characters if permitted");
        System.out.println("Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
        System.out.println("Generate passwords randomly where feasible");
        System.out.println("Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)");
        System.out.println("Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences," +
                "\nusernames, relative or pet names, romantic links (current or past) " +
                "and biographical information (e.g., ID numbers, ancestors' names or dates).");
        System.out.println("Avoid using information that the user's colleagues and/or " +
                "acquaintances might know to be associated with the user");
        System.out.println("Do not use passwords which consist wholly of any simple combination of the aforementioned weak components");

    }
    private static void requestpassword(){
     boolean IncludeUpper=false;
     boolean IncludeLower=false;
     boolean IncludeNum=false;
     boolean IncludeSym=false;
        boolean correctParams;

        System.out.println();
        System.out.println("Hello, welcome to the Password Generator :) answer"
                + " the following questions by Yes or No \n");

        do {
            String input;
            correctParams = false;

            do {
                System.out.println("Do you want Lowercase letters \"abcd...\" to be used? ");
                input = keyboard.next();
                PasswordRequestError(input);
            } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));

            if (isInclude(input)) IncludeLower = true;

            do {
                System.out.println("Do you want Uppercase letters \"ABCD...\" to be used? ");
                input = keyboard.next();
                PasswordRequestError(input);
            } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));

            if (isInclude(input)) IncludeUpper = true;

            do {
                System.out.println("Do you want Numbers \"1234...\" to be used? ");
                input = keyboard.next();
                PasswordRequestError(input);
            } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));

            if (isInclude(input)) IncludeNum = true;

            do {
                System.out.println("Do you want Symbols \"!@#$...\" to be used? ");
                input = keyboard.next();
                PasswordRequestError(input);
            } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));

            if (isInclude(input)) IncludeSym = true;

            //No Pool Selected
            if (!IncludeUpper && !IncludeLower && !IncludeNum && !IncludeSym) {
                System.out.println("You have selected no characters to generate your " +
                        "password, at least one of your answers should be Yes\n");
                correctParams = true;
            }

        } while (correctParams);

        System.out.println("Great! Now enter the length of the password");
        int length = keyboard.nextInt();

        final Generator generator = new Generator(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
        final Password password = generator.generatePassword(length);

        System.out.println("Your generated password -> " + password);
    }

    private static void printQuitMessage(){
        System.out.println("Here comes the end");
    }
    private static void printMenu(){
        System.out.println();
        System.out.println("Enter your choice from following options");
        System.out.println("Enter 1 To generate password ");
        System.out.println("Enter 2 To check password strength");
        System.out.println("Enter 3  To display useful information");
        System.out.println("Enter 4 to quit the processing");
    }
    private static void checkPassword(){
        System.out.println("Enter the password");
        System.out.println("Check the strength of your password");
        String input=keyboard.next();
        Password pass=new Password(input);
        String message=pass.calculateScore();
        System.out.println(message);
    }
    public static boolean isInclude(String input){
        if(input.equalsIgnoreCase("yes"))
            return true;
        else return false;
    }
    public static void PasswordRequestError(String i){
        if(!i.equalsIgnoreCase("yes")&&!i.equalsIgnoreCase("No"))
            System.out.println("error");
    }
}
