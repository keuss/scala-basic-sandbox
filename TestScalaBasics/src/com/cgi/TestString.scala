package com.cgi

/**
 * @author galloisg
 */
object TestString extends App {
  
  println
  println("-----trim and toUpperCase, ... -----")
  val str1 = " "
  println(s"str1 : [${str1.trim}]")
  
  val str2 = "Keuss"
  println(s"str2 : [${str2.toUpperCase}]")
  
  val str3 = "Bris de machines standard"
  println(str3.contains("Bris de machines"))
  
  val d:Double = 0.0
  println(d.toInt)
  if(d > 0) 
    println("true")
  
}