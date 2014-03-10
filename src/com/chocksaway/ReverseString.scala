package com.chocksaway

/**
 *
 * Examples of reversing Strings
 *
 */
object ReverseString {

  def sum(list: List[Int]): Int = list.foldLeft(0)((r,c) => r+c)

  def reverseWithFoldLeft[A](list: List[A]): List[A] =
    list.foldLeft(List[A]())((r,c) => c :: r)

  def main(args: Array[String]) {
    println("Hello World".reverse)

    val intList = List(1,2,3,4,5)

    val stringList = List('h', 'e', 'l', 'l', 'o')

    println (sum(intList))

    println(reverseWithFoldLeft(stringList).mkString(""))

    println ("hello again".foldLeft(List[Char]()){(a,b)=>b::a}.mkString(""))
  }


}
