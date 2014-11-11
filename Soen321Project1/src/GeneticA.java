package ss321;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class GeneticA {
	
	private ArrayList<Heuristic> heurarry= new ArrayList<Heuristic>();
	private double lowheur;
	public GeneticA(String ciph,int pop, int fitness, int rounds)
	{	
	for(int i=0;i<pop;i++)
	{
		heurarry.add(new Heuristic());
	}	
	while(rounds!=0)
		{
		sortArray();
		crossBreed();
		sortArray();
		mutate();
		--rounds;
		}
	sortArray();
	
	}

	public void mutate()
	{
		Random gen= new Random();
	//Takes the lower have of the fitness functions and does a random mutation.	
		for (int i=heurarry.size()/2;i<heurarry.size();i++) 
		{
		//Nulls the rand chars that will be mutated	
		int rand1=0;
		int rand2=0;
		char char1;
		char char2;
			while (true)
			{
				rand1= gen.nextInt(27);
				rand2= gen.nextInt(27);
				if(rand1!=rand2)
					break;
			}
		char1= heurarry.get(i).getKey(rand1);
		char2= heurarry.get(i).getKey(rand2);
		//Does the mutation
		heurarry.get(i).setKey(rand1, char2);
		heurarry.get(i).setKey(rand2, char1);
		//recalculates the fitness function
		heurarry.get(i).fitnessFunction();
		}
	
	}
	
	public void crossBreed()
	{
		//This method will cross the keys in the hope of finding key
	ArrayList<Heuristic> temp= new ArrayList<Heuristic>();
		for(int i=0;i<heurarry.size();i=+2)
		{
		Heuristic child1 = new Heuristic();
		Heuristic child2= new Heuristic();
			
			//Crossing for the First child
			for(int j=0;j<26;j++)
			{
				//Checks if the Scan for Key is not already there. If it is it then takes the other char val
				if(heurarry.get(i).getKeycount(j)>heurarry.get(i+1).getKeycount(j)&& !child1.scanForKey(heurarry.get(i).getKey(j)))
			
					child1.setKey(j, heurarry.get(i).getKey(j));
				else if (heurarry.get(i).getKeycount(j)>heurarry.get(i+1).getKeycount(j)&& child1.scanForKey(heurarry.get(i).getKey(j)))
					child1.setKey(j, heurarry.get(i+1).getKey(j));
				else if (heurarry.get(i).getKeycount(j)<heurarry.get(i+1).getKeycount(j)&& !child1.scanForKey(heurarry.get(i).getKey(j)))
					child1.setKey(j, heurarry.get(i+1).getKey(j));
				else if (heurarry.get(i).getKeycount(j)<heurarry.get(i+1).getKeycount(j)&& child1.scanForKey(heurarry.get(i).getKey(j)))
					child1.setKey(j, heurarry.get(i).getKey(j));
				else 
					System.out.println("Error in creating first Child");
				
				//Crossing for the Second child
			}
			for(int j=25;j>=0;j--)
			{
				//Checks if the Scan for Key is not already there. If it is it then takes the other char val
				if(heurarry.get(i).getKeycount(j)>heurarry.get(i+1).getKeycount(j)&& !child2.scanForKey(heurarry.get(i).getKey(j)))
					
					child2.setKey(j, heurarry.get(i).getKey(j));
				else if (heurarry.get(i).getKeycount(j)>heurarry.get(i+1).getKeycount(j)&& child2.scanForKey(heurarry.get(i).getKey(j)))
					child2.setKey(j, heurarry.get(i+1).getKey(j));
				else if (heurarry.get(i).getKeycount(j)<heurarry.get(i+1).getKeycount(j)&& !child2.scanForKey(heurarry.get(i).getKey(j)))
					child2.setKey(j, heurarry.get(i+1).getKey(j));
				else if (heurarry.get(i).getKeycount(j)<heurarry.get(i+1).getKeycount(j)&& child2.scanForKey(heurarry.get(i).getKey(j)))
					child2.setKey(j, heurarry.get(i).getKey(j));
				else 
					System.out.println("Error in creating Second Child");
				
			
			}
		//Addding new Children into a temp Arraylist
		child1.fitnessFunction();
		child2.fitnessFunction();
		temp.add(child1);
		temp.add(child2);		
		}
	heurarry= temp;	
	}
	
	public void sortArray()
	{
		Collections.sort(heurarry, new Comparator<Heuristic>() {
		    @Override
		    public int compare(Heuristic heur1, Heuristic heur2) {
		        return Double.compare(heur1.getGlobalheur(), heur1.getGlobalheur());
		    }
		});
	
	}
	
}