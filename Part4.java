
/**
 * 
 * print("hello, my name is \"Nick Clarke\"")
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import edu.duke.URLResource;
public class Part4 {
    public void printUrls (){
        URLResource file = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        for (String word : file.words ()){
            String wordLower = word.toLowerCase();
            int pos = wordLower.indexOf("youtube.com");
            if (pos != -1){
        int beg = word.lastIndexOf("\"",pos-6);
        int end = word.indexOf("\"", pos+1);
        {System.out.println(word.substring(beg+1, end));}
    }
}
}
}
