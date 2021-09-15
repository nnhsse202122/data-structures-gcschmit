import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This program checks which words in a file are not present in a dictionary.
*/
public class WordAnalysis
{
    public static void main(String[] args)
        throws FileNotFoundException
    {
        // read the dictionary and the novel
        Set<String> dictionaryWords = readWords("src/words");
        Set<String> novelWords = readWords("src/throughTheLookingGlass.txt");

        // 1. print all words that are in the novel but not the dictionary

        // the enhanced for loop works with sets
        for(String word : novelWords)
        {
            if(!dictionaryWords.contains(word))
            {
                System.out.println(word);
            }
        }

        System.out.println("unique words: " + novelWords.size());

        // 2. print the number of unique words with > 3 letters
        Iterator<String> i = novelWords.iterator();
        while(i.hasNext())
        {
            if(i.next().length() <= 3)
            {
                i.remove();
            }
        }

        System.out.println("unique words (> 3 letters): " + novelWords.size());
    }

    /**
     * Reads all words from a file.
     *
     * @param filename the name of the file
     * @return a set with all lowercased words in the file. Here, a
     * word is a sequence of upper- and lowercase letters.
    */
    public static Set<String> readWords(String filename)
        throws FileNotFoundException
    {
        /*
            The implementation of the set doesn't matter; so, 
                store the reference in a variable of type Set
        */
        Set<String> words = new HashSet<>();
        Scanner in = new Scanner(new File(filename));

        // use any character other than a-z or A-Z as delimeters
        in.useDelimiter("[^a-zA-Z]");

        while(in.hasNext())
        {
            /*
                adding duplicates to a set is ignored
                    (so is removing elements that don't exist)
            */
            words.add(in.next().toLowerCase());
        }

        return words;
    }
}
