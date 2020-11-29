package lectures.part1basics

/**
  * Created by Daniel on 07-May-18.
  */
object Expressions extends App {

  val x = 1 + 2 // EXPRESSION
  println(x)

  println(2 + 3 * 4)
  // + - * / & | ^ << >> >>> (right shift with zero extension)

  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // also works with -= *= /= ..... side effects
  println(aVariable)

  // Instructions (DO - Imperative language) vs Expressions (VALUE)
  // Instructions are executed (java)
  // Expressions are evaluated (scala)
  // Basic expresions: Operators
  // If in scala is an expression
  // Code blocks are expressions too (the last expression in the block returns the value)

  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 // IF EXPRESSION
  println(aConditionedValue)
  println(if(aCondition) 5 else 3)
  println(1 + 3)

  var i = 0
  val aWhile = while (i < 10) {
    println(i)
    i += 1
  }

  // NEVER WRITE THIS AGAIN.

  // EVERYTHING in Scala is an Expression!

  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue) // Unit prints this: ()

  // side effects: println(), whiles, reassigning and expressions that return Unit

  // Code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  // 1. difference between "hello world" vs println("hello world")?
  // String vs Unit

  // 2. what's the value of:

  val someValue = {
    2 < 3
  } // true : Boolean
  println(someValue)

  val someOtherValue = {
    if(someValue) 239 else 986
    42
  } // 42 : Int
  println(someOtherValue)


}
