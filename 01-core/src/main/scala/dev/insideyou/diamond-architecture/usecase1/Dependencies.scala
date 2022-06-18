package dev.insideyou
package diamond_architecture
package usecase1

trait Persistence:
  def countPicturesOf(topic: String): Result
