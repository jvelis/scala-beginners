package lectures.part1basics

/**
  * Created by Daniel on 07-May-18.
  */
object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = { // evaluates the parameter before the function runs
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = { // evaluates the parameter at runtime (when it's used)
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  // printFirst(infinite(), 34)
  printFirst(34, infinite()) // infinite() is not evaluated
}
