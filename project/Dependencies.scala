import sbt._

object Dependencies {
  object Versions {
    val gatling = "3.9.5"
  }

  lazy val gatling: Seq[ModuleID] = Seq(
    "io.gatling.highcharts" % "gatling-charts-highcharts" % Versions.gatling % "test",
    "io.gatling" % "gatling-test-framework" % Versions.gatling % "test"
  )

}
