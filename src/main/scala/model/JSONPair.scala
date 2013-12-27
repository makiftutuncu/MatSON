package main.scala.model

/**
 * Represents a key-value pair in a JSON
 *
 * @author mehmetakiftutuncu
 */
case class JSONPair(pair: (String, Any))
{
  def key: String = pair._1
  def value: Any = pair._2

  /**
   * Gives a JSON formatted String representation of this pair
   *
   * @return
   *         JSON formatted String representation of this pair
   */
  def toJSON: String = "\"" + pair._1 + "\":" + getFormattedValue(pair._2)

  /**
   * Gets the value with or without the enclosing quotes according to it's type
   *
   * @param value
   *              A value to match the type
   * @return
   *         Value with or without the enclosing quotes according to it's type
   */
  private def getFormattedValue(value: Any): String = value match
  {
    case v: Char => "\"" + v + "\""
    case v: String => "\"" + v + "\""
    case v: MatSON => v.toJSON
    case _ => value.toString
  }

  override def toString = toJSON
}