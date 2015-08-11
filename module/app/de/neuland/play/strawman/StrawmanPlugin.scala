package de.neuland.play.strawman

import play.api.Play.current
import play.api.mvc.Result
import play.api.{Logger, Play}

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

    StrawmanConfig.strawmanPages = () => {
      val configurationClassName = getConfigurationClassName()
      try {
        val newInstance = Play.classloader.loadClass(configurationClassName).newInstance()
        val applyMethod = Play.classloader.loadClass(configurationClassName).getDeclaredMethod("apply")
        applyMethod.invoke(newInstance).asInstanceOf[Map[String, Map[String, () => Result]]]
      } catch {
        case e: Exception => {
          Logger.error(s"Error loading configuration class '${configurationClassName}'.", e)
          Map[String, Map[String, () => Result]]()
        }
      }
    }

    configurationLoaded = true
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

