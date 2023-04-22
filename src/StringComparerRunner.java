import java.util.Scanner;

public class StringComparerRunner
{
    public static void main(String[] args)
    {
        testNextWord();

        testStripVowels();

        testStripConsonants();


    }

    public static void testNextWord()
    {
        System.out.println("Testing next word method");
        StringStripper ss = new StringStripper("The quick brown fox jumps over the lazy dog.");
        System.out.println("String stripper starts as:");
        System.out.println(ss);
        for (int i=0; i<10; i++)
        {
            System.out.println("-----------------");
            System.out.println("nextWord() gives ["+ss.nextWord()+"]");
            System.out.println("Now string stripper is:");
            System.out.println(ss);
        }
    }

    public static void testStripVowels()
    {
        System.out.println("================= Testing strip vowels");
        StringStripper ss = new StringStripper("She sells sea shells by the seashore.");
        String lastWord = "";
        ss.resetPointerToStart();
        while (lastWord != null)
        {
            lastWord = ss.getNextWordWithoutVowels();
            System.out.println(ss);
            System.out.println(lastWord+"\n-----------");
        }
    }

    public static void testStripConsonants()
    {
        StringStripper ss = new StringStripper("If on a winter's night a traveller...");
        System.out.println("================= Testing strip consonants");
        String lastWord = "";
        ss.resetPointerToStart();
        while (lastWord != null)
        {
            lastWord = ss.getNextWordWithoutConsonants();
            System.out.println(ss);
            System.out.println(lastWord+"\n-----------");
        }
        Scanner keyboardReader = new Scanner(System.in);
        System.out.print("Enter a string to compare: ");
        String userString = keyboardReader.nextLine();
        System.out.println("Enter a second string to compare: ");
        String userString2 = keyboardReader.nextLine();
    }
}