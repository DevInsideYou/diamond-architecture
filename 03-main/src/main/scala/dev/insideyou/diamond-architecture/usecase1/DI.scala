package dev.insideyou
package diamond_architecture
package usecase1

lazy val make: Controller =
  ControllerImpl.make(
    ControllerImpl
      .Gate
      .make(
        BoundaryImpl.make(
          BoundaryImpl
            .Gate
            .make(
              PersistenceImpl.make
            )
        )
      )
  )
