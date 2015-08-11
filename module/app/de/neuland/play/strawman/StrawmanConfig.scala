package de.neuland.play.strawman

import play.api.mvc.Result

protected object StrawmanConfig {

  var strawmanPages: () => Map[String, Map[String, () => Result]] = _

  final def overview: Map[String, Set[String]] = {
    strawmanPages().mapValues((a: Map[String, () => Result]) => a.keySet)
  }

  final def find(url: String): Option[() => Result] = {
    strawmanPages().find(_._2.contains(url)) match {
      case Some((a, b)) => b.get(url)
      case _ => None
    }
  }

}
