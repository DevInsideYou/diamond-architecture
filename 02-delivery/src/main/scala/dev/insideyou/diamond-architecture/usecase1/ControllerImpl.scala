package dev.insideyou
package diamond_architecture
package usecase1

object ControllerImpl:
  def make(gate: Gate): Controller =
    new:
      override def run(): Unit =
        println("─" * 100)

        println(gate.countPicturesOf("cats"))
        println(gate.countPicturesOf("dogs"))

        println("─" * 100)

  trait Gate extends Boundary

  object Gate:
    def make(boundary: Boundary): Gate =
      new Gate:
        export boundary.*
