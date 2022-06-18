package dev.insideyou
package diamond_architecture
package usecase1

object ControllerImpl:
  def make(dependencies: Dependencies): Controller =
    new:
      override def run(): Unit =
        println("─" * 100)

        println(dependencies.countPicturesOf("cats"))
        println(dependencies.countPicturesOf("dogs"))

        println("─" * 100)

  trait Dependencies extends Boundary

  object Dependencies:
    def make(boundary: Boundary): Dependencies =
      new Dependencies:
        export boundary.*
