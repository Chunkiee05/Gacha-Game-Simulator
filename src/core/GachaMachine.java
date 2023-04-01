package core;

import java.util.Random;

import others.ResourceChecker;

public class GachaMachine {
	  public int numberGenerator(){
	    Random number;
	    number = new Random();
	    return number.nextInt(120) + 1;
	  }
	
	  public Character singleCharacterPull(Resource r){
		ResourceChecker rchecker = new ResourceChecker();

	    if (rchecker.isResourceSufficient(300, r)) {
		    r.decreaseAmount(300);
	    	int value = numberGenerator();
		    Character pull = new Character(value);
		    System.out.println("\nYou pulled " + pull.getRarity() + "-Rarity " + pull.getName());
		    return pull;
	    }
	    
	    else {
	    	System.out.println("\nNot Enough Resources!");
	    	return null;
	    }
	    	
	  }
	
	  public Character[] tenCharacterPull(Resource r){
	    ResourceChecker rchecker = new ResourceChecker();
	    
	    if (rchecker.isResourceSufficient(2700, r)) {
		    r.increaseAmount(300);
	    	Character pulls[] = new Character[10];
		    
	    	for (int i = 0; i < 10; i++){
		      pulls[i] = this.singleCharacterPull(r);
		    }
		    return pulls;
	    }
	    
	    else {
	    	System.out.println("\nNot Enough Resources!");
	    	return null;
	    }
	    
	  }
	
	  public Weapon singleWeaponPull(Resource r){
		ResourceChecker rchecker = new ResourceChecker();
		
		if (rchecker.isResourceSufficient(300, r)) {
			r.decreaseAmount(300);
		    int value = numberGenerator();
		    Weapon pull = new Weapon(value);
		    System.out.println("\nYou pulled " + pull.getRarity() + "-Rarity " + pull.getName());
		    return pull;
		}
		
		else {
	    	System.out.println("\nNot Enough Resources!");
	    	return null;
	    }
		
	  }
	
	  public Weapon[] tenWeaponPull(Resource r){
		ResourceChecker rchecker = new ResourceChecker();
		  
		if (rchecker.isResourceSufficient(2700, r)) {
			r.increaseAmount(300);
			Weapon pulls[] = new Weapon[10];
	    
		    for (int i = 0; i < 10; i++){
		      pulls[i] = singleWeaponPull(r);
		    }
		    return pulls;
		}
		
		else {
	    	System.out.println("\nNot Enough Resources!");
	    	return null;
	    }
		
	  }
}