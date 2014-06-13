import play.PlayScala

name := "neuland-play-plugin-strawman"

version := "0.9"

organization := "de.neuland"

organizationName := "neuland bremen GmbH"

organizationHomepage := Some(new URL("http://www.neuland-bfi.de"))

scalaVersion := "2.10.4"

lazy val main = project.in(file(".")).enablePlugins(PlayScala)