
import scala.annotation.tailrec

class FunctionalConcepts {

  // Recursion & Scala
  def factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1)

  // Tail recursion & Scala
  def factorialTailRecursive(n: Int): Int = {
    @tailrec
    def loop(acc: Int, n: Int): Int =
      if (n == 0) acc
      else loop(acc * n, n - 1)
    
    loop(1, n)
  }
  
  // Higher-order functions & Scala
  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sum(f, a + 1, b)
    
  // Currying & Scala
  def sumCurried(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sumCurried(f)(a + 1, b)
  
    
  def main(args: Array[String]): Unit = {
    val easySum = sumCurried((x) => x) _ ;
  
    println (easySum(4, 5));
  }
}