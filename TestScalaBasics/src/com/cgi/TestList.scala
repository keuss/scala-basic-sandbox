package com.cgi

import scala.util.Success
import scala.util.Try
import scala.collection.immutable.HashMap

/**
 * @author galloisg
 */
object TestList extends App {
 
  
  def length[A](list: List[A]): Int = list match {
    case Nil => 0
    case _ :: tail => 1 + length(tail)
  }
  
  val s = Seq(1, 2, 3)
  val sStr = Seq("hello how are you ?", "i  'm fine !" , "thank you !")
  val sStrLetter = Seq("hello", "how" , "are", "you", "?")
  
  val l = List(1, 2, 3)
  
  println
  println("-----MAP-----")
  println(s.map(v => v + 1))
  
  println
  println("-----FLATMAP-----")
  def getWords(lines: Seq[String]): Seq[String] = lines flatMap (line => line split "\\W+")
  println(getWords(sStr))
  
  // lettersOf will return a Seq[Char] of likely repeated letters, instead of a Set
  def lettersOf(words: Seq[String]) = words flatMap (word => word.toSet)
  println(lettersOf(sStrLetter))
  
  println
  println("----- _ -----")
  println(s.map (_ + 2)) // _ + 2 <=> v => v + 2
  
  println
  println("-----MATCHING-----")
  println(length(l))
  
  println
  println("-----ADD ELMT-----")
  val updatedList = l.:::(List(4, 5, 6))
  println(updatedList)
  val updatedList2 = List(4, 5, 6).:::(l)
  println(updatedList2)
  // [use case] A copy of the immutable sequence with an element prepended.
  val updatedList3 = l.+:(0)
  println(updatedList3)
  
  
  println
  println("-----List[Try] Converting a List[Try[A]] to List[A] in Scala -----")
  // http://stackoverflow.com/questions/27955294/converting-a-listtrya-to-lista-in-scala
  val lTry: List[Try[Int]] = List(Success(1), Success(2));
  //val lChange = lTry.flatMap(_.toOption) // ça marche mais lol
  val lChange = lTry collect { case Success(x) => x }
  println(lChange)
  
  println
  println("-----FOLDLEFT-----")
  // HashMap[String, String]() accumulateur vide de départ
  val sStrToFold = List("key0=val1,val2", "key1=val3,val4")
  val sStrFolded = sStrToFold.foldLeft(HashMap[String, String]()) { 
    (m, s) => m + (s.split("=")(0) -> s.split("=")(1))
  }
  println(sStrFolded)
  println(sStrFolded.get("key0").getOrElse(""))
  println(sStrFolded.get("key1").getOrElse(""))
  
  println
  println("-----CONCAT-----")
  println(List(1,2,3) ++ List(4,5))
  
  println
  println("-----toString-----")
  val sStrLetter2 = Seq("hello\n", "how\n" , "are\n", "youuuuu\n", "?\n")
  println("["+sStrLetter.mkString("\n")+"]")
  
}