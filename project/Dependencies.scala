import sbt._

object Dependencies {
  lazy val logging: Seq[ModuleID] = Seq(
    "ch.qos.logback" % "logback-classic" % "1.5.18",
    "net.logstash.logback" % "logstash-logback-encoder" % "8.1"
  )

  lazy val server: Seq[ModuleID] = Seq(
    tapir
  ).flatten

  lazy val endpoint: Seq[ModuleID] = Seq(
    tapir
  ).flatten

  lazy val gendoc: Seq[ModuleID] = Seq(
    scopt,
    betterFiles,
    tapirOpenAPISpec
  ).flatten

  val tapirVersion = "1.11.25"
  lazy val tapir: Seq[ModuleID] = Seq(
    "com.softwaremill.sttp.tapir" %% "tapir-core" % tapirVersion,
    "com.softwaremill.sttp.tapir" %% "tapir-play-server" % tapirVersion,
    "com.softwaremill.sttp.tapir" %% "tapir-json-play" % tapirVersion
  )

  lazy val tapirOpenAPISpec: Seq[ModuleID] = Seq(
    "com.softwaremill.sttp.tapir" %% "tapir-openapi-docs" % tapirVersion,
    "com.softwaremill.sttp.apispec" %% "openapi-circe-yaml" % "0.11.9"
  )

  lazy val scopt: Seq[ModuleID] = Seq(
    "com.github.scopt" %% "scopt" % "4.1.0"
  )

  lazy val betterFiles: Seq[ModuleID] = Seq(
    "com.github.pathikrit" %% "better-files" % "3.9.2"
  )
}
