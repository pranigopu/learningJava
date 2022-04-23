public class Cat 
{
    String name;
    String breed;
    int age;
    //Class constructor
    /*
    Class constructor is a special method called to create an object, i.e. when the new keyword is used.
    It abstracts the process of creating an object of a class, which is not so easy since not only must 
    the object have its own set of the same fields as the class, it must also have access to the same methods.  
    
    The constructor must have the same name as the class, or else it will be treated as a normal method.
    */
    //Creating constructor without "this" keyword
    public Cat(String obj_name, String obj_breed, int obj_age)
    {
        name = obj_name;
        breed = obj_breed;
        age = obj_age;
    }
    //Creating constructor with "this" keyword
    /*
    The "this" keyword differentiates the constructor's arguments from the fields of the object being created.
    "this" is applied to the object's fields. 
    */
    /*
    public Cat(String name, String breed, int age)
    {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }
    */
    public static void main(String[] args)
    {
        Cat cat1 = new Cat("Chandu", "Bombay Cat", 3);
        Cat cat2 = new Cat("Ramu", "Savannah Cat", 4);
        System.out.println(cat1.name + " is a " + cat1.breed + " who is " + cat1.age +" years old");
        System.out.println(cat2.name + " is a " + cat2.breed + " who is " + cat2.age +" years old");
    }
}