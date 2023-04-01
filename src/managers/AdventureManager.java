package managers;

import core.*;
import core.Character;

public class AdventureManager {
	  private String success;

		public int finalWeaponPower(Weapon w){
			return (int) ((w.getPower() * this.rarityMultiplier(w)) + w.getLevel());
		}
	  
		public int characterInfluence(Character c) {
			  return (int) (c.getLevel() * (1 + ((c.getRarity() - 1) / 5 )));
		}
	  
		public float characterSuperiority(Character[] pair) {
		  float influencesum = 0;
		  int   powersum = 0;
		   
		  for (int i = 0; i < 2; i++) {
		    influencesum += this.characterInfluence(pair[i]);
		    if (pair[i].getWeapon() != null) {
		    	powersum += this.finalWeaponPower(pair[i].getWeapon());
		    }
		  }
		    
		  return (powersum * (influencesum / 10));	
		}

	  public int enemySuperiority(Enemy[] e) {
	    int sum = 0;
	    
	    for (int i = 0; i < e.length; i++) {
	    	sum += e[i].getPower();
	    }
	    
	    return sum;
	  }
	  
	  public float rarityMultiplier(Weapon w) {
		  
		  if (w.getRarity() == 1) {
			  return (float) 0.7;
		  }
		  else if (w.getRarity() == 2) {
			  return (float) 0.8;
		  }
		  else if (w.getRarity() == 3) {
			  return (float) 0.9;
		  }
		  else if (w.getRarity() == 4) {
			  return (float) 1.0;
		  }
		  else if (w.getRarity() == 5) {
			  return (float) 1.2;
		  }
		  
		  return 0;
	  }
	  
	  
	  
	  public float elementCombinationMultiplier(Pair p) {
	    float multiplier = 0;

	    if (p.getElementCombination().equals("Normal")) {
	      multiplier = (float) 0.10;
	    }

	    else if (p.getElementCombination().equals("Perfect")) {
	      multiplier = (float) 0.75;
	    }

	    else if (p.getElementCombination().equals("Nice")) {
	      multiplier = (float) 0.50;
	    }

	    else if (p.getElementCombination().equals("Decent")) {
	      multiplier = (float) 0.25;
	    }

	    else if (p.getElementCombination().equals("No")) {
	      multiplier = 0;
	    }

	    else if (p.getElementCombination().equals("Bad")) {
	      multiplier = (float) -0.25;
	    }

	    return multiplier;
	  }

	  public int resourceObtained(Pair p, Character[] characters, int amount) {
	    int sum = 0, increase = 0, powersum = 0;
	    float influencesum = 0;

	    for (int i = 0; i < 2; i++){
	    	influencesum += this.characterInfluence(characters[i]);
	    	if (characters[i].getWeapon() != null) {
		    	powersum += this.finalWeaponPower(characters[i].getWeapon());
		    }
	    }
	    
	    increase = (int) ((int)(amount + (int)(powersum / 24)) * (int)(influencesum / 36) * this.elementCombinationMultiplier(p));
	    sum = (int)(amount + (int)(powersum / 24)) * (int)(influencesum / 36) + increase;

	    return sum;
	  }

	  public void rewardSuccess(Pair p, Character[] characters, int amount, Enemy[] e, Resource r, Inventory inv) {

	    r.increaseAmount(this.resourceObtained(p, characters, amount));
	    if (this.characterSuperiority(characters) > this.enemySuperiority(e)) {
	      this.success = "Successfully Completed";
	      inv.levelPair(characters, 1);
	    }

	    else if ((this.characterSuperiority(characters) / 2) > this.enemySuperiority(e)) {
	      this.success = "Excellently Completed";
	      inv.levelPair(characters, 2);
	    }
	    
	    else {
	      this.success = "Failed";
	    }
	    
	  }
	  
	  public String getSuccessType() {
		  return this.success;
	  }
	  
	  public void displaySummary(Pair p , Character[] characters, int amount, String map, Enemy[] e) {
		  System.out.println("\n-----Adventure Summary-----");
		  System.out.println("Map: " + map);
		  System.out.println("Success Type: " + this.getSuccessType());
		  System.out.println("Character Superiority: " + (int)this.characterSuperiority(characters));
		  System.out.println("Enemy Superiority: " + this.enemySuperiority(e));
		  System.out.println("Elemental Combination: " + p.getElementCombination());
		  System.out.println("Resources Obtained: " + this.resourceObtained(p, characters, amount));
	  
	  }
	  
	  
}