package core;

import java.util.*;


public class Inventory{
	  private ArrayList<Character> characters;
	  private ArrayList<Weapon>    weapons;
	  private Resource  resource;
	  
	  
	  public Inventory() {
		  this.characters = new ArrayList<Character>();
		  this.weapons = new ArrayList<Weapon>();
		  this.resource = new Resource(16450);
		  Character setc = new Character(1);
		  Weapon    setw = new Weapon(1);
		  this.storeCharacter(setc);
		  this.storeCharacter(setc);
		  this.storeCharacter(setc);
		  this.storeWeapon(setw);
		  this.storeWeapon(setw);
		  this.storeWeapon(setw);  
	  }
	  
	  public void storeCharacter(Character character) {
		  this.characters.add(character);
	  }
	  
	  public void storeCharacters(Character[] characters) {
		  Collections.addAll(this.characters, characters);
	  }

	  public void storeWeapon(Weapon weapon){
		  this.weapons.add(weapon);
	  }
	  
	  public void storeWeapons(Weapon[] weapons) {
		  Collections.addAll(this.weapons, weapons);
	  }

	  public ArrayList<Character> getCharacters(){
		  return this.characters;
	  }

	  public ArrayList<Weapon> getWeapons(){
	    return this.weapons;
	  }
	  
	  public Resource getResource() {
		  return this.resource;
	  }

	  public Character getCharacter(int index) {
		  if (index < this.characters.size()) {
			  return this.characters.get(index);
		  }
		  else
			  return null;
		  
	  }
	  
	  public int getCharacter(Character c) {
		  return this.characters.indexOf(c);
	  }
	  
	  public Weapon getWeapon(int index) {
		  if (index < this.weapons.size()) {
			  return this.weapons.get(index);
		  }
		  else
			  return null;
		  
	  }
	  
	  
	  public void displayCharacters() {
		  Collections.sort(this.characters, sortbyCName);
		  Character[] temp = new Character[this.characters.size()];
		  temp = this.characters.toArray(temp);
		  
		  for (int i = 0; i < this.characters.size(); i++) {
			  System.out.printf("[%d]", i + 1); temp[i].displayCharacter();
		  }
	  }
	  
	  public void displayWeapons() {
		  Collections.sort(this.weapons, sortbyWName);
		  Weapon[] temp = new Weapon[this.weapons.size()];
		  temp = this.weapons.toArray(temp);
		  
		  for (int i = 0; i < this.weapons.size(); i++) {
			  System.out.printf("[%d]", i + 1); temp[i].displayWeapon();
		  }
	  }
	  
	  public void displayResources() {
		  System.out.println("\nResources: " + this.resource.getAmount());
	  }
	  public void disposeCharacter(Character c) {
		  this.characters.remove(c);
	  }
	  
	  public void disposeWeapon(Weapon w) {
		  this.weapons.remove(w);
	  }
	  
	  public void levelPair(Character[] pair, int levels) {
		  for (int i = 0; i < 2; i++) {
			this.levelUp(this.characters.get(this.getCharacter(pair[i])),levels);
		  }
	  }
	  public void levelUp(Character c, int levels) {
		  c.increaseLevel(levels);
	  }

	  
	  Comparator<Character> sortbyCName = new Comparator<Character>(){
		  public int compare(Character c1, Character c2) {
			  return c1.getName().compareTo(c2.getName());
		  }
	  };
	  
	  Comparator<Weapon> sortbyWName = new Comparator<Weapon>(){
		  public int compare(Weapon w1, Weapon w2) {
			  return w1.getName().compareTo(w2.getName());
		  }
	  };

	  
	  

}
