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
  
  // Doubles, and Precision
  val d1: Double = 1003.0
  val d2 = BigDecimal(d1).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
  println(d2)
  println(Math.round(d1*100.0)/100.0)
  println(d1 - (d1 % 0.01))  
}