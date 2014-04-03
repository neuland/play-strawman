package de.neuland.play.strawman

import play.api.templates.Html

trait StrawmanConfig {

  val strawmanPages: Map[String, Map[String, Html]]

  final def overview: Map[String, Set[String]] = {
    strawmanPages.mapValues((a: Map[String, Html]) => a.keySet)
  }

  final def find(url: String): Option[Html] = {
    strawmanPages.find(_._2.contains(url)) match {
      case Some((a, b)) => b.get(url)
      case _ => None
    }
  }

}

object StrawmanConfig {

  private var config: StrawmanConfig = null

  def setConfig(configuration: StrawmanConfig) = {
    config = configuration
  }

  def apply(): StrawmanConfig = {
    config
  }

}

