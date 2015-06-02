package com.chocksaway.future

import java.util

import scala.concurrent._
import ExecutionContext.Implicits.global

import com.chocksaway.Portscanner
import scala.util.Success
import java.util.Date

/**
 * Scala Futures wrapper round PortScanner
 * This is my first foray into Futures
 */
object FutureScanner {
    implicit class ForeachAsync[T](iterable: Iterable[T]) {
        def foreachAsync[U](f: T => U)(implicit ec: ExecutionContext): Unit = {
            def next(i: util.Iterator[T]): Unit = if (i.hasNext) Future(f(i.next)) onComplete { case _ => next(i) }
            next(iterable.iterator)
        }
    }

    def main(args: Array[String]) {
        val scanner = new Portscanner()
        val start = System.nanoTime
        // Nice way of creating a list of ints
        val portList = ( 1 to 65535 ).map{ x => scanner.scan(x)} foreachAsync println
        val micros = (System.nanoTime - start) / 1000
        println("%d microseconds".format(micros))
    }

}
