package main.scala.model

/**
 * Represents an object with capabilities to convert to and from JSON
 *
 * @author mehmetakiftutuncu
 */
trait JSON
{
  /**
   * Converts this object to a JSON representation
   *
   * @return
   *         JSON representation of this object
   */
  def toJSON: MatSON

  override def toString = toJSON.toString
}