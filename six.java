
/**
 * Write a description of six here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class six {
        public int findStopCodon(String dnaStr, int startIndex, String stopCodon){
            int currIndex = dnaStr.indexOf(stopCodon, startIndex+3);
                while (currIndex != -1) {
                    int diff = currIndex - startIndex;
      
                    if (diff % 3 == 0) {
                        return currIndex;
                    }
                    else {currIndex = dnaStr.indexOf(stopCodon, currIndex+1);
      
                    }   
                }
                return dnaStr.length();
                //"found Stop Codon but not in pairs of 3"
            }  


    public void testFindStop(){
        String dna = "xxxyyyxxTAAx";
        int dex = findStopCodon (dna, 0, "TAA");
        if (dex != -1) 
        System.out.println("stop codon found");
        if (dex == -1) System.out.println("no Stop Codon found");
        System.out.println("test finished");
    
    }
    
    public String findGene(String dna, int where){
        int startIndex = dna.indexOf("ATG", where);
            if (startIndex == -1){return "";}
        int taaIndex = findStopCodon (dna, startIndex, "TAA");
        int tagIndex = findStopCodon (dna, startIndex, "TAG");
        int tgaIndex = findStopCodon (dna, startIndex, "TGA");
        int minIndex = 0;
        if (taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)) {minIndex = tgaIndex;}
        else {minIndex = taaIndex;}
        if (minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)) {minIndex = tagIndex;}
        if (minIndex == -1) {return "";}
        //int temp= Math.min(taaIndex, tagIndex);
        //int minIndex = Math.min(temp, tgaIndex);
        //if (minIndex == dna.length()) {
            //return "Null. No Stop Codon";
            return dna.substring(startIndex, minIndex+3);
        }
        
       

        
    

    public void testFindGene () {
        //String gene = "aaabbbGAAaaaTAAbbbTGAaaaTGA";
        //int dex = findStopCodon(dna,0,"TAA");
        //if (dex != -1) System.out.println (findGene(dna));
        
        //System.out.println("Gene is " + findGene(gene));
        String one = "ATFxxxyyyzzzTAAxxxTAGxxx";    
        String two = "xxxATGxxxyyyxxxTAGxxxx";
        String three = "xxxATGxxxyyyuuuTGAxxxTAGxxx";
        String four = "xyyATGxxxTAAyyxxxyuuuTGAxxxTAGxxx";
        String five = "xxxATGxxxyyyxxxbbbxxxx";
        String six = "xxxATGxxxxTAAxxx";

        System.out.println("DNA is: " + one + ". Gene is " + findGene(one,0));
        //System.out.println("DNA is: " + two + ". Gene is " + findGene(two));
        //System.out.println("DNA is: " + three + ". Gene is " + findGene(three));
        //System.out.println("DNA is: " + four + ". Gene is " + findGene(four));
        //System.out.println("DNA is: " + five + ". Gene is " + findGene(five, 0));
    
        //System.out.println("DNA is: " + six + ". Gene is " + findGene(six));}
        //if (currIndex == dnaStr.length()) {return "no Stop Codon found";};
    }
    public void printAllGenes (String dna) {
        int startIndex = 0;
        while (true) {
        String currentGene = findGene(dna, startIndex);
        if (currentGene.isEmpty()) {
            break;
    }
    System.out.println(currentGene);
    startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
    }
}
    
    public void testOn(String dna) {
    System.out.println ("Testing printAll Genees on " + dna);
    printAllGenes (dna);
    }
    
    public void test (){
        testOn ("xxxATGxxxTAAxxxATGxxxTGA");
    }
}


