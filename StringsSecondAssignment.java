
/**
 * Write a description of StringsSecondAssignment here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class StringsSecondAssignment {
    
    public int findStopCodon (String dna, int startIndex, String stopCodon) {
        int currIndex = dna.indexOf(stopCodon, startIndex+3);
        int diff = currIndex - startIndex;
        while (currIndex !=-1) {
            if (diff % 3 == 0 ) {
                return currIndex;}
            else {currIndex = dna.indexOf(stopCodon, currIndex+1);
            System.out.println("not in pairs of 3");
        }
    }
    
    //System.out.println(currIndex);
    return -1;
}

    public void testFindStopCodon () {
        String dna1 = "xxxyyy00xxx";
        String dna2 = "xxxyyypppTAA";
        String dna3 = "xxxyyy9TAA";
        int dex1 = findStopCodon (dna1, 0, "TAA");
        int dex2 = findStopCodon (dna2, 0, "TAA");
        int dex3 = findStopCodon (dna3, 0, "TAA");
        if (dex1 != -1)
        {//System.out.println (dna1.substring (0, dex1+3));
        //System.out.println (dna2.substring (0, dex2+3));
        System.out.println (dna1.substring (0, dex1+3));}
       
        if (dex1 == dna1.length()) 
        System.out.println ("not in pairs of 3");
        //else System.out.println ("no stop codon");
       
    }
    
    public String findGene (String dna, int where) {
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1) {return "";}
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int minIndex = 0;
        if (taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)) {minIndex = tgaIndex;}
        else {minIndex = taaIndex;}
        if (minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)) {minIndex = tagIndex;}
        if (minIndex == -1) {return "";}
    return dna.substring(startIndex,minIndex+3);
    }
    
    public int howMany (String dna) {
        
        int start = 0;
        //int pos = stringb.indexOf (stringa);
        int totalGene =0;
        while (true) 
        {
            String gene = findGene (dna, start);
            if (gene.isEmpty()){
            break;}
            
            totalGene++;
         //pos = pos + stringa.length();
         //count = count+1;
         //if (where == -1) {break;}
         start = dna.indexOf(gene,start) + gene.length();
           }
           
           return totalGene;
           
           
        
       
        }
       
    
    
    
    public void testHowMany () {
        String dna = "ATGTAAATGTAGATGTAGATGTGA";
        System.out.println ("the number of genes is " + howMany (dna));
        
        
    }
    
    public void testFindGene () {
        String one = "ATFxxxyyyzzzTAAxxxTAGxxx";    
        String two = "xxxATGxxxyyyxxxTAGxxxx";
        String three = "xxxATGxxxyyyuuuTGAxxxTAGxxx";
        String four = "xyyATGxxxTAAyyxxxyuuuTGAxxxTAGxxx";
        String five = "xxxATGxxxyyyxxxbbbxxxx";
        System.out.println("DNA is: " + one + ". Gene is " + findGene(one,0));
        System.out.println("DNA is: " + one + ". Gene is " + findGene(two,0));
        System.out.println("DNA is: " + one + ". Gene is " + findGene(three,0));
        System.out.println("DNA is: " + one + ". Gene is " + findGene(four,0));
        System.out.println("DNA is: " + one + ". Gene is " + findGene(five,0));
    }
   
    
    public StorageResource getAllGenes (String dna) {
        StorageResource geneList = new StorageResource();
        String one = "xxxATGxxxATTxxxATGxxxTAG";
        int startIndex = 0;
        while (true){
        String currentGene = findGene (dna, startIndex);
        if (currentGene.isEmpty()) {break;}
        //System.out.println(currentGene);
        geneList.add(currentGene);
        startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
    }
        return geneList;
    }
    
    public void testOn(String dna) {
    System.out.println ("Testing printAll Genees on " + dna);
    StorageResource genes = getAllGenes(dna);
    for (String g: genes.data()) {System.out.println (g);}
    
    }
    
    public void test (){
        testOn ("xxxATGxxxTAAxxxATGxxxTGA");
    }
}
