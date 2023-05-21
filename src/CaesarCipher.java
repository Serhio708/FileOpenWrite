/*
public class CaesarCipher - мізки програми, безпосередне кодування-декодування

private char getNewCharacter(String alphabet, char symbol) -
                            вибирає символ з наборів символів класу Letter,
                            кодує якщо code>0, декодує якщо code<0

public String cipher(String message) будує рядок з символів які передає метод getNewCharacter
 */


public class CaesarCipher{
    public int code;
    public CaesarCipher(int code)
    {
        this.code = code;
    }

     private char getNewCharacter(String alphabet, char symbol){
        int tempCode;
        if  (code <0){

            tempCode = alphabet.length() - ((-1)*code % alphabet.length());
        }  else {
            tempCode = code;
        }
        int newPosition = (alphabet.indexOf(symbol) + tempCode) % alphabet.length();
        return alphabet.charAt(newPosition);
    }

    public String cipher(String message) {
        StringBuilder result = new StringBuilder();
        Letter letter = new Letter();
        char nextCharacter;
        for (char currentSymbol : message.toCharArray()) {
            if (letter.isEnglish(currentSymbol)) {
                nextCharacter = getNewCharacter(Letter.abcEnglish, currentSymbol);
            } else if (letter.isUkrainian(currentSymbol)) {
                nextCharacter = getNewCharacter(Letter.abcUkrainian, currentSymbol);
            } else {
                nextCharacter = currentSymbol;
            }
            result.append(nextCharacter);
        }
        return result.toString();
    }
 }



