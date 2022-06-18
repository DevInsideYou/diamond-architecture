package dev.insideyou
package diamond_architecture
package usecase1

object BoundaryImpl:
  def make(gate: Gate): Boundary =
    new:
      override def countPicturesOf(topic: String): Result =
        gate.countPicturesOf(topic)

  trait Gate extends Persistence

  object Gate:
    def make(persistence: Persistence): Gate =
      new Gate:
        export persistence.*
