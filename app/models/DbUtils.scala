package models
import play.api.Play._
import scala.slick.jdbc.{GetResult, StaticQuery => Q}
import scala.slick.jdbc.JdbcBackend.Database
import Q.interpolation


object DbUtils {
  def connection = {
   val config= current.configuration
   Database.forURL(config.getString("db.default.url").get,driver=config.getString("db.default.slick.driver").get,user="root",password="root")
  }

}
