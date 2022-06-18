package dev.insideyou
package diamond_architecture
package usecase1

lazy val make: Controller =
  ControllerImpl.make(
    ControllerImpl
      .Gate
      .make(
        Boundary.make(
          Boundary
            .Gate
            .make(
              PersistenceImpl.make
            )
        )
      )
  )
