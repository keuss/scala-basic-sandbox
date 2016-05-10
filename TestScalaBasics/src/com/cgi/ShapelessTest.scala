package com.cgi

// com.chuusai.shapeless_2.11-2.0.0.jar
import shapeless._
import shapeless.syntax.std.tuple._

/**
 * @author galloisg
 */
object ShapelessTest extends App {
  
  // shapeless is a type class and dependent type based generic programming library for Scala : https://github.com/milessabin/shapeless
  // see https://github.com/milessabin/shapeless/wiki/Feature-overview:-shapeless-2.0.0 for example
  
  // head, tail, take, drop, split
  println("\nhead, tail, take, drop, split")
  println((23, "foo", true).head)
  println((23, "foo", true).tail)
  println((23, "foo", true).drop(2))
  println((23, "foo", true).take(2))
  
  // prepend, append, concatenate
  println("\nprepend, append, concatenate")
  
  val user = User(2, "Johanna", "Doe", 30, Some("meuf"))
  val tup = (2, "Johanna", "Doe", 30, Some("meuf"))
  
  val t1 = 23 +: ("foo", true)
  val t2 = (23, "foo") :+ true
  val t3 = (23, "foo") ++ (true, 2.0)
  val t4 = (23, "foo", true).toList
  val t5 = (User.apply _) tupled ((2, "Johanna", "Doe") ++ tup.drop(3))
  val chunks = tup.drop(2)._1
  
  println(t1)
  println(t2)
  println(t3)
  println(t4)
  println(t5)
  println(chunks)
}