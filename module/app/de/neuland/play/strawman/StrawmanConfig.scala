package de.neuland.play.strawman

import play.api.templates.Html

protected object StrawmanConfig {

  var strawmanPages: () => Map[String, Map[String, Html]] = _

  final def overview: Map[String, Set[String]] = {
    strawmanPages().mapValues((a: Map[String, Html]) => a.keySet)
  }

  final def find(url: String): Option[Html] = {
    strawmanPages().find(_._2.contains(url)) match {
      case Some((a, b)) => b.get(url)
      case _ => None
    }
  }

}
