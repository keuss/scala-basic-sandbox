package com.cgi

/**
 * @author galloisg
 */
case class User(
  id: Int,
  firstName: String,
  lastName: String,
  age: Int,
  gender: Option[String])