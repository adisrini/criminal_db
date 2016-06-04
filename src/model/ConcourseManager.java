package model;

import java.util.ArrayList;
import java.util.Collection;

import com.cinchapi.concourse.Concourse;
import com.cinchapi.concourse.thrift.Operator;

public class ConcourseManager {

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

	public Collection<CrimeRecord> getRecords() {
		Collection<CrimeRecord> records = new ArrayList<>();
		
		//adds all records
		concourse.find("captured", Operator.EQUALS, true).stream().forEach(a -> {
			if(extractRecord(a) != null) {
				records.add(extractRecord(a));
			}
		});
		concourse.find("captured", Operator.EQUALS, false).stream().forEach(a -> {
			if(extractRecord(a) != null) {
				records.add(extractRecord(a));
			}
		});
		
		return records;
	}
	
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