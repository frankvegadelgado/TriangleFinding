name := "Triangle"

version := "1.0"

scalaVersion := "2.12.0"

assemblyJarName in assembly := "rectangle.jar"

mainClass in assembly := Some("Main")

mainClass in (Compile,run) := Some("Main")

libraryDependencies += "io.jenetics" % "jenetics" % "4.1.0"