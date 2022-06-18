package dev.insideyou
package diamond_architecture
package usecase1

trait Gate extends Persistence

object Gate:
  def make(persistence: Persistence): Gate =
    new Gate:
      export persistence.*

trait Persistence:
  def countPicturesOf(topic: String): Result
