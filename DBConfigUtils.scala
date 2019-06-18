package com.deb.b2c.utils

import slick.basic.BasicProfile
import slick.basic.DatabaseConfig
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile
import com.mysql.jdbc.integration.jboss.ExtendedMysqlExceptionSorter
import com.typesafe.config.ConfigFactory
import com.typesafe.config.Config

object DBConfigUtils {

  def getDatabaseConfigProvider(): DatabaseConfigProvider = {

    val config: Config = ConfigFactory.parseString(
      """play {
      |  driver = "slick.driver.MySQLDriver$"
      |  db = {
      |    driver = "com.mysql.jdbc.Driver"
      |    url = "jdbc:mysql://localhost:3306/play"
      |    user="root"
      |    password="Deb123"
      |  }
      |}
      |""".stripMargin)

    val dbConfig: DatabaseConfig[JdbcProfile] = DatabaseConfig.forConfig[JdbcProfile]("play", config)

    var databaseConfigProvider = new DatabaseConfigProvider {
      // Cast is necessary, otherwise cannot get to compile
      override def get[P <: BasicProfile]: DatabaseConfig[P] = dbConfig.asInstanceOf[DatabaseConfig[P]]
    }
    databaseConfigProvider
  }
}