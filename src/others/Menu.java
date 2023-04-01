package others;


public class Menu {

	public void home() {
		System.out.println("[1] Gacha Machine");
		System.out.println("[2] Open Inventory");
		System.out.println("[3] Upgrades & Equipment");
		System.out.println("[4] Go Adventure");
		System.out.println("[5] Close Program");
	}
	
	public void gachaMachine() {
		System.out.println("[1] Character (1) Roll | 300 Resources");
		System.out.println("[2] Character (10) Roll | 2700 Resources");
		System.out.println("[3] Weapon (1) Roll | 300 Resources");
		System.out.println("[4] Weapon (10) Roll | 2700 Resources");
		System.out.println("[5] Go Back");
	}
	
	public void upgrades() {
		System.out.println("[1] Level Up Character");
		System.out.println("[2] Merge Characters");
		System.out.println("[3] Level Up Weapon");
		System.out.println("[4] Refine Weapon");
		System.out.println("[5] Equip Weapon");
		System.out.println("[6] Unequip Weapon");
		System.out.println("[7] Go Back");
	}
	
	public void mapSelect() {
		System.out.println("[1] Underground Caverns");
		System.out.println("[2] Forest of Enchantments");
		System.out.println("[3] Sea of Hope");
		System.out.println("[4] Tower of Ether");
		System.out.println("[5] Celestial Plane");
		System.out.println("[6] Go Back");
	}
	
	
	
	public void mainHeader() {
		System.out.println("\n-----Welcome to the Gacha Game Simulator!-----");
	}
	
	public void gachaHeader() {
		System.out.println("\n-----Gacha Machine-----");
	}
	
	public void inventoryHeader() {
		System.out.println("\n-----Inventory-----");
	}
	
	public void upgradeHeader() {
		System.out.println("\n-----Upgrades & Equipment-----");
	}
	
	public void mapHeader() {
		System.out.println("\n-----Select Map-----");
	}
	
	
	public void characterHeader() {
		System.out.println("\n-----Character List-----");
		System.out.printf("[N]%-20s|%-10s|%s|%-6s|%-20s\n", "Name", "Element", "R", "Level", "Weapon");
	}
	
	public void weaponHeader() {
		System.out.println("\n-----Weapon List-----");
		System.out.printf("[N]%-20s|%-6s|%s|%-5s|%-6s\n", "Name", "Power", "R", "Level", "Owned");
	}
	

}
