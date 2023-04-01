package managers;

import core.Character;
import core.Resource;
import core.Weapon;
import others.ResourceChecker;

public class LevelManager{
	  
	  public void characterLevelUp(Character c, Resource r, int count){
	    ResourceChecker rchecker = new ResourceChecker();

	    if (rchecker.isResourceSufficient(count, r)){
		    for (int i = 1; i <= count; i++){
		        c.increaseLevel(1);
		        if (c.getLevel() < 100) {
		        	r.decreaseAmount(1);
		        }
		    }
		    System.out.println('\n' + c.getName() + " is now Lv." + c.getLevel() + "!");
	    }
	    
	    else {
	    	System.out.println("\nNot Enough Resources!");
	    }
	    	
	  }

	  public void weaponLevelUp(Weapon w, Resource r, int count){
	    ResourceChecker rchecker = new ResourceChecker();

	    if (rchecker.isResourceSufficient(count, r)){
		    for (int i = 1; i <= count; i++){
			        w.increaseLevel(1);
			        if (w.getLevel() < 50) {
			        	r.decreaseAmount(1);
			        }
		        }
		      
		    System.out.println('\n' + w.getName() + " is now Lv." + w.getLevel() + "!");
	    }
	    
	    else {
	    	System.out.println("\nNot Enough Resources!");
	    }
	  }
}