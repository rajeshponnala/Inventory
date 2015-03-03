package models

import play.api.Play._
import Tables._
import models._
import play.api.libs.json._
import play.api.libs.functional.syntax._
import Tables.profile.simple._

object Product {

  val db = DbUtils.connection

  def getProducts() : List[Tables.ProductsRow]= db.withSession { implicit Session =>
       Tables.Products.list
  }

}
