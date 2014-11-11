package ss321;
import java.util.*;
import javax.crypto.KeyGenerator;

public class Heuristic {
	
	private double globalheur;
	private static double localheur;
	static HashMap<Character, Double> hm;
	static HashMap<Character, Integer> charCounter;
	static String example = "icnemchzofyxxylfnozdcxrcmcwcexcdnremenxcmk";
	private String ciph;
	private char[] key= new char[26];
	
	
	
	
	public Heuristic()
		{
		globalheur = 0.0;
		localheur  = 0.0;
		hm = new HashMap<Character, Double>();
		charCounter = new HashMap<Character, Integer>();
		this.ciph=ciph;
		for (int i=0;i<26;i++)
		{
			
			boolean unique=false;
			while(unique==false){
			Random r = new Random();
			char c = (char) (r.nextInt(26) + 'a');
			key[i]=c;
			for (int j=0;j<=i;j++)
				{
				if(c==key[j] && i!=j)
					{unique=false;
					break;}
				else
					unique=true;
				}
			}
			
			
		}
		}
	
	
	public void calculateGlobal()
	{
		
		
	}
	
	public static void putCharacters (){
	hm.put('a', new Double(8.167));
	hm.put('b', new Double(1.492));
	hm.put('c', new Double(2.782));
	hm.put('d', new Double(4.253));
	hm.put('e', new Double(12.702));
	hm.put('f', new Double(2.228));
	hm.put('g', new Double(2.015));
	hm.put('h', new Double(6.094));
	hm.put('i', new Double(6.966));
	hm.put('j', new Double(0.153));
	hm.put('k', new Double(0.772));
	hm.put('l', new Double(4.025));
	hm.put('m', new Double(2.406));
	hm.put('n', new Double(6.749));
	hm.put('o', new Double(7.507));
	hm.put('p', new Double(1.929));
	hm.put('q', new Double(0.095));
	hm.put('r', new Double(5.987));
	hm.put('s', new Double(6.327));
	hm.put('t', new Double(9.056));
	hm.put('u', new Double(2.758));
	hm.put('v', new Double(0.978));
	hm.put('w', new Double(2.360));
	hm.put('x', new Double(0.150));
	hm.put('y', new Double(1.974));
	hm.put('z', new Double(0.074));
	}
	
	public static double characterMatch(){
		int counter = 0;
		char[]char_array =example.toCharArray();
		char ch = char_array[counter];
		for (int i = 0; i < example.length(); i++){
			if(charCounter.containsKey(char_array[i]))
            {
                charCounter.put(ch, charCounter.get(ch)+1);
            } 
            else
            {
                charCounter.put(ch, 1);
            }
		}
		for(Character key:charCounter.keySet())
	       {
	           System.out.println(key+""+charCounter.get(key));
	       }
		return localheur = counter/char_array.length;
	}


	public double getGlobalheur() {
		return globalheur;
	}


	public void setGlobalheur(double globalheur) {
		this.globalheur = globalheur;
	}


	public static HashMap<Character, Double> getHm() {
		return hm;
	}


	public static void setHm(HashMap<Character, Double> hm) {
		Heuristic.hm = hm;
	}


	public static HashMap<Character, Integer> getCharCounter() {
		return charCounter;
	}


	public static void setCharCounter(HashMap<Character, Integer> charCounter) {
		Heuristic.charCounter = charCounter;
	}


	public static String getExample() {
		return example;
	}


	public static void setExample(String example) {
		Heuristic.example = example;
	}	
	

	public String getCiph() {
		return ciph;
	}


	public void setCiph(String ciph) {
		this.ciph = ciph;
	}
	public char getKey(int val)
	{
		return key[val];
	}

	public void setKey(int val,char c)
	{
		key[val]=c;
	}
	//Needs to be fixed! Does not currently get the count value of the different keys
	public char getKeycount(int val)
	{
		return key[val];
	}
	public boolean scanForKey(char c)
	{
		for(int i=0;i<26;i++)
		{
			if (key[i]==c)
					return true;
		}
		return false;
		
	}
	public void fitnessFunction()
	{
	//Runs the fitness function again with new Key. Might be removed once fitness function is redone	
		
	}
}
