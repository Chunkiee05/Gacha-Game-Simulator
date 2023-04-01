package managers;

import core.Character;
import core.Weapon;

public class EquipmentManager{

	  public void equip(Character c, Weapon w){

	    if (w.getOwned() == false && c.getWeapon() == null){
	      c.equip(w);
	      w.setOwned(true);
	    }
	    else if (w.getOwned() == true)
	      System.out.println("\nWeapon already equipped!");
	    else if (c.getWeapon() != null) {
	      System.out.println("\nCharacter already has a Weapon!");
	    }
	  }

	  public void unequip(Character c){
		if (c.getWeapon() != null) {
			this.unowned(c.getWeapon());
			c.equip(null);
		}

	  }
	  
	  public void unowned(Weapon w) {
		  w.setOwned(false);
	  }
}
