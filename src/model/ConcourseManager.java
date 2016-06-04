package model;

import java.util.ArrayList;
import java.util.Collection;

import com.cinchapi.concourse.Concourse;
import com.cinchapi.concourse.thrift.Operator;

/**
 * The manager for the ConcourseDB. The manager is designed as a Singleton since no two instances of the
 * database can ever exist.
 * 
 * @author adityasrinivasan
 *
 */
public class ConcourseManager {

	private static final String KEY = "captured";
	
	private Concourse concourse;
	
	private ConcourseManager() {
		concourse = Concourse.connect();
	}

	private static class SingletonHolder {
		private static final ConcourseManager INSTANCE = new ConcourseManager();
	}

	public static ConcourseManager getInstance() {
		return SingletonHolder.INSTANCE;
	}
	
	public Concourse concourse() {
		return concourse;
	}

	/**
	 * Returns a collection of CrimeRecord objects representing all records in the database.
	 * @return
	 */
	public Collection<CrimeRecord> getRecords() {
		Collection<CrimeRecord> records = new ArrayList<>();
		
		concourse.find(KEY, Operator.EQUALS, true).stream().forEach(a -> {
			if(extractRecord(a) != null) {
				records.add(extractRecord(a));
			}
		});
		concourse.find(KEY, Operator.EQUALS, false).stream().forEach(a -> {
			if(extractRecord(a) != null) {
				records.add(extractRecord(a));
			}
		});
		
		return records;
	}
	
	/**
	 * Extracts a record given its record number.
	 * @param number
	 * @return
	 */
	private CrimeRecord extractRecord(long number) {
		String perp_name, victim_name, offense, location; boolean captured;
		perp_name = concourse.get("perp_name", number);
		victim_name = concourse.get("victim_name", number);
		offense = concourse.get("offense", number);
		location = concourse.get("location", number);
		captured = concourse.get("captured", number);
		return new CrimeRecord(number, perp_name, victim_name, offense, location, captured);
	}
	
}