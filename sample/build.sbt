name := "neuland-play-plugin-strawman-sample"

version := "1.0"

organization := "de.neuland"

organizationName := "neuland bremen GmbH"

organizationHomepage := Some(new URL("http://www.neuland-bfi.de"))

play.Project.playScalaSettings

// sub-project this depends on
val module = RootProject(file("../module"))
lazy val application = project.in(file(".")).dependsOn(module)