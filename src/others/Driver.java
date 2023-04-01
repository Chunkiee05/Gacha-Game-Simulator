package others;
import java.util.*;

import core.*;
import core.Character;
import core.Map;
import managers.*;

public class Driver {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		Menu display = new Menu();
		Inventory inventory = new Inventory();
		GachaMachine gacha = new GachaMachine(); Character cpull; Character[] cpulls = new Character[10];Weapon wpull; Weapon[] wpulls = new Weapon[10];
		LevelManager levels = new LevelManager(); MergingManager merge = new MergingManager(); EquipmentManager equip = new EquipmentManager(); AdventureManager adventure = new AdventureManager();
		Pair pair = new Pair();
		int option, c, c1, c2, c3, w, w1, w2, w3;
		
		
		do {
			display.mainHeader();
			display.home();
			System.out.printf("\nSelect Option: ");
			option = Integer.parseInt(sc.nextLine());
			
			switch(option) {
				case 1: // Gacha Machine
					do {
						display.gachaHeader();
						display.gachaMachine();
						inventory.displayResources();
						System.out.printf("\nSelect Option: ");
						option = Integer.parseInt(sc.nextLine());
					
						switch(option) {
							case 1:// Single Pull Character
								cpull = gacha.singleCharacterPull(inventory.getResource());
								
								if (cpull != null) {
									inventory.storeCharacter(cpull);
								}
								break;
							case 2:// Ten Pull Character
								cpulls = gacha.tenCharacterPull(inventory.getResource());
								
								if (cpulls != null) {
									inventory.storeCharacters(cpulls);
								}
								break;
							case 3:// Single Pull Weapon
								wpull = gacha.singleWeaponPull(inventory.getResource());
								
								if (wpull != null) {
									inventory.storeWeapon(wpull);
								}
								break;
							case 4:// Ten Pull Weapon
								wpulls = gacha.tenWeaponPull(inventory.getResource());
								
								if (wpulls != null) {
									inventory.storeWeapons(wpulls);
								}
								break;
							
							case 5://Go Back
								break;
								
							default:
								System.out.println("\nInvalid Input!");
								break;
						}
					
					}while(option != 5);
					
					option = 0;
					break;
					
				case 2: // View Inventory
					display.inventoryHeader();
					display.characterHeader();
					inventory.displayCharacters();
					display.weaponHeader();
					inventory.displayWeapons();
					inventory.displayResources();
					option = 0;
					break;
					
				case 3: // Upgrades and Equipment
					do {
						display.upgradeHeader();
						display.upgrades();
						inventory.displayResources();
						System.out.printf("\nSelect Option: ");
						option = Integer.parseInt(sc.nextLine());
						
						switch(option) {
							case 1:// Level Character
								display.characterHeader();
								inventory.displayCharacters();
								System.out.printf("\nSelect Character: ");
								c = Integer.parseInt(sc.nextLine());
								
								if (c > 0) {
									if (inventory.getCharacter(c - 1) != null) {
										System.out.printf("Enter Number of Levels: ");
										int l = Integer.parseInt(sc.nextLine());
										levels.characterLevelUp(inventory.getCharacter(c - 1), inventory.getResource(), l);
									}
								}
								else {
									System.out.println("\nCharacter does not exist");
								}
								
								break;
								
							case 2:// Merge Character
								display.characterHeader();
								inventory.displayCharacters();
								System.out.printf("\nSelect Main Character: ");
								c1 = Integer.parseInt(sc.nextLine());
								System.out.printf("Select Material Character 1: ");
								c2 = Integer.parseInt(sc.nextLine());
								System.out.printf("Select Material Character 2: ");
								c3 = Integer.parseInt(sc.nextLine());
								
								if (c1 > 0 && c2 > 0 && c3 > 0) {
									if (inventory.getCharacter(c1 - 1) != null && inventory.getCharacter(c2 - 1) != null && inventory.getCharacter(c3 - 1) != null) {
										if ((c1 != c2) && (c1 != c3) && (c2 != c3)) {
											merge.mergeCharacters(inventory.getCharacter(c1 - 1), inventory.getCharacter(c2 - 1), inventory.getCharacter(c3 - 1), inventory);
	
										}
										
										else {
											System.out.println("\nCannot be the same character!");
										}
									}
									else {
										System.out.println("\nCharacter/s does not exist");
									}
								}
								else {
									System.out.println("\nCharacter/s does not exist");
								}
								
								break;
							case 3:// Level Weapon
								display.weaponHeader();
								inventory.displayWeapons();
								System.out.printf("\nSelect Weapon: ");
								w = Integer.parseInt(sc.nextLine());
								
								if (w > 0) {
									if (inventory.getWeapon(w - 1) != null) {
										System.out.printf("Enter Number of Levels: ");
										int l = Integer.parseInt(sc.nextLine());
										levels.weaponLevelUp(inventory.getWeapon(w - 1), inventory.getResource(), l);
									}
								}
								
								else {
									System.out.println("\nWeapon does not exist");
								}
								
								break;
								
							case 4:// Merge Weapon
								display.weaponHeader();
								inventory.displayWeapons();
								System.out.printf("\nSelect Main Weapon: ");
								w1 = Integer.parseInt(sc.nextLine());
								System.out.printf("Select Material Weapon 1: ");
								w2 = Integer.parseInt(sc.nextLine());
								System.out.printf("Select Material Weapon 2: ");
								w3 = Integer.parseInt(sc.nextLine());
								
								if (w1 > 0 && w2 > 0 && w3 > 0) {
									if (inventory.getWeapon(w1 - 1) != null && inventory.getWeapon(w2 - 1) != null && inventory.getWeapon(w3 - 1) != null) {
										if ((w1 != w2) && (w1 != w3) && (w2 != w3)) {
											merge.refineWeapons(inventory.getWeapon(w1 - 1), inventory.getWeapon(w2 - 1), inventory.getWeapon(w3 - 1), inventory);
										}
										
										else {
											System.out.println("\nCannot be the same weapon!");
										}
									}
									else {
										System.out.println("\nWeapon/s does not exist");
									}
								}
								
								else {
									System.out.println("\nWeapon/s does not exist");
								}
								
								break;
								
							case 5:// Equip Weapon
								display.characterHeader();
								inventory.displayCharacters();
								System.out.printf("\nSelect Character: ");
								c = Integer.parseInt(sc.nextLine());
								
								if (c > 0) {
									if (inventory.getCharacter(c - 1) != null) {
										display.weaponHeader();
										inventory.displayWeapons();
										System.out.printf("\nSelect Weapon to Equip: ");
										w = Integer.parseInt(sc.nextLine());
										
										if (w > 0) {
											if (inventory.getWeapon(w - 1) != null) {
												equip.equip(inventory.getCharacter(c - 1), inventory.getWeapon(w - 1));
											}
											else {
												System.out.println("\nWeapon does not exist");
											}
										}
										else {
											System.out.println("\nWeapon does not exist");
										}
									}
									else {
										System.out.println("\nCharacter does not exist");
									}
								}
								else {
									System.out.println("\nCharacter does not exist");
								}
								
								
								break;
								
							case 6:// Unequip Weapon
								display.characterHeader();
								inventory.displayCharacters();
								System.out.printf("\nSelect Character: ");
								c = Integer.parseInt(sc.nextLine());
								
								if (c > 0) {
									if (inventory.getCharacter(c - 1) != null) {
										equip.unequip(inventory.getCharacter(c - 1));
									}
									else {
										System.out.println("\nCharacter does not exist");
									}
								}
								else {
									System.out.println("\nCharacter does not exist");
								}
								break;
							
							case 7: //Go Back
								break;
								
							default:
								System.out.println("\nInvalid Input!");
								break;
						
						
						}
					}while(option != 7);
					
					option = 0;
					break;
					
				case 4: // Go Adventure
					do {
						display.mapHeader();
						display.mapSelect();
						System.out.printf("\nSelect Map: ");
						option = Integer.parseInt(sc.nextLine());
						
						if (option > 0 && option < 6) {
							Map map = new Map(option);
							display.characterHeader();
							inventory.displayCharacters();
							System.out.printf("\nSelect Character 1: ");
							c1 = Integer.parseInt(sc.nextLine());
							System.out.printf("Select Character 2: ");
							c2 = Integer.parseInt(sc.nextLine());
							
							if (c1 > 0 && c2 > 0) {
								if ( (c1 != c2) && (inventory.getCharacter(c1 - 1) != null && inventory.getCharacter(c2 - 1) != null)) {
								
									pair.setTeam(inventory.getCharacter(c1 - 1), inventory.getCharacter(c2 - 1));
									adventure.rewardSuccess(pair, pair.getTeam(), map.getResourceAmount(), map.getEnemyList(), inventory.getResource(), inventory);
									adventure.displaySummary(pair, pair.getTeam(), map.getResourceAmount(), map.getLocationName(), map.getEnemyList());
								}
								
								else if (c1 == c2) {
									System.out.println("\nCannot be the same character!");
								}
								else {
									System.out.println("\nCharacter/s does not exist");
								}
							}
							else {
								System.out.println("\nCharacter/s does not exist");
							}
						
						}
						
						else if (option <= 0 || option > 6) {
							System.out.println("\nInvalid Input!");
						}
						
								
						
						
					} while (option != 6);
					option = 0;
				
					
				case 5:// Close Program
					break;
					
				default:
					System.out.println("\nInvalid Input!");
					break;
	
			}
			
			
		} while (option != 5);
		
		sc.close();
	}
	

}