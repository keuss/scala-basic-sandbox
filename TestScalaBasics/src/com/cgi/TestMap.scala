package com.cgi

/**
 * @author galloisg
 */
object TestMap extends App {
  
  // http://alvinalexander.com/scala/how-to-filter-map-filterkeys-retain-scala-cookbook
  
  val x = Map(1 -> "a", 2 -> "b", 3 -> "c")
  println(s"x:$x")
  
  val y = x.filterKeys(_ > 2)
  println(s"y:$y")
  
  println(x.filter((t) => t._2 == "c"))
  
}