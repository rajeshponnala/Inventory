package controllers
import play.api._
import play.api.mvc._
import play.api.libs.json._
import models.Customer._
import Tables.Tables._
import play.api.libs.functional.syntax._


object Customers extends Controller {

  implicit val customerReads = Json.reads[CustomersRow] 
  implicit val customerWrites = Json.writes[CustomersRow]


  def customers = Action {
    Ok(Json.toJson(getAll()))
   // Ok("hello")
  }

  def postCustomer = Action(parse.json) { request =>
    val result = Insert(request.body.as[CustomersRow])
    result.map(i => Ok(i.toString)).getOrElse(InternalServerError("Error in creating"))
   }
}

 
