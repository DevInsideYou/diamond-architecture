package dev.insideyou
package diamond_architecture
package usecase1

object BoundaryImpl:
  def make(dependencies: Dependencies): Boundary =
    new:
      override def countPicturesOf(topic: String): Result =
        dependencies.countPicturesOf(topic)

  trait Dependencies extends Persistence

  def make(persistence: Persistence): Boundary =
    make {
      new Dependencies:
        export persistence.*
    }
