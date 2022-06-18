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

  def make(boundary: Boundary): Controller =
    make {
      new Dependencies:
        export boundary.*
    }
