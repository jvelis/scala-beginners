package lectures.part2oop

/**
  * Created by Daniel.
  */
object Objects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static") unlike Java
  object Person { // the object it's its own type + its only instance
    // "static"/"class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method = build Persons
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  // Class and object with the same name is called Companions because they are the same scope
  //
  class Person(val name: String) {
    // instance-level functionality
  }
  // COMPANIONS

    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = SINGLETON INSTANCE
    val mary = new Person("Mary")
    val john = new Person("John")
    println(mary == john)

    val person1 = Person
    val person2 = Person
    println(person1 == person2)

    val bobbie = Person(mary, john) // Person singleton object called like a function

  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit // Exact definition because JVM requirements


  val k = 6.67e-11

  // Notes
  // Scala doesn't have "static" values/methods
  // Scala Objects
  //  - Are in their own class
  //  - Are the only instance
  //  - Singleton pattern in one line
  // Scala Companions
  //  - Object and class in the same scope
  //  - Can access each other's private members
  //  - Scala is more OOP than Java
}
