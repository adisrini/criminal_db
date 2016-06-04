package model.command;

import java.util.Collection;

import com.cinchapi.concourse.Concourse;
import com.cinchapi.concourse.Link;

import model.ConcourseManager;

/**
 * The command to link two records bidirectionally.
 * 
 * @author adityasrinivasan
 *
 */
public class LinkBidirectionalCommand extends LinkCommand {

	public LinkBidirectionalCommand(Collection<?> inputs) {
		super(inputs);
	}
	
	@Override
	protected void makeLink(long r1, long r2) {
		Concourse concourse = ConcourseManager.getInstance().concourse();
		concourse.add("link", Link.class, r1);
		concourse.add("link", Link.class, r2);
		ConcourseManager.getInstance().concourse().link("link", r1, r2);
		ConcourseManager.getInstance().concourse().link("link", r2, r1);
	}

}
