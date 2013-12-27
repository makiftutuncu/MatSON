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
   * Converts this object to a JSON representation
   *
   * @return
   *         JSON representation of this object
   */
  def toJSON: MatSON = MatSON("name" -> name, "age" -> age, "isMale" -> isMale)
}

object DummyUser
{
  /**
   * Constructs the object from the given JSON representation
   *
   * @param json
   *             JSON representation of an object
   * @return
   *         Object constructed from the given JSON representation
   */
  def fromJSON(json: MatSON): DummyUser = DummyUser((json / "name").asInstanceOf[String], (json / "age").asInstanceOf[Int], (json / "isMale").asInstanceOf[Boolean])
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
    val userJson = DummyUser("Akif", 22, isMale = true).toJSON
    val loginJson = MatSON("user" -> userJson, "timestamp" -> System.currentTimeMillis())

    println("Login json\n" + loginJson)
    println()

    println("timestamp field in login json\n" + loginJson / "timestamp")
    println()

    println("user field in login json\n" + loginJson / "user")
    println()

    println("name field in user in login json\n" + (loginJson / "user").asInstanceOf[MatSON] / "name")
    println()

    println("user created back from it\'s json " + DummyUser.fromJSON(userJson))
  }
}