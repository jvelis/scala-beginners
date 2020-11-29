package lectures.part1basics

/**
  * Created by Daniel on 07-May-18.
  */
object Functions extends App {

  def aFunction(a: String, b: Int) = {
    a + " " + b // Implementation of a single expression
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1) // Recursive
  }

  println(aRepeatedFunction("hello",3))

  // WHEN YOU NEED LOOPS, USE RECURSION.

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }

  /*
    1.  A greeting function (name, age) => "Hi, my name is $name and I am $age years old."
    2.  Factorial function 1 * 2 * 3 * .. * n
    3.  A Fibonacci function
        f(1) = 1
        f(2) = 1
        f(n) = f(n - 1) + f(n - 2)
    4.  Tests if a number is prime.
   */

  def greeting(name: String, age:Int) : String = {
    s"Hi, my name is $name and I am $age years old."
  }
  println(greeting("Joe", 30))

  def factorial(n:Int):Int = {
    if (n <= 0) 1
    else n * factorial(n - 1)
  }

  println(factorial(2))
  println(factorial(3))
  println(factorial(4))
  println(factorial(5))

  def fibonacci(n : Int) : Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }
  println(3, fibonacci(3))
  println(8, fibonacci(8))
  println(11, fibonacci(11))

  def isPrime(n : Int) : Boolean = {
    def residual(s : Int) : Boolean =
      if (n % s == 0) false
      else if (s>2) residual(s-1)
      else true

    if (n <= 1) false else
    if (n == 2) true else
      residual(n-1)
  }

  println(1, isPrime(1))
  println(2, isPrime(2))
  println(3, isPrime(3))
  println(4, isPrime(4))
  println(5, isPrime(5))
  println(6, isPrime(6))
  println(7, isPrime(7))
  println(37, isPrime(37))
  println(2003, isPrime(2003))
  println(2003, isPrime(2004))
}
