package core;

public class Character{
	  private String name;
	  private int    rarity;
	  private String element;
	  private int    level;
	  private Weapon equipment;

	  public Character() {
		  
	  }
	  	  
	  public Character(int random){

	    //RARITY 1
	      if (random >= 1 && random <= 10){
	        this.name = "Jekyll";
	        this.rarity = 1;
	        this.element = "Joker";
	      }

	      else if (random >= 11 && random <= 20){
	        this.name = "Earl Robert";
	        this.rarity = 1;
	        this.element = "Trigger";
	      }

	      else if (random >= 21 && random <= 30){
	        this.name = "Count d'Artagnan";
	        this.rarity = 1;
	        this.element = "Metal";
	      }

	      else if (random >= 31 && random <= 40){
	        this.name = "Stede";
	        this.rarity = 1;
	        this.element = "Cyclone";
	      }

	      else if (random >= 41 && random <= 50){
	        this.name = "Kaguya";
	        this.rarity = 1;
	        this.element = "Luna";
	      }
	      
	      else if (random >= 51 && random <= 60){
	        this.name = "Van Helmont";
	        this.rarity = 1;
	        this.element = "Heat";
	      }
	    
	    //RARITY 2
	      else if (random >= 61 && random <= 67){
	        this.name = "Gray";
	        this.rarity = 2;
	        this.element = "Joker";
	      }

	      else if (random >= 68 && random <= 74){
	        this.name = "Bonney";
	        this.rarity = 2;
	        this.element = "Trigger";
	      }

	      else if (random >= 75 && random <= 81){
	        this.name = "Sir William Marshal";
	        this.rarity = 2;
	        this.element = "Metal";
	      }

	      else if (random >= 82 && random <= 88){
	        this.name = "Teach";
	        this.rarity = 2;
	        this.element = "Cyclone";
	      }

	      else if (random >= 89 && random <= 95){
	        this.name = "Jeanne";
	        this.rarity = 2;
	        this.element = "Luna";
	      }
	      
	      else if (random >= 96 && random <= 102){
	        this.name = "Paracelsus";
	        this.rarity = 2;
	        this.element = "Heat";
	      }

	    //RARITY 3
	      else if (random >= 103 && random <= 105){
	        this.name = "Faust";
	        this.rarity = 3;
	        this.element = "Joker";
	      }

	      else if (random >= 106 && random <= 108){
	        this.name = "Clyde";
	        this.rarity = 3;
	        this.element = "Trigger";
	      }

	      else if (random >= 109 && random <= 111){
	        this.name = "Masamune";
	        this.rarity = 3;
	        this.element = "Metal";
	      }

	      else if (random >= 112 && random <= 114){
	        this.name = "Avery";
	        this.rarity = 3;
	        this.element = "Cyclone";
	      }

	      else if (random >= 115 && random <= 117){
	        this.name = "Arthur";
	        this.rarity = 3;
	        this.element = "Luna";
	      }
	      
	      else if (random >= 118 && random <= 120){
	        this.name = "Hermes";
	        this.rarity = 3;
	        this.element = "Heat";
	      }
	    
	    this.level = 20;
	  
	  }

	  public void increaseRarity(int amount){
		for (int i = 1; i <= amount; i++) {
			if (this.rarity <= 4) {
				this.rarity++;
			}
		}
	  }

	  public void increaseLevel(int levels){
		for (int i = 1; i <= levels; i++) {
			if (this.level <= 99) {
				this.level ++;
			}
		}
	  }

	  public String getName(){
	    return this.name;
	  }

	  public int getLevel(){
	    return this.level;
	  }

	  public int getRarity(){
	    return this.rarity;
	  }

	  public String getElement(){
	    return this.element;
	  }

	  public Weapon getWeapon(){
	    return this.equipment;
	  }

	  public void equip(Weapon w){
	    this.equipment = w;
	  }
	  
	  public void displayCharacter(){
		if (this.equipment != null) {
			System.out.printf("%-20s|%-10s|%d|Lv.%3d|%-20s\n", this.getName(), this.getElement(), this.getRarity(), this.getLevel(), this.equipment.getName());
		}
		else {
			System.out.printf("%-20s|%-10s|%d|Lv.%3d|%-20s\n", this.getName(), this.getElement(), this.getRarity(), this.getLevel(), "");
		}
	  }


}