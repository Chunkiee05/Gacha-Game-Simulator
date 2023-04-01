package core;

public class Pair {
	  private String combination;
	  private Character[] characters;
	  
	  
	  public Pair() {
		  characters = new Character[2];
	  }
	  
	  
	  
	  public String getElementCombination() {
		  return this.combination;
	  }
	  
	  public void setElementCombination() {
		 // NORMAL PAIRING
		 if (this.characters[0].getElement() == this.characters[1].getElement()) {
			 this.combination = "Normal";
		 }
	
     	// PERFECT PAIRING
		 else if ( (this.hasJoker() && this.hasCyclone()) || (this.hasTrigger() && this.hasLuna()) || (this.hasMetal() && this.hasHeat()) ) {
			 this.combination = "Perfect";
		 }

     	// NICE PAIRING
		 else if ( (this.hasJoker() && this.hasLuna()) || (this.hasJoker() && this.hasHeat()) ) {
			 this.combination = "Nice";
		 }

     	// DECENT PAIRING
		 else if ( (this.hasJoker() && this.hasTrigger()) || (this.hasJoker() && this.hasMetal()) || (this.hasMetal() && this.hasCyclone()) || (this.hasMetal() && this.hasLuna()) ) {
			 this.combination = "Decent";
		 }

     	// NO EFFECT
		 else if ( (this.hasTrigger() && this.hasMetal()) || (this.hasTrigger() && this.hasCyclone()) || (this.hasTrigger() && this.hasHeat()) ) {
			 this.combination = "No";
		 }

     	// BAD PAIRING
		 else if ( (this.hasCyclone() && this.hasLuna()) || (this.hasCyclone() && this.hasHeat()) || (this.hasLuna() && this.hasHeat()) ) {
			 this.combination = "Bad";
		 }
	  }
	  
	  public Character[] getTeam() {
		  return this.characters;
	  }
	  
	  public void setTeam(Character c1, Character c2) {
		  this.characters[0] = c1;
		  this.characters[1] = c2;
		  
		  this.setElementCombination();
	  }
	  
	  public boolean hasJoker() {
		  for (int i = 0; i < 2; i++) {
			  if (this.characters[i].getElement() == "Joker")
				  return true;
		  }
		  
		  return false;
		  
	  }
	  
	  public boolean hasTrigger() {
		  for (int i = 0; i < 2; i++) {
			  if (this.characters[i].getElement() == "Trigger")
				  return true;
		  }
		  
		  return false;
		  
	  }
	  
	  public boolean hasMetal() {
		  for (int i = 0; i < 2; i++) {
			  if (this.characters[i].getElement() == "Metal")
				  return true;
		  }
		  
		  return false;
		  
	  }
	  
	  public boolean hasCyclone() {
		  for (int i = 0; i < 2; i++) {
			  if (this.characters[i].getElement() == "Cyclone")
				  return true;
		  }
		  
		  return false;
		  
	  }
	  
	  public boolean hasLuna() {
		  for (int i = 0; i < 2; i++) {
			  if (this.characters[i].getElement() == "Luna")
				  return true;
		  }
		  
		  return false;
		  
	  }
	  
	  public boolean hasHeat() {
		  for (int i = 0; i < 2; i++) {
			  if (this.characters[i].getElement() == "Heat")
				  return true;
		  }
		  
		  return false;
		  
	  }
	  
	  
		
}
