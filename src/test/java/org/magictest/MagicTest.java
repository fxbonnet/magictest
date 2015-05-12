package org.magictest;

import java.lang.reflect.Method;
import java.util.Iterator;

import org.junit.Test;

import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;

public class MagicTest {

	@SuppressWarnings("rawtypes")
	@Test
	public void testEverything() throws Exception {
		ClassPath classPath = ClassPath.from(this.getClass().getClassLoader());
		for (Iterator<ClassInfo> iterator = classPath
				.getTopLevelClassesRecursive("org.dummy").iterator(); iterator
				.hasNext();) {
			ClassInfo classInfo = iterator.next();
			try {
				Class class_ = Class.forName(classInfo.getName());
				testClass(class_);
			} catch (Throwable t) {
				System.err.println("Error: could not load class: "
						+ t.getClass().getName() + ": " + t.getMessage());
			}
		}
	}

	/**
	 * Tests a class if it has a public empty constructor in order to
	 * instantiate it.
	 */
	@SuppressWarnings("rawtypes")
	private void testClass(Class class_) throws InstantiationException,
			IllegalAccessException {
		System.out.println("Testing class: " + class_.getName());
		try {
			Object instance = class_.newInstance();
			Method[] methods = class_.getMethods();
			for (int i = 0; i < methods.length; i++) {
				Method method = methods[i];
				testMethod(instance, method);
			}
		} catch (Throwable t) {
			System.err.println("Error: could not test class: "
					+ t.getClass().getName() + ": " + t.getMessage());
		}
	}

	/**
	 * Tests a method from an object if it is a getter or a setter. Setters are
	 * just called with null.
	 */
	private void testMethod(Object instance, Method method) {
		try {
			if (method.getName().startsWith("get")) {
				System.out
						.println("Testing getter: " + method.getName() + "()");
				method.invoke(instance);
			} else if (method.getName().startsWith("set")) {
				System.out.println("Testing setter: " + method.getName()
						+ "(null)");
				method.invoke(instance, (Object) null);
			}
		} catch (Throwable t) {
			System.err.println("Error: could not test method: "
					+ t.getClass().getName() + ": " + t.getMessage());
		}
	}

}
