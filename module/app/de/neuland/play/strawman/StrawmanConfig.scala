package de.neuland.play.strawman

import play.api.mvc.Result

protected object StrawmanConfig {

  var strawmanPages: () => Map[String, Map[StrawmanHttpMethod, () => Result]] = _

  final def overview: Map[String, Set[(String, String)]] = {
    strawmanPages().mapValues((a: Map[StrawmanHttpMethod, () => Result]) => a.keySet.map(key => (key.method, key.url)))
  }

  final def find(url: String, method: String): Option[() => Result] = {
    val httpMethod = StrawmanHttpMethod(url, method)

    strawmanPages().find(_._2.contains(httpMethod)) match {
      case Some((a, b)) => b.get(httpMethod)
      case _ => None
    }
  }

}