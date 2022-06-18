package dev.insideyou
package diamond_architecture
package usecase1

lazy val make: Controller =
  ControllerImpl.make(
    BoundaryImpl.make(
      PersistenceImpl.make
    )
  )
