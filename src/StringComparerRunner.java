import java.util.Scanner;

public class StringComparerRunner
{

    public static final String BLANK_SPACE = "                ";

    public static void main(String[] args)
    {
        testNextWord();

        testStripVowels();

        testStripConsonants();

        testComparisons();

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

    }

    public static void testComparisons()
    {
        Scanner keyboardReader = new Scanner(System.in);
        System.out.print("Enter a string to compare: ");
        String userString = keyboardReader.nextLine();
        System.out.print("Enter a second string to compare: ");
        String userString2 = keyboardReader.nextLine();

        StringStripper ss1 = new StringStripper(userString);
        StringStripper ss2 = new StringStripper(userString2);

        CompareOriginalWords(ss1, ss2);

    }

    private static void CompareOriginalWords(StringStripper ss1, StringStripper ss2)
    {
        ss1.resetPointerToStart();
        ss2.resetPointerToStart();
        System.out.println("How many words match?");
        String word1, word2;
        int matchingWords = 0;
        int totalWords = 0;
        while(true)
        {
            word1 = ss1.nextWord();
            word2 = ss2.nextWord();
            if (word1 == null && word2 == null)
                break;

            if (word1 != null && word1.equals(word2))
                matchingWords++;

            printTwoWords(word1, word2);
            totalWords++;
        }
        System.out.println(matchingWords+ " of "+totalWords+" words matched. That's "+((100.0*matchingWords/totalWords))+"%." );
    }

    /**
     * s.o.p's the two words side by side with consistent spacing, even if either word is null and regardless
     * of the length of the first word, up to word1.length > 16.
     * @param word1 - the first word to print
     * @param word2 - the second word to print
     */
    private static void printTwoWords(String word1, String word2)
    {
        if (word1 != null && word1.length()<16)
            System.out.println(word1 + BLANK_SPACE.substring(word1.length())+ word2);
        else
            System.out.println(word1 +"\t\t\t"+ word2);
    }
}