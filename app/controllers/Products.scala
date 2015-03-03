package controllers
import play.api.mvc._
import play.api.Play._
import Tables._
import models._
import play.api.libs.json._
import play.api.libs.functional.syntax._
import Tables.profile.simple._

object Products extends Controller {

  implicit val productWrites = new Writes[Tables.ProductsRow] {
     def writes(p: Tables.ProductsRow) = Json.obj("id" -> p.id,"Name" -> p.name,"Description"->p.description)
  }
  def products = Action{
    Ok(Json.toJson(Product.getProducts()))
  }

}
