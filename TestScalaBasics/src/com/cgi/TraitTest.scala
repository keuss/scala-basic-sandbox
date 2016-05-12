package com.cgi

/**
 * @author galloisg
 */
object TraitTest extends App {
  
  trait Personne {
    def name: String
    def age: Int
  }
  
  case class Homme(name: String, age: Int, gender: String = "H") extends Personne {
    def getName = name
    def getAge = age
  }
  
  case class Femme(name: String, age: Int, gender: String = "F") extends Personne {
    def getName = name
    def getAge = age
  }
  
  val h: Personne = Homme("Marc", 20)
  val f: Personne = Femme("Lucy", 36)
  
  println(h.isInstanceOf[Homme])
  println(h.isInstanceOf[Femme])
}