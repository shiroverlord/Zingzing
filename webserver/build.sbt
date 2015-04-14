name := """webserver"""

version := "1.0-SNAPSHOT"

javacOptions += "-g"

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "org.json" % "json" % "20140107"
)

lazy val root = (project in file(".")).enablePlugins(PlayJava)