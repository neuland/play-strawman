package de.neuland.play.strawman

import play.api.{Logger, Play}
import play.api.Play.current

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
      StrawmanConfig.setConfig(Play.classloader.loadClass(configurationClassName).newInstance().asInstanceOf[StrawmanConfig])
      configurationLoaded = true
    } catch {
      case e: ClassNotFoundException => Logger.error("Configuration class '%s' not found. Disabling Strawman ...".format(configurationClassName));
      case e: Exception => Logger.error("Configuration class '%s' must extend 'de.neuland.play.strawman.StrawmanConfig'. Disabling Strawman ...".format(configurationClassName));
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

