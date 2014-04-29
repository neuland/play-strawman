package de.neuland.play.strawman

import play.api.templates.Html
import play.api.mvc.SimpleResult

protected object StrawmanConfig {

  var strawmanPages: () => Map[String, Map[String, SimpleResult]] = _

  final def overview: Map[String, Set[String]] = {
    strawmanPages().mapValues((a: Map[String, SimpleResult]) => a.keySet)
  }

  final def find(url: String): Option[SimpleResult] = {
    strawmanPages().find(_._2.contains(url)) match {
      case Some((a, b)) => b.get(url)
      case _ => None
    }
  }

}
