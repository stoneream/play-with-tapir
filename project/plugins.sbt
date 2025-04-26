addSbtPlugin("org.playframework" % "sbt-plugin" % "3.0.7")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.2")
addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.12.1")
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "2.2.0")

libraryDependencySchemes += "org.scala-lang.modules" %% "scala-xml" % VersionScheme.Always
