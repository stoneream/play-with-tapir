lazy val baseSettings: Project => Project =
  _.settings(
    scalaVersion := "2.13.12",
    name := "playframework-template",
    version := "1.0-SNAPSHOT",
    organization := "io.github.stoneream"
  )

lazy val root = (project in file("."))
  .configure(baseSettings)
  .aggregate(server, gatling)

lazy val server = (project in file("server"))
  .configure(baseSettings)
  .enablePlugins(PlayScala)
  .disablePlugins(PlayLayoutPlugin)
  .settings(
    libraryDependencies += guice
  )

lazy val gatling = (project in file("gatling"))
  .configure(baseSettings)
  .enablePlugins(GatlingPlugin)
  .settings(libraryDependencies ++= Dependencies.gatling)
