package main.scala.model

import scala.collection.mutable

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
  var fields: mutable.HashSet[JSONPair] = new mutable.HashSet[JSONPair]

  // Put given pairs into the map
  pairs.foreach(p => fields += JSONPair(p._1, p._2))

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
   *         The value of given element or None
   */
  def getElement(element: String): Any =
  {
    fields.find(p => p.key == element) match
    {
      //case Some(pair: JSONPair) => MatSON(pair.key -> pair.value)
      case Some(pair: JSONPair) => pair.value
      case _ => throw new NoSuchElementException("There is no element with key \"" + element + "\"!")
    }
  }
  def /(element: String) = getElement(element)

  override def toString = toJSON
}