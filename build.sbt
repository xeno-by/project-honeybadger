scalaVersion := "2.11.6"

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies += "org.scalameta" % "scalameta" % "0.1.0-SNAPSHOT" cross CrossVersion.binary

libraryDependencies += "org.scalameta" % "scalahost" % "0.1.0-SNAPSHOT" cross CrossVersion.full

libraryDependencies += "org.scala-lang" % "scala-actors" % "2.11.6"
