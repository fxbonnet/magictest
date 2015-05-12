package org.dummy;

/**
 * A class that is going to be tested because it has a public empty constructor
 * and public getters and setters.
 *
 */
public class ClassThatIsGoingToBeTested {

	public ClassThatIsGoingToBeTested() {
		System.err.println("new Test()");
	}

	private String test;

	public String getTest() {
		System.err.println("getTest()");
		return test;
	}

	public void setTest(String test) {
		System.err.println("setTest()");
		this.test = test;
	}

	public void thisMethodShouldNotBeTested() {
		System.out.println("thisMethodShouldNotBeTested()");
	}

}
