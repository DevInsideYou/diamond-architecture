package dev.insideyou
package diamond_architecture
package usecase1

trait Boundary:
  def countPicturesOf(topic: String): Result
