name := """PlayTutorials"""
organization := "com.deb.b2c"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.8"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.1" % Test

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-slick" % "3.0.0",
  "com.typesafe.play" %% "play-slick-evolutions" % "3.0.0"
)

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.30"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.deb.b2c.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.deb.b2c.binders._"
