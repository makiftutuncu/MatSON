package main.scala.model

/**
 * Represents a JSON object
 *
 * @author mehmetakiftutuncu
 */
trait JSON
{
  /**
   * Gives a JSON formatted String representation
   *
   * @return JSON formatted String representation of this object
   */
  def toJSON: String
}