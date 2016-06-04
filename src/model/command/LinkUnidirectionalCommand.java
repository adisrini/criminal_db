package model.command;

import java.util.Collection;

import com.cinchapi.concourse.Concourse;
import com.cinchapi.concourse.Link;

import model.ConcourseManager;

/**
 * The command to link two records unidirectionally.
 * 
 * @author adityasrinivasan
 *
 */
public class LinkUnidirectionalCommand extends LinkCommand {

	public LinkUnidirectionalCommand(Collection<?> inputs) {
		super(inputs);
	}

	@Override
	protected void makeLink(long r1, long r2) {
		Concourse concourse = ConcourseManager.getInstance().concourse();
		concourse.add("link", Link.class, r1);
		concourse.add("link", Link.class, r2);
		ConcourseManager.getInstance().concourse().link("link", r1, r2);
	}

}
