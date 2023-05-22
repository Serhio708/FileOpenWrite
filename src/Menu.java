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
    public void printColorLine(String color, String line){
        System.out.print((char)27 + color + line + (char)27 + "[0m");
    }
    public void printColorPrompt(String color, String prompt){
        printColorLine(SetColor.lightBlue, leftBorder);
        printColorLine(color, prompt);
        printColorLine(SetColor.lightBlue, rightBorder);
    }
    public void show(){
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
    public void sayHello(){
        printColorLine(SetColor.lightBlue,upperLine);
        printColorPrompt(SetColor.darkBlue, " *  CaesarCipher * ");
        printColorPrompt(SetColor.darkBlue, " *  H E L L O !  * ");
        printColorLine(SetColor.lightBlue,underLine);
    }
    public void sayBye(){
        printColorLine(SetColor.lightBlue,upperLine);
        printColorPrompt(SetColor.darkBlue, " *  CaesarCipher * ");
        printColorPrompt(SetColor.darkBlue, " *  Good Bye!!!  * ");
        printColorLine(SetColor.lightBlue,underLine);
    }
}