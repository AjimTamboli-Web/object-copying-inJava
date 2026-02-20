package object_Copying_java;

public class A_Clone_Method {

	public static void main(String[] args) throws CloneNotSupportedException{
		
/*
 * The process of creating exactly duplicate object is called cloning.
   The main purpose of cloning is to maintain backup copy and to preserve state of an object.
   which purpose of clone??
   we can perform cloning by using clone() method of Object class.
   
   -->> protected native Object clone()  throws CloneNotSupportedException
   
   we can perform cloning only for Cloneable objects and object is set to be Cloneable if and only if
   corresponding class implements Cloneable interface/
   Cloneable interface present in java.lang package, and it doesn't contain any methods it is a 
   marker interface.
   if we are trying to perform cloning for non Cloneable objects then we will get run-time exception
   saying CloneNotSupportedException.
   
 * 		
 */
		
		Child chi = new Child();
		chi.name = "Bobo";
		
		Parent pa = new Parent();
		pa.i = 2342;
		pa.name = "Robbinson";
		pa.chil = chi;
		
		Parent pa2 =(Parent) pa.clone();
		pa2.i = 56;
		
		System.out.println(pa);
		System.out.println(pa2);
		
	}

}

class Parent implements Cloneable{
	int i;
	String name;
	Child chil;    // HAS-A relation
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public String toString() {
		return this.i + " " + this.name + " " + this.chil;
	}
}
class Child{
	String name;
}
