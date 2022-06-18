package dev.insideyou
package diamond_architecture
package usecase1

lazy val make: Controller =
  ControllerImpl.make(
    ControllerImpl
      .Dependencies
      .make(
        BoundaryImpl.make(
          BoundaryImpl
            .Dependencies
            .make(
              PersistenceImpl.make
            )
        )
      )
  )
