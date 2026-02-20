package object_Copying_java;

import java.util.ArrayList;
import java.util.List;

public class C_Deep_Copy_with_cloneMethod {

	public static void main(String[] args) {

/*
 * A deep copy creates a new object and also creates new copies of all referenced objects inside it.
 * 
 * The process of creating exactly duplicate independent copy including contain object,
 * is called deep cloning.
 * In deep cloning if the main object contain any primitive veriables then in the clone object 
 * duplicate copies will be created.
 * If the main object contain anhy reference variable then corresponding contain object alson will be 
 * created in the cloned copy.
 * By default object class clone method meant for shallow cloning, but we can implement deep cloning 
 * explicitly by overriding clone() method in our class.
 * 	
 * By using clone object reference if we perform any change to the contain object then those changes
 * won't reflected to the main object.
 * Which cloning is Best??
 * if object contains only primitive variables then shallow cloning is the Best choice.
 * if object contains reference variables then deep cloning is the best choice.
 * 
 * 	
 */
		List<String> li = List.of("John","Derek","Lucy");
				Dept cm = new Dept("Computer",li);
				
				College col = new College("KJS",5000,cm);
				System.out.println(col.name + " " + col.sal + " " + col.de.name + " " + col.de.li);
				
				
				College col2 = (College)col.clone();
				
				col2.name = "Sanjivani";
				col2.de.name = "E&TC";
				
				System.out.println(col.name + " " + col.sal + " " + col.de.name + " " + col.de.li);	
				System.out.println(col2.name + " " + col2.sal + " " + col2.de.name + " " + col2.de.li);
				
  }
}

class College implements Cloneable{
	String name;
	float sal;
	Dept de;
	
	College(String name,float sal,Dept de){
		this.de = de;
		this.name = name;
		this.sal = sal;
		System.out.println("Constructor call....");
	}
	
	public Object clone() {
		Dept de2 = new Dept(de.name,de.li);
		College col = new College(name,sal,de2);
		return col;
	}
	
}

class Dept{
	String name;
	List<?> li = new ArrayList<>();
	Dept(String name, List<?> li){
		this.name = name;
		this.li = li;
	}
	
	
}
