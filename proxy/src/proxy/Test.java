package proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		try {
            // Get class object
            Class<?> studentClass = Class.forName("proxy.Student");

            // Print class name
            System.out.println("Class Name: " + studentClass.getName());

            // Get all constructors
            Constructor<?>[] constructors = studentClass.getConstructors();
            System.out.println("\nConstructors:");
            for (Constructor<?> constructor : constructors) {
                System.out.println("  " + constructor);
            }

            // Get all methods
            Method[] methods = studentClass.getDeclaredMethods();
            System.out.println("\nMethods:");
            for (Method method : methods) {
                System.out.println("  " + method);
            }            
            
            // Create an instance of Student
            Object studentInstance = studentClass.getDeclaredConstructor().newInstance();

            // Get the attendLession method that takes Integer as a parameter
            Method method = studentClass.getMethod("attendLession", Integer.class);

            // Invoke the method on the student instance with an argument
            method.invoke(studentInstance, 101);
            
            
            Method method1 = studentClass.getMethod("attendLession");
            method1.invoke(studentInstance);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
}
