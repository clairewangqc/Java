
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
public boolean twoOccurrences(String stringa,String stringb){
        int index1 = stringb.indexOf(stringa);
        
        if (index1 != -1 )
        {int index2 = stringb.indexOf(stringa, index1+1);
            if (index2 != -1)
            {return true;}
        }
        
            else{
            return false;
            
        }
        return false;
      
    }
    
    public void testTwoOccurences () {
        String stringa = "AT";
        String stringb = "AAAATGUOIHYOHATTAAL";
        if (stringb.indexOf(stringa) != -1){
        System.out.println(stringb.substring(stringb.indexOf(stringa)+stringa.length()
        ));}
    
        else{
            System.out.println(stringb);
        }
    }
}
  /*System.out.println("stringa occurs twice in stringb is " + twoOccurrences(stringa,stringb));}*/