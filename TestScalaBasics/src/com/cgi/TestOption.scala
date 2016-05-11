package com.cgi

/**
 * @author galloisg
 */
object TestOption extends App {


	println
	println("-----OPTION-----")
	val o = Some("value")
	val n = None

	println(o.getOrElse("nop"))
	println(n.isDefined)
	println(n.getOrElse("nop"))
  println(o.map(v => v))

	println(o.get)
	// println(n.get) java.util.NoSuchElementException: None.get

	val user = User(2, "Johanna", "Doe", 30, Some("meuf"))
  
	val gender = user.gender match {
  	case Some(g) => g
  	case None => "not specified"
	}
	println("Gender: " + gender)
  
  private def getModel: Option[Model] = {
    for {
      data1 <- Some("data1")
      data2 <- Some("data2")
      data3 <- Some("data3")
    } yield Model(data1, data2, data3)
  }
  
  println
  println("-----yield-----")
  println(getModel)
  
  val testStr: Option[String] =  for {
      data1 <- Some("data1")
      data2 <- Some("data2")
      data3 <- Some("data3")
    } yield s"$data1, $data2, $data3"
  
  println
  println("-----testStr avec fold sur option -----")
  println(testStr.fold("")(value => value))
  
  println
  println("-----test flatMap avec '_' -----")
  val per1: Personne = Personne("Keuss", Some("a.b@gmail.com"))
  val c1: Societe = Societe("Keuss corporation", Some(per1))
  // val c2: Societe = Societe("Keuss corporation", None)
  val proj1: Projet = Projet("idProjet1", 1000, Some(c1))
  
  println(proj1.client.flatMap(_.dirigeant).flatMap(_.email))
  // <=>
  println(proj1.client.flatMap(c => c.dirigeant).flatMap(d => d.email))
  
  println(c1.dirigeant.flatMap(_.email.map(_.toUpperCase)).getOrElse(""))
  
  println("-----test getOrElse avec 'User' -----")
  val userBis: Option[User] = Some(User(2, "Johanna", "Doe", 30, Some("meuf")))
  val userBis2: Option[User] = None
  println(s"userBis : ${userBis.getOrElse("")}")
  println(s"userBis2 : ${userBis2.getOrElse("")}")
  
  println("-----test for 1 -----")
  for {
    a <- Some("a")
    b <- None
    c <- Some("c")
  } {
    println(s"a:$a, b:$b, c:$c")
  }
  
  def doSomething(a: String, b: String, c: String): Boolean = {
    println(s"a:$a, b:$b, c:$c")
    true
  }
  
  println("-----test for 2 -----")
  val paramTest = "123456"
  val value = for {
    a <- Some("45")
    b <- Some("123456")
    c <- Some("53")
    res = doSomething(a, b, c)
  } yield {
    res
  }
  println(s"value:$value")
  
  
  val listOfOptions = List(None, None, None)
  println(listOfOptions.flatten.isEmpty)
  
  println("-----test for 3 -----")
  val valueTuple = (Some("a"), Some("b"), Seq(1, 2, 3))
  
  println(s"valueTuple:$valueTuple")
  
  val res = valueTuple match {
    case (Some(a), Some(b), Seq()) => s"Some all : $a, $b"
    case (Some(a), _, _) => s"Some a : $a"
    case (_, Some(b), _) => s"Some b : $b"
    case (_, _, seq) => s"Some seq : $seq"
    case _ => "Should not happen"
  }
  
  println(s"res:$res")
  
}