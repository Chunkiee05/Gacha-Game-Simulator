package core;

public class Weapon{
  private String  name;
  private int     power;
  private int     rarity;
  private int     level;
  private boolean owned;

  
  public Weapon(int random){

    //RARITY 1
      if (random >= 1 && random <= 10){
        this.name = "Knife";
        this.rarity = 1;
        this.power = 130;
      }

      else if (random >= 11 && random <= 20){
        this.name = "Rapier";
        this.rarity = 1;
        this.power = 140;
      }

      else if (random >= 21 && random <= 30){
        this.name = "Revolver";
        this.rarity = 1;
        this.power = 150;
      }

      else if (random >= 31 && random <= 40){
        this.name = "Mermaid Tears";
        this.rarity = 1;
        this.power = 160;
      }

      else if (random >= 41 && random <= 50){
        this.name = "Clarent";
        this.rarity = 1;
        this.power = 170;
      }
      
      else if (random >= 51 && random <= 60){
        this.name = "English Longbow";
        this.rarity = 1;
        this.power = 180;
      }
    
    //RARITY 2
      else if (random >= 61 && random <= 67){
        this.name = "Circe Staff";
        this.rarity = 2;
        this.power = 150;
      }

      else if (random >= 68 && random <= 74){
        this.name = "Vorpal Sword";
        this.rarity = 2;
        this.power = 160;
      }

      else if (random >= 75 && random <= 81){
        this.name = "Merlin's Staff";
        this.rarity = 2;
        this.power = 170;
      }

      else if (random >= 82 && random <= 88){
        this.name = "Five-cross Sword";
        this.rarity = 2;
        this.power = 180;
      }

      else if (random >= 89 && random <= 95){
        this.name = "Bashosen";
        this.rarity = 2;
        this.power = 190;
      }
      
      else if (random >= 96 && random <= 102){
        this.name = "Golden Cudgel";
        this.rarity = 2;
        this.power = 200;
      }

    //RARITY 3
      else if (random >= 103 && random <= 105){
        this.name = "Philosopher's Stone";
        this.rarity = 3;
        this.power = 180;
      }

      else if (random >= 106 && random <= 108){
        this.name = "Magic Bullets";
        this.rarity = 3;
        this.power = 190;
      }

      else if (random >= 109 && random <= 111){
        this.name = "Fragarach";
        this.rarity = 3;
        this.power = 200;
      }

      else if (random >= 112 && random <= 114){
        this.name = "Honjo Masamune";
        this.rarity = 3;
        this.power = 210;
      }

      else if (random >= 115 && random <= 117){
        this.name = "Excalibur";
        this.rarity = 3;
        this.power = 220;
      }
      
      else if (random >= 118 && random <= 120){
        this.name = "Scythe of Father Time";
        this.rarity = 3;
        this.power = 230;
      }
    
    this.level = 1;
    this.owned = false;
  
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
		if (this.level <= 49) {
			this.level ++;
		}
	}
  }

  public String getName(){
    return this.name;
  }

  public int getPower(){
    return this.power;
  }

  public int getRarity(){
    return this.rarity;
  }

  public int getLevel(){
    return this.level;
  }

  public void setOwned(boolean value){
    this.owned = value;
  }

  public boolean getOwned(){
    return this.owned;
  }
  
  public void displayWeapon(){
	if (this.getOwned() != false) {
		System.out.printf("%-20s|%6d|%d|Lv.%2d|%-6s\n", this.getName(), this.getPower(), this.getRarity(), this.getLevel(), "Yes");
	}
	else {
		System.out.printf("%-20s|%6d|%d|Lv.%2d|%-6s\n", this.getName(), this.getPower(), this.getRarity(), this.getLevel(), "No");
	}
  }

  
}