package com.cgi

/**
 * @author galloisg
 */
object TestMap extends App {
  
  // http://alvinalexander.com/scala/how-to-filter-map-filterkeys-retain-scala-cookbook
  // https://www.scala-lang.org/api/current/scala/collection/Map.html
  // Also others examples for : https://github.com/loicknuchel/scala-class
  
  val x = Map(1 -> "a", 2 -> "b", 3 -> "c")
  println(s"x:$x")
  
  val y = x.filterKeys(_ > 2)
  println(s"y:$y")
  
  println(x.filter((t) => t._2 == "c"))
  
  val countries = Map("fr" -> "France", "be" -> "Belgique", "en" -> "Angleterre")
  
  println(countries.get("fr")) //Some("France")
  
  println(countries.map(country => (country._1, country._2.length))) // Map("fr" -> 6, "be" -> 8, "en" -> 10)
  println(countries.map { case (code, name) => (code, name.length) }) // Map("fr" -> 6, "be" -> 8, "en" -> 10) // en utilisant le pattern matching \o/
  println(countries.filter(_._2.contains("r"))) // Map("fr" -> "France", "en" -> "Angleterre")
  println(countries.find(_._2.contains("e"))) // Some("fr", "France")
  
}