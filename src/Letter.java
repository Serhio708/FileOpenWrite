/*
class Letter визначає набори символів для кодування/ розкодування
public static final String abcEnglish - набір латиниці + спецсимволи включно.
                                        Також додано пробіл для роботи brute_force
public static final String abcUkrainian - набір кирилиці

public boolean isEnglish(char character) - перевіряє належність до набору abcEnglish
public boolean isUkrainian(char character) - перевіряє належність до набору abcUkrainian
*/
public class Letter {
    public static final String abcEnglish ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ.,?!-:' ";
    public static final String abcUkrainian ="абвгґдеєжзиіїйклмнопрстуфхцчшщьюяАБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ";
    public boolean isEnglish(char character){return abcEnglish.indexOf(character) >= 0;}
    public boolean isUkrainian(char character){ return abcUkrainian.indexOf(character) >= 0;}
}
