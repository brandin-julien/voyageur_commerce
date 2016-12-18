package maiin;

import model.Population;

public class Main {

	public static void main(String[] args) {
        Population myPop = new Population();
        int x = 0;
        while(x < 100){
        	if(x == 0)
        		myPop.createSolution(100);
        	else
                myPop.createSolution(50);
        	myPop.mutateList();
        	myPop.calculDistanceOfSolution();
    		myPop.sortList();
    		myPop.selectList();
    		x += 1;
        }
        System.out.println("Les meilleures listes sont:");
        myPop.displayBestList();
	}
}
