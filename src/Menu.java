/*
public class Menu - набір констант та методів для виводу текстових повідомлень

public void printColorLine(String color, String line) виводить текст вказаного кольору

public void printColorPrompt(String color, String prompt) виводить кольоровий рядок меню з текстом

public void show() виводить меню користувача на чотири рядка

public void sayHello() виводить початкове привітання

public void sayBye() виводить текстове завершення
 */
public class Menu {
    public static final String leftBorder = "*   ";
    public static final String rightBorder = "    *\n";
    public static final String underLine = "****************************\n";
    public static final String upperLine = "\n****************************\n";
    // не працює з консолі
    /*  public void printColorLine(String color, String line){
        System.out.print((char)27 + color + line + (char)27 + "[0m");
    } */
    /*public void printColorPrompt(String color, String prompt){
        printColorLine(SetColor.lightBlue, leftBorder);
        printColorLine(color, prompt);
        printColorLine(SetColor.lightBlue, rightBorder);
    }*/
      public void printColorLine(String line){
        System.out.print(line);
    }

    public void printColorPrompt(String prompt) {
        printColorLine(leftBorder);
        printColorLine(prompt);
        printColorLine(rightBorder);
    }
    // не працює з консолі
    /*public void show(){
        printColorLine(SetColor.lightBlue,upperLine);
        printColorPrompt(SetColor.darkBlue, " *  CaesarCipher * ");
        printColorPrompt(SetColor.darkBlue, " Choices available:");
        printColorPrompt(SetColor.Yellow, "ENCRYPT       --> 1");
        printColorPrompt(SetColor.Green, "DECRYPT       --> 2");
        printColorPrompt(SetColor.Magenta, "BRUTE_FORCE   --> 3");
        printColorPrompt(SetColor.Red, "EXIT          --> 4");
        printColorLine(SetColor.lightBlue,underLine);
        printColorLine(SetColor.darkBlue, " --> Make a choice --> ");
    }
    */
    // не працює з консолі
    public void show(){
        printColorLine(upperLine);
        printColorPrompt(" *  CaesarCipher * ");
        printColorPrompt(" Choices available:");
        printColorPrompt("ENCRYPT       --> 1");
        printColorPrompt("DECRYPT       --> 2");
        printColorPrompt("BRUTE_FORCE   --> 3");
        printColorPrompt("EXIT          --> 4");
        printColorLine(underLine);
        printColorLine(" --> Make a choice --> ");
    }
    // не працюе з консолі
    /* public void sayHello(){
        printColorLine(SetColor.lightBlue,upperLine);
        printColorPrompt(SetColor.darkBlue, " *  CaesarCipher * ");
        printColorPrompt(SetColor.darkBlue, " *  H E L L O !  * ");
        printColorLine(SetColor.lightBlue,underLine);
    } */

     public void sayHello(){
        printColorLine(upperLine);
        printColorPrompt(" *  CaesarCipher * ");
        printColorPrompt(" *  H E L L O !  * ");
        printColorLine(underLine);
    }
// не працюе з консолі
    /*  public void sayBye(){
        printColorLine(SetColor.lightBlue,upperLine);
        printColorPrompt(SetColor.darkBlue, " *  CaesarCipher * ");
        printColorPrompt(SetColor.darkBlue, " *  Good Bye!!!  * ");
        printColorLine(SetColor.lightBlue,underLine);
    } */
      public void sayBye(){
        printColorLine(upperLine);
        printColorPrompt(" *  CaesarCipher * ");
        printColorPrompt(" *  Good Bye!!!  * ");
        printColorLine(underLine);
    }
}