package com.chocksaway

/**
 * User: milesd
 * Date: 26/02/2013
 * Time: 10:11
 */


/**
 * Some basic Scala exercises
 */
object LearningScala {

  /**
   * Find the nth  element of the Fibonnaci sequence
   *
   * @param n
   * @return
   */
  def fib(n: Int) = (0 /: (1 to n))(_ + _)

  /**
   * Print 1 - 12 times table
   */
  def multTab {
    (1 to 12).foreach(i => {
      (1 to 12).foreach(j => print(i * j + " "))
      println
    })
  }

  /**
   * Print all off number between 1 - 100
   */
  def odds {
    (1 to 100).filter(_ % 2 != 0).foreach(x => print(x + " "))
    println
  }

  /**
   * Find the max in an array of Ints
   * @param a
   * @return
   */
  def max(a: Array[Int]) = {
    require(a.size > 0)
    a.foldLeft[Option[Int]](None)((a, b) => {
      a match {
        case i : Some[Int] if i.get > b => i
        case _ => Some(b)
      }
    }).get
  }

  /**
   * Iterate through a list of Strings by folding the string.
   */
  def foldLeftString {
    val sentence = List("happy", "christmas", "december", "25", "2013")
    sentence.foldLeft("start")((a,b) => {
      println("[a:" + a + "][b:"+ b + "]");
      a + b
    })
  }

  def main(args: Array[String]) {
    println("Hello, world!")
    LearningScala.fib(10)
    LearningScala.multTab
    LearningScala.odds
    val intArray = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
    LearningScala.max(intArray)
    LearningScala.foldLeftString
  }

}
