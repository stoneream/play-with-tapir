import sbt._

object Dependencies {
  lazy val logging: Seq[ModuleID] = Seq(
    "ch.qos.logback" % "logback-classic" % "1.5.18",
    "net.logstash.logback" % "logstash-logback-encoder" % "8.1"
  )

  lazy val server: Seq[ModuleID] = Seq(
    tapir
  ).flatten

  val tapirVersion = "1.11.25"
  lazy val tapir: Seq[ModuleID] = Seq(
    "com.softwaremill.sttp.tapir" %% "tapir-core" % tapirVersion,
    "com.softwaremill.sttp.tapir" %% "tapir-play-server" % tapirVersion,
    "com.softwaremill.sttp.tapir" %% "tapir-json-play" % tapirVersion
  )
}
