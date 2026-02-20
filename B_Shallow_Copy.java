package object_Copying_java;

public class B_Shallow_Copy {

	public static void main(String[] args) throws CloneNotSupportedException {
		
/*
 * Shallow Copy:: 
     Shallow copy means creating a clone of an object, where the object itself is copied but the nested 
       objects are not copied.
       
   ⏺️ In shallow copy, 
     ⭕ Primitive fields: The primitive fields that are int, float, etc. are copied by value. 
                           This means changes to one variable do not affect to other.
     ⭕ Non-primitive fields: The non-primitive fields that are objects, arrays, etc. are copied by
                              reference. This means the original and copied object will share the 
                   same reference to these fields, and changes made in the copy will affect the original.
 * 
 * A shallow copy creates a new object, but copies references of nested objects, not the actual objects.
 * 
 * ⏺️ Where Shallow Copy is SAFE?

   ✅ If object contains only:
	  ⭕ primitives
	  ⭕ immutable objects  - Ex. String is immutable → cannot change internal state.
	 
	⏺️  When you call:
			Tiger t2 =(Tiger)t1.clone();
			JVM:
				⭕ Allocates memory
				⭕ Copies field values bit-by-bit
				⭕ Does NOT call your constructor
			It bypasses constructor logic.
 * 	
 * The process of creating bitwise copy of an object is called shallow cloning.	
 * if the main object contain primitive variables then exactly duplicate copy will be created in the 
 * clone object.
 * if the main object contain any reference variable then corresponding object won't be created just 
 * a duplicate reference variable will be created pointing to old contain object.
 * Object class clone() method went for shallow cloning.
 * 
 * In shallow cloning by using clone object reference if we perform any change to the contain object 
 * then those changes will be reflected to the main object.
 * To overcome this problem we should go for deep cloning.
 * 
 */

		Animal ab = new Animal("Shera");
		
		Tiger t1 = new Tiger(ab,23,"Shepert");
		t1.id = 45;
		t1.an.perName = "job";
		
		 // Create a shallow copy of t1
		Tiger t2 =(Tiger)t1.clone();
		t2.id = 234;
		t2.an.perName = "fdsg";
		
		Tiger t3 = (Tiger) t2.clone();
		t3.id = 89;
		t3.an.perName = "James";
		
		System.out.println("t1  " + t1);
		System.out.println("t2  " + t2);	
		System.out.println("t3::  " + t3);
	}
}


class Animal {
	String perName;
	
	Animal(String l){
		this.perName = l;
	}
	
	public String toString() {
		return this.perName;
	}
}



class Tiger implements Cloneable{
	int id;
	String tag;
	Animal an;
	
	Tiger(Animal a, int id,String d){
		System.out.println("Constructor calls...");
		this.an = a;
		this.id = id;
		this.tag = d;
	}
	
	  @Override
	public Object clone() throws CloneNotSupportedException{
		  // Performs shallow copy using clone method
			return super.clone();
	}
	
	public String toString() {
		return this.an + " " + this.id + " " + this.tag;
	}
}
