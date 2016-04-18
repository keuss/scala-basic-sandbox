package com.cgi

import org.joda.time.{ DateTime, LocalDate, LocalTime }
import org.joda.time.format.DateTimeFormat


/**
 * @author galloisg
 */
object DateTest extends App {
  
  // http://joda-time.sourceforge.net/apidocs/org/joda/time/format/DateTimeFormat.html
  
  val localDateFormat = "yyyyMMdd"
  val dateTimeFormat = "yyyyMMddHHmmss"
  val localTimeFormat = "HHmmss"

  lazy val localDateFormatter = DateTimeFormat.forPattern(localDateFormat)
  lazy val dateTimeFormatter = DateTimeFormat.forPattern(dateTimeFormat)
  lazy val localTimeFormatter = DateTimeFormat.forPattern(localTimeFormat)
  
  val now = localDateFormatter.print(DateTime.now)
  println(now)
  
  val now2 = dateTimeFormatter.print(DateTime.now)
  println(now2)
}