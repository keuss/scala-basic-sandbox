package com.cgi

/**
 * @author galloisg
 */
object SyntacticalSugar extends App {

  /*
   * Because everything needs to have a value, this is syntactical sugar for:
    1 + 2
    val s = "a" + "b"
  */
  val s = { 1 + 2; "a" + "b" }
  println(s)

}