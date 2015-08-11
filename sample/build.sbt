name := "neuland-play-plugin-strawman-sample"

version := "1.0"

organization := "de.neuland"

organizationName := "neuland bremen GmbH"

organizationHomepage := Some(new URL("http://www.neuland-bfi.de"))

lazy val module = project.in(file("module")).enablePlugins(PlayScala)

lazy val main = project.in(file(".")).enablePlugins(PlayScala).dependsOn(module)
