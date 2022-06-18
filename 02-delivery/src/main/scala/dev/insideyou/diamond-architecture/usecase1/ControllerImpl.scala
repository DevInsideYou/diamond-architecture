package dev.insideyou
package diamond_architecture
package usecase1

object ControllerImpl:
  def make(boundary: Boundary): Controller =
    new:
      override def run(): Unit =
        println("─" * 100)

        println(boundary.countPicturesOf("cats"))
        println(boundary.countPicturesOf("dogs"))

        println("─" * 100)
