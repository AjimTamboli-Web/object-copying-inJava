package object_Copying_java;

public class A_Cloneable_Interface {

	public static void main(String[] args) throws CloneNotSupportedException {
		
/*
 * Cloneable interface is a marker interface used to indicate that a class allows creating an exact copy
           of its objects. 
   It is part of java.lang package and is primarily used with the Object.clone() method to create 
           duplicates of objects.
       
       * A Marker Interface in Java is an interface that contains no methods or fields. It is used to mark a 
   class so that the Java runtime or compiler can identify some special behavior or capability of that class.
     Like Cloneable Interface, Serializable interface, Random interface
 
 	⭕ protected Object clone() throws CloneNotSupportedException  
 	           This method is defined in: Object class
 
 * It does not contain any methods (Marker Interface).
   Its main purpose is to signal to the Object.clone() method that the objects of this class can be
   safely cloned.
   If a class implements Cloneable, calling clone() on its objects will create a shallow copy.
   If a class does not implement Cloneable, calling clone() on its object throws CloneNotSupportedException.
 
 
 * Types of Cloning 
    a> Shallow cloning     b> Deep cloning
 * 	
 * ❓ Is clone shallow or deep?
	=>>	Default → it is a shallow.	
 */
             Emp a = new Emp(23);
            // cloning 'a' and holding new cloned object reference in b
             
            // down-casting as clone() return type is Object 
             Emp b =(Emp) a.clone();
             
             System.out.println(b.i);
             
            
	}
}
//Making class A cloneable using cloneable interface
class Emp implements Cloneable{
	int i;
	
	public Emp(int i) {
		this.i = i;
	}
	
   // Overriding clone() method by simply calling Object class clone() method.
	 @Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}


