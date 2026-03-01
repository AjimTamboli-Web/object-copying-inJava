package object_Copying_java;

public class D_DeepCopy_With_Copy_Constructor {

	public static void main(String[] args) {

/*
 * This is Joshua Bloch’s top recommendation.
 * 
 * A copy constructor is:
	A constructor that creates a new object by copying state from another object of the same class.
 				Syntax::
					ClassName(ClassName other) {
    								// copy fields
					}
 * ⚠ Java does NOT generate this automatically (unlike C++). Java doesn't create a default copy 
       constructor if you don't write your own.
 * 
 *  👉 If field is mutable reference type, you MUST deep copy it.
 *  Examples of mutable types:
	Array,   List,    Map,    Date,	   Custom class
	
 *	Examples of immutable:
	String,	 Integer,	 LocalDate,		BigDecimal
	For immutable types, shallow is safe.
	
 *  Java cloning comes from Object
	Problems with clone:
							Protected method
							Shallow by default
							Requires Cloneable
							Checked exception
							Type casting needed
	Modern Java prefers copy constructor.

 */
          Company co = new Company("TCS");
          Person pe1 = new Person("John",23532,co);
          
          Person pe2 = new Person(pe1);
          pe2.id = 23;
          pe2.com.name = "Info";
          
          Person pe3 = new Person(pe2);
          pe3.com.name = "Wipro";
          
          System.out.println(pe1.id + " " + pe1.name + " " + pe1.com.name);
          System.out.println(pe2.id + " " + pe2.name + " " + pe2.com.name);
          System.out.println(pe3.id + " " + pe3.name + " " + pe3.com.name);
	}
}
class Person{
	String name;
	int id;
	Company com; // Reference Fields
	
	Person(String name,int id,Company co){
		this.id = id;
		this.name = name;
		this.com = co;
		System.out.println("Constructor created");
	}
	Person(Person other){
		this.id = other.id;
		this.name = other.name;
		this.com = new Company(other.com.name);
		System.out.println("Copy created..");
	}
}
class Company{
	String name;
	Company(String name){
		this.name = name;
	}
}
