package model;

/**
 * A container for information about each record in the database.
 * 
 * @author adityasrinivasan
 *
 */
public class CrimeRecord {
	
	private long record_number;
	private String perpetrator;
	private String victim;
	private String offense;
	private String location;
	private boolean captured;

	public CrimeRecord(long record_number, String perpetrator, String victim, String offense, String location, boolean captured) {
		this.record_number = record_number;
		this.perpetrator = perpetrator;
		this.victim = victim;
		this.offense = offense;
		this.location = location;
		this.captured = captured;
	}
	
	public long getRecordNumber() {
		return this.record_number;
	}
	
	public String getPerpetrator() {
		return this.perpetrator;
	}
	
	/**
	 * Displays the object nicely to the user.
	 */
	@Override
	public String toString() {
		String ret =  this.perpetrator + " vs. " + this.victim + ", charged for " + this.offense + " in " + this.location + " and ";
		ret +=  this.captured ? "captured." : "uncaptured.";
		return ret;
	}
	
}
