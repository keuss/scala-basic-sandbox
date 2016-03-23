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

  // apply
  val u = (User.apply _) (2, "Johanna", "Doe", 30, Some("meuf"))
  println(s"u apply:${(User.apply _)}")
  println(s"u:${u}")
}