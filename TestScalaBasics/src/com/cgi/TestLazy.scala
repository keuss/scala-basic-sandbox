package com.cgi

import scala.io.Source

/**
 * @author galloisg
 */
object TestLazy extends App {
  
  val x = { println("yo x"); 15 }
  println(x)
  
  lazy val y = { println("yo y"); 13 }
  println(y)
  
  // ---------------------------------
  
  class Test {
    lazy val foo = Source.fromFile("./bar.txt").getLines
  }
  
  val baz = new Test
  //right now there is no bar.txt
  
  baz.foo
  
  // now I've created empty file named bar.txt
  // class instance is the same
  baz.foo
}