package com.cgi

import scala.util.Try
import scala.util.Failure
import scala.util.Success
import scala.concurrent.Future
import scala.util.Failure
import scala.io.Source

/**
 * @author galloisg
 */
object TryTest extends App {
  
  // def
  private def optionToTry(option: Option[String]): Try[String] = option match {
    case Some(value) => Success(value)
    case None => Failure(new Exception("my error from optionToTry..."))
  }
  
  private def getModel: Try[Model] = {
    for {
      data1 <- optionToTry(Some("data1"))
      data2 <- optionToTry(None)
      data3 <- optionToTry(Some("data3"))
    } yield Model(data1, data2, data3)
  }
  // <=> changer le None en Some("data2") pour voir les différences dans le test plus bas
  private def getModelBis: Try[Model] = {
    optionToTry(Some("data1")).flatMap { 
      data1 => optionToTry(Some("data2")).flatMap { data2 => optionToTry(Some("data3")).map { data3 => Model(data1, data2, data3) } }
    }
  }
  
  private def getModel2Args: Try[Model] = {
    optionToTry(Some("data1")).flatMap { 
      data1 => optionToTry(Some("data2")).map { data2 => Model(data1, data2, "") }
    }
  }
  
  private def getModelTry: Try[Model] = {
    Try {
      Model("", "", "")
    }
  }
  
  def readTextFile(filename: String): Try[List[String]] = {
        Try(Source.fromFile(filename).getLines.toList)
    }
  // ---
  
  println("-----TRY-----")
  val result = Try( "10".toInt )
  result match {
    case Success(v) => println("Success:"+v)
    case Failure(e) => throw new IllegalStateException("should not have come here")
  }
  
  println
  println("-----OPTION-----")
  val o = Some("value")
  val n = None
  println(o.getOrElse("nop"))
  println(o.isEmpty)
  println(n.getOrElse("nop"))
  
  println
  println("-----SEQ-----")
  val seq = Seq(Some("value1"), None, Some("value2"))
  println(seq)
  seq.map { o => println(o.isEmpty) }
  println(seq.contains(None))
  
  println
  println("-----optionToTry-----")
  println(optionToTry(n).isSuccess)
  
  println
  println("-----getModel-----")
  getModel.map { m => println(m.data1+"-"+m.date2+"-"+m.date3) }
  println(getModel.isFailure)
  
  println
  println("-----getModelBis-----")
  getModelBis.map { m => println(m.data1+"-"+m.date2+"-"+m.date3) }
  println(getModelBis.isFailure)
  
  val m: Try[Model] = if(!o.isEmpty) {
       Try {
        Model(o.get, "", "")
      }
   } else {
     Failure(new Exception("..."))
   }
   
  println
  println("-----Try:{}-----")
  println(m)
  
  
  println
  println("-----readTextFile-----")
  val filename = "/etc/passwd"
  readTextFile(filename) match {
      case Success(lines) => lines.foreach(println)
      case Failure(f) => println(f)
  }
    
}