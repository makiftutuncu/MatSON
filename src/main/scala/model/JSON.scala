package main.scala.model

/**
 * Represents an object with capabilities to convert to and from JSON
 *
 * @author mehmetakiftutuncu
 */
trait JSON
{
  /**
   * Converts this object to a JSON formatted String representation
   *
   * @return
   *         JSON formatted String representation of this object
   */
  def toJSON: String

  /**
   * Constructs the object from the given JSON formatted String representation
   *
   * @param json
   *             JSON formatted String representation of an object
   * @return
   *         Object constructed from the given JSON formatted String representation
   */
  def fromJSON(json: String): AnyRef

  override def toString = toJSON
}