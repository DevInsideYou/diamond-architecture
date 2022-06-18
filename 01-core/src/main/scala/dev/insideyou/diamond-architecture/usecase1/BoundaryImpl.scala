package dev.insideyou
package diamond_architecture
package usecase1

object BoundaryImpl:
  def make(dependencies: Dependencies): Boundary =
    new:
      override def countPicturesOf(topic: String): Result =
        dependencies.countPicturesOf(topic)

  trait Dependencies extends Persistence

  object Dependencies:
    def make(persistence: Persistence): Dependencies =
      new Dependencies:
        export persistence.*
