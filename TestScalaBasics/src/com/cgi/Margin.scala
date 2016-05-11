package com.cgi

/**
 * From http://alvinalexander.com/scala/how-to-use-scala-enums-enumeration-examples
 */
object Margin extends Enumeration {
  type Margin = Value
  val TOP, BOTTOM, LEFT, RIGHT = Value
}