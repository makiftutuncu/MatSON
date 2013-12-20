package main.scala.model

/**
 * Represents a key-value pair in a JSON
 *
 * @author mehmetakiftutuncu
 */
abstract class JSONPair[T](val key: String, val value: T) extends JSON
{
  /**
   * Gives a JSON formatted String representation of this pair
   *
   * @return JSON formatted String representation of this pair
   */
  override def toString: String = toJSON
}