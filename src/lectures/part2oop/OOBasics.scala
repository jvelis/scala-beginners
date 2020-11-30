package lectures.part2oop

/**
  * Created by Daniel.
  */
object OOBasics extends App {

  // constructor
  class Person(name: String, val age: Int = 0) { // class parameters are not fields. Use Val to use it as a field.
    // body
    val x = 2 // it's a field and can be accessed with Person.x

    println(1 + 3) // this side effect will also be executed when instantiating the class

    // method
    def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

    // overloading - finding methods with the same name (but different signatures)
    def greet(): Unit = println(s"Hi, I am $name")

    // multiple constructors or overloading constructors
    def this(name: String) = this(name, 0) // 'this' to access the current instance
    def this() = this("John Doe")
  }

  val person = new Person("John", 26)
  println(person.x)
  person.greet("Daniel")
  person.greet()

  val person2 = new Person()
  println(person2)
  person2.greet("Frank") // this("Frank") > this("Frank", 0) > Person("Frank", 0)
  person2.greet() // this() > this("John Doe") > Person("John doe", 0)

  /*
		Novel and a Writer
		Writer: first name, surname, year
			- method fullname

		Novel: name, year of release, author
		- authorAge
		- isWrittenBy(author)
		- copy (new year of release) = new instance of Novel
	 */

  class myWriter(name: String, surname: String, val year: Int) {
    def fullName: String = name + " " + surname
  }
  val writer1 = new Writer("Ray", "Bradbury", 1920)
  println(writer1.fullName)

  class myNovel(name: String, releaseYear: Int, author: Writer) {
    def authorAge(): Int = releaseYear - author.year
    def isWrittenBy(): String = author.fullName
    def copy(newReleaseYear: Int): myNovel = new myNovel(name, newReleaseYear, author)
  }
  val novel1 = new myNovel("Martian Chronicles", 1960, writer1)
  println(novel1.isWrittenBy(), novel1.authorAge(), novel1.copy(1975).authorAge())

  /*
		Counter class
			- receives an int value
			- method current count
			- method to increment/decrement => new Counter
			- overload inc/dec to receive an amount
	 */

  class myCounter(val x:Int = 0) {
    def current:Int = x
    // methods
    def increment:myCounter = new myCounter(x + 1)
    def decrement:myCounter = new myCounter(x - 1)
    // overloading methods
    def increment(i:Int):myCounter = if (i <= 0) this else increment.increment(i-1) //new myCounter(i).increment
    def decrement(i:Int):myCounter = if (i <= 0) this else decrement.decrement(i-1) //new myCounter(i).decrement
  }
  val c1 = new myCounter(5)
  println(c1.current)
  println(c1.increment.current)
  println(c1.decrement.current)
  println(c1.increment(2).current)
  println(c1.decrement(2).current)

  /*
  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(imposter))

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print
  */
}

class Writer(firstName: String, surname: String, val year: Int) {
  def fullName: String = firstName + " " + surname
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge = year - author.year
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

class Counter(val count: Int = 0) {
  def inc = {
    println("incrementing")
    new Counter(count + 1)  // immutability
  }

  def dec = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n-1)
  }

  def dec(n: Int): Counter =
    if (n <= 0) this
    else dec.dec(n-1)

  def print = println(count)
}

// class parameters are NOT FIELDS