package main.scala

import main.scala.model.{JSONString, JSON}

object Demo
{
  def main(args: Array[String]): Unit =
  {
    val json: JSON = JSONString("name", "Akif")

    println(json)
  }
}