public class StringStripper
{
    private String myString;
    private int pointer;

    public StringStripper(String s)
    {
        myString = s.toLowerCase();
        resetPointerToStart();
    }

    public void resetPointerToStart()
    {
        pointer = 0;
    }

    public String getMyString()
    {   return myString;}

    public String toString()
    {
        StringBuilder resultMaker = new StringBuilder(myString);
        resultMaker.append("\n");
        for (int i=0; i<pointer; i++)
            resultMaker.append(" ");
        resultMaker.append("^");
        return resultMaker.toString();
    }
    /**
     * finds the next word (up to but not including a space) in myString, starting at the pointer,
     * moves the pointer to after the space, and returns that word. If there are no more spaces, returns
     * the remainder of the string and moves the pointer past the end of the string. If the pointer is already
     * past the end of the string returns null instead of the string.
     * @return a substring of myString, between spaces, or null.
     */
    public String nextWord()
    {
        String result = null;
        if (pointer >= myString.length())
            return result;
        int nextSpaceLoc = myString.indexOf(" ",pointer);
        if (nextSpaceLoc == -1)
        {
            result = myString.substring(pointer);
            pointer = myString.length();
        }
        else
        {
            result = myString.substring(pointer, nextSpaceLoc);
            pointer = nextSpaceLoc + 1;
        }
        return result;

    }

    /**
     * Given a string, returns another string consisting of all the non-vowel
     * characters (in their original order).
     * For example:
     * removeVowels("pillow") --> "pllw"
     * removeVowels("queue") --> "q"
     * removeVowels("didn't") --> "ddn't"
     * removeVowels("aeiou") --> ""
     * removeVowels("nth") --> "nth"
     * (Is "y" a vowel? I'll leave that as programmer's choice.)
     * @param source - a String that we wish to clone without vowels
     * @return - a string like source, but with no vowels.
     */
    public String removeVowels(String source)
    {

        StringBuilder resultMaker = new StringBuilder();
        for (int i=0; i<source.length();i++)
        {
            char c = source.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                resultMaker.append(c);
        }
        return resultMaker.toString();
    }

    /**
     * Given a string, returns another string consisting of just the vowel
     * characters (in their original order).
     * For example:
     * removeVowels("pillow") --> "io"
     * removeVowels("queue") --> "ueue"
     * removeVowels("didn't") --> "i"
     * removeVowels("aeiou") --> "aeiou"
     * removeVowels("nth") --> ""
     * (Is "y" a vowel? I'll leave that as programmer's choice.)
     * @param source - a String that we wish to clone just vowels
     * @return - a string like source, but with only vowels.
     */
    public String removeConsonants(String source)
    {
        StringBuilder resultMaker = new StringBuilder();
        for (int i=0; i<source.length();i++)
        {
            char c = source.charAt(i);
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u')
                resultMaker.append(c);
        }
        return resultMaker.toString();
    }

    public String getNextWordWithoutVowels()
    {
        String word = nextWord();
        if (word != null)
            word = removeVowels(word);
        return word;
    }

    public String getNextWordWithoutConsonants()
    {
        String word = nextWord();
        if (word != null)
            word = removeConsonants(word);
        return word;
    }

}
