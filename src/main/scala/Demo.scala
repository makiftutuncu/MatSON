package main.scala

import main.scala.model._

/**
 * A dummy user type having different types of fields, for testing purposes
 *
 * @author mehmetakiftutuncu
 */
case class DummyUser(name: String, age: Integer, isMale: Boolean)
{
  def toJSON: String = MatSON("name" -> name, "age" -> age, "isMale" -> isMale).toJSON
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
    println(loginJson)
  }
}