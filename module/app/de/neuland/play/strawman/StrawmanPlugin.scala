package de.neuland.play.strawman

import play.api.{Logger, Play}
import play.api.Play.current
import play.api.templates.Html

object StrawmanPlugin {

  private val defaultConfigurationClass = "strawman.StrawmanPages"
  private val isActive: Boolean = loadConfiguration

  def enabled(): Boolean = {
    isActive
  }

  private def loadConfiguration: Boolean = {
    Play.configuration.getBoolean("strawman.active").getOrElse(false) && loadConfigurationClass
  }

  private def loadConfigurationClass: Boolean = {
    var configurationLoaded = false
    val configurationClassName = getConfigurationClassName()

    try {
      val newInstance = Play.classloader.loadClass(configurationClassName).newInstance()
      val applyMethod = Play.classloader.loadClass(configurationClassName).getDeclaredMethod("apply")
      StrawmanConfig.strawmanPages = applyMethod.invoke(newInstance).asInstanceOf[Map[String, Map[String, Html]]]
      configurationLoaded = true
    } catch {
      case e: Exception => Logger.error("Error loading Configuration class '%s'. See documentation for correct format. Disabling Strawman ...".format(configurationClassName));
    }

    configurationLoaded
  }

  private def getConfigurationClassName(): String = {
    Play.configuration.getString("strawman.config") match {
      case Some(value) => value
      case None => {
        Logger.warn("Option 'strawman.config' is not set. Using default value 'strawman.StrawmanPages'")
        defaultConfigurationClass
      }
    }
  }

}

