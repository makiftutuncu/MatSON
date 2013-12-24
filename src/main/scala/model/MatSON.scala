package main.scala.model

/**
 * A simple JSON library
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
   * Converts this object to a JSON formatted String representation
   *
   * @return
   *         JSON formatted String representation of this object
   */
  def toJSON: String = fields.mkString("{", ",", "}")

  /**
   * Gets the value of given element in the JSON representation of this object
   *
   * @param element
   *                Name of the element whose value will be returned
   *
   * @return
   *         The value of given element
   */
  def getElement(element: String) = MatSON.getElement(toJSON, element)

  override def toString = toJSON
}

object MatSON
{
  /**
   * Gets the value of given element in the given JSON formatted String
   *
   * @param json
   *             JSON formatted String in which the given element will be returned
   * @param element
   *                Name of the element whose value will be returned
   *
   * @return
   *         The value of given element
   */
  def getElement(json: String, element: String) =
  {
    // Format is like following "<key>":["]<value>["][,] where [] denotes optional
    val pairPattern = "\"(\\w+)\":\"?(\\w+)\"?,?".r

    val result = pairPattern.findAllIn(json).matchData.filter(matchedPair => matchedPair.group(1) == element)

    if(!result.isEmpty)
      Option(result.next().group(2))
    else
      None

    // This pattern looks like it can divide JSON into it's pairs, so keep it here. :)
    // {(\"\\w+\":\"?\\w+\"?,?)*}
  }
}