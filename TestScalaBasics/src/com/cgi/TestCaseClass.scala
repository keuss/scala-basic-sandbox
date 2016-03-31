package com.cgi

/**
 * @author galloisg
 */
object TestCaseClass extends App {

  // case class are by default immutable
  val m = Model2("data1", "data2")
  println(m.copy(m.data1, m.data2, List("1", "2")))

  val user = User(2, "Johanna", "Doe", 30, Some("meuf"))
  val parent = ParentModel("data1", user)
  println(s"parent : ${parent}")

  // apply and tupled
  val u = (User.apply _) (2, "Johanna", "Doe", 30, Some("meuf"))
  // follow this method with `_' if you want to treat it as a partially applied function
  println(s"u apply:${(User.apply _)}")
  println(s"u:${u}")
  println(s"u apply bis:${User.apply(2, "Johanna", "Doe", 30, Some("meuf"))}")
  
  val tupleU = (2, "Johanna", "Doe", 30, Some("meuf"))
  val ut = (User.apply _).tupled(tupleU)
  println(s"ut apply:${(User.apply _).tupled}")
  println(s"ut:${ut}")
  
  // unapply (extractors)
  // http://danielwestheide.com/blog/2012/11/21/the-neophytes-guide-to-scala-part-1-extractors.html
  println(s"unapply:${(User.unapply(User(2, "Johanna", "Doe", 30, Some("meuf"))))}")
      
}