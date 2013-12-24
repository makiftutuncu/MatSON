package main.scala

import main.scala.model._

/**
 * A dummy user type having different types of fields, for testing purposes
 *
 * @author mehmetakiftutuncu
 */
case class DummyUser(name: String, age: Integer, isMale: Boolean) extends JSON
{
  /**
   * Converts this object to a JSON formatted String representation
   *
   * @return
   *         JSON formatted String representation of this object
   */
  def toJSON: String = MatSON("name" -> name, "age" -> age, "isMale" -> isMale).toJSON

  def fromJSON(json: String): DummyUser = ???
}

object DummyUser
{
  /**
   * Constructs the object from the given JSON formatted String representation
   *
   * @param json
   *             JSON formatted String representation of an object
   * @return
   *         Object constructed from the given JSON formatted String representation
   */
  def fromJSON(json: String) =
  {
    (MatSON.getElement(json, "name"), MatSON.getElement(json, "age"), MatSON.getElement(json, "isMale")) match
    {
      case (Some(name), Some(age), Some(isMale)) => DummyUser(name, age.toInt, isMale.toBoolean)
      case _ => None
    }
  }
}

/**
 * Some test scenarios for testing purposes
 *
 * @author mehmetakiftutuncu
 */
object Demo
{
  def main(args: Array[String]): Unit =
  {
    val user = DummyUser("Akif", 22, isMale = true)
    println(user.toJSON)

    val userJson = MatSON("name" -> "Akif", "age" -> 22)
    val loginJson = MatSON("user" -> userJson, "timestamp" -> System.currentTimeMillis())
    println("Login json " + loginJson)
    println()

    val json = user.toJSON
    println("Finding elements in json")
    println("name -> " + MatSON.getElement(json, "name"))
    println("age -> " + MatSON.getElement(json, "age"))
    println("isMale -> " + MatSON.getElement(json, "isMale"))
    println()
    println("Finding elements in login json")
    println("name -> " + MatSON.getElement(loginJson.toJSON, "name"))
    println("timestamp -> " + MatSON.getElement(loginJson.toJSON, "timestamp"))
    println()

    println("Converting user back from json")
    val newUser = DummyUser.fromJSON(json)
    println("New user " + newUser)
  }
}