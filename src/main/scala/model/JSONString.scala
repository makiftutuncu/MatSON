package main.scala.model

/**
 * Represents a JSONPair whose value is a String
 *
 * @author mehmetakiftutuncu
 */
case class JSONString(k: String, v: String) extends JSONPair[String](k, v)
{
  def toJSON: String = "\"" + k + "\":\"" + v + "\""
}