package main.scala.model

/**
 * Converts an object to JSON formatted String
 *
 * @author mehmetakiftutuncu
 */
case class MatSON(pairs: (String, Any)*)
{
  /**
   * Represents the fields of an object as a sequence of JSONPair
   */
  val fields: Seq[JSONPair] = pairs.map
  {
    case (key, value) => JSONPair(key, value)
  }

  /**
   * Gives the JSON formatted String representation
   *
   * @return
   *         JSON formatted String representation
   */
  def toJSON: String = "{" + fields.mkString(",") + "}"

  override def toString = toJSON
}
