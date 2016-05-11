package com.cgi

/**
 * from http://alvinalexander.com/scala/how-to-use-scala-enums-enumeration-examples
 */
object TestEnum extends App {
  
  import com.cgi.Margin._
 
    // use an enumeration value in a test
    var currentMargin = TOP
     
    // later in the code ...
    if (currentMargin == TOP) println("working on Top")
 
    // print all the enumeration values
    import com.cgi.Margin
    Margin.values foreach println
    
    // to string
    println(s"toString : ${currentMargin.toString}")
}