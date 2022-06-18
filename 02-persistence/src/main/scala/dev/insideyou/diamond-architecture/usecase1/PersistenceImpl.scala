package dev.insideyou
package diamond_architecture
package usecase1

object PersistenceImpl:
  lazy val make: Persistence =
    new:
      override def countPicturesOf(topic: String): Result =
        Result(if topic == "cats" then 1337 else 1338)
