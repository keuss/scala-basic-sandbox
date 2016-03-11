package com.cgi

/**
 * @author galloisg
 */
object FunctionalStuff extends App {
  
  println
  println("-----FONCTION AS VARIABLE-----")
  def addTag(tag:String): (String => String) = {
    (text:String) => "<" + tag + ">" + text + "</" + tag + ">"
  }
  
  //def addTag(tag:String) = (text:String) => "<" + tag + ">" + text + "</" + tag + ">"
  
  val addSpan = addTag("span")
  println(addSpan("hello !"))
  println(addSpan("bye !"))
  
  
  //string
  val filterby = "data1;data2"
  println(filterby.split(";").toList)
  
}