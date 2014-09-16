package me.capit.entropy.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.capit.entropy.EntropyMain;

public class Town implements Serializable {
	private static final long serialVersionUID = -8979383970183615150L;
	final EntropyMain plugin;
	
	private final UUID owner;
	private final int id;
	
	private int daysOfInactivityLeft = 7;
	private String name;
	private boolean abandoned = false;
	
	// The List object is more adaptive to the situation and consumes less activation memory than ArrayList.
	private List<Structure> structures = new ArrayList<Structure>();
	private List<UUID> players = new ArrayList<UUID>();
	
	// I removed it but it was going to be for how much storage each town has used within the building.
	// But I think i know a better way of storing this.
	public Town(EntropyMain plugin, UUID owner, String name){
		this.plugin = plugin;
		this.owner = owner;
		this.name = name;
		this.id = EntropyMain.towns.size();
	}
	
	public int getID(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public UUID getOwner(){
		return owner;
	}
	
	public void inactiveDay(){
		daysOfInactivityLeft--;
	}
	
	public int getInactiveDays(){
		return daysOfInactivityLeft;
	}
	
	public void setInactiveDays(int days){
		daysOfInactivityLeft = days;
	}
	
	public void addStructure(Structure structure){
		structures.add(structure);
	}
	
	public void removeStructure(Structure structure){
		structures.remove(structure);
	}
	
	public List<Structure> getStructures(){
		return structures;
	}
	
	public void addPlayer(UUID uuid){
		players.add(uuid);
	}
	
	public void removePlayer(UUID uuid){
		players.remove(uuid);
	}
	
	public List<UUID> getPlayers(){
		return players;
	}
	
	public boolean isAbandoned(){
		return abandoned;
	}
	
}
