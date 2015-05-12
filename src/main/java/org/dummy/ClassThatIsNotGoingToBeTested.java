package org.dummy;

/**
 * A class that is not going to be tested because there is no public empty
 * constructor.
 *
 */
public class ClassThatIsNotGoingToBeTested {

	private ClassThatIsNotGoingToBeTested() {
		System.out.println("new ClassThatShouldNotBeTested()");
	}

}
