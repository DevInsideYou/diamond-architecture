import Dependencies._
import Util._

ThisBuild / organization := "dev.insideyou"
ThisBuild / scalaVersion := "3.1.2"

ThisBuild / scalacOptions ++=
  Seq(
    "-deprecation",
    "-explain",
    "-feature",
    "-language:implicitConversions",
    "-unchecked",
    "-Xfatal-warnings",
    "-Yexplicit-nulls", // experimental (I've seen it cause issues with circe)
    "-Ykind-projector",
    "-Ysafe-init", // experimental (I've seen it cause issues with circe)
  ) ++ Seq("-rewrite", "-indent") ++ Seq("-source", "future-migration")

lazy val `diamond-architecture` =
  project
    .in(file("."))
    .settings(commonSettings)
    .aggregate(
      domain,
      `input-headers`,
      `output-headers`,
      core,
      delivery,
      persistence,
      main,
    )

lazy val domain =
  project
    .in(file("00-domain"))
    .settings(commonSettings)
    .settings(dependencies)

lazy val `input-headers` =
  project
    .in(file("01-input-headers"))
    .dependsOn(domain % Cctt)
    .settings(commonSettings)

lazy val `output-headers` =
  project
    .in(file("01-output-headers"))
    .dependsOn(domain % Cctt)
    .settings(commonSettings)

lazy val core =
  project
    .in(file("02-core"))
    .dependsOn(`input-headers` % Cctt)
    .dependsOn(`output-headers` % Cctt)
    .settings(commonSettings)

lazy val delivery =
  project
    .in(file("02-delivery"))
    .dependsOn(`input-headers` % Cctt)
    .settings(commonSettings)

lazy val persistence =
  project
    .in(file("02-persistence"))
    .dependsOn(`output-headers` % Cctt)
    .settings(commonSettings)

lazy val main =
  project
    .in(file("03-main"))
    .dependsOn(core % Cctt)
    .dependsOn(delivery % Cctt)
    .dependsOn(persistence % Cctt)
    .settings(commonSettings)

lazy val commonSettings = commonScalacOptions ++ Seq(
  update / evictionWarningOptions := EvictionWarningOptions.empty
)

lazy val commonScalacOptions = Seq(
  Compile / console / scalacOptions --= Seq(
    "-Wunused:_",
    "-Xfatal-warnings",
  ),
  Test / console / scalacOptions :=
    (Compile / console / scalacOptions).value,
)

lazy val dependencies = Seq(
  libraryDependencies ++= Seq(
    // main dependencies
  ),
  libraryDependencies ++= Seq(
    org.scalatest.scalatest,
    org.scalatestplus.`scalacheck-1-16`,
  ).map(_ % Test),
)
