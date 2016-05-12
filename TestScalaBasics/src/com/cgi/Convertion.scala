package com.cgi

/**
 * @author galloisg
 */
object Convertion extends App {

  // String, int, BigInt ------------------------
  val str = "100000000"
  println(str.toInt)
  val z = BigInt("1234566789008723457802308972345723470589237507")
  println(z)
  println(BigInt("000000000"))
  
  val a = BigInt(123456789)
  val b = BigInt(987654)
  println(a.toString + b.toString)
}