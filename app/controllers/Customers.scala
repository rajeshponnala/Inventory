
package controllers
import play.api._
import play.api.mvc._
import play.api.libs.json._
import models.Customer._
import Tables._
import play.api.libs.functional.syntax._


object Customers extends Controller {

 implicit val customerWrites = new Writes[Tables.CustomersRow] {
  def writes(p: Tables.CustomersRow) = Json.obj(
     "id" -> p.id,
    "name" -> p.name,
    "address"-> p.address,
    "email" -> p.email,
    "phone" -> p.phone
   )
 }
 
  implicit val customerReads: Reads[Tables.CustomersRow] = (
  (JsPath \ "id").read[Int] and
  (JsPath \ "name").read[String] and
  (JsPath \ "address").read[String] and
  (JsPath \ "email").readNullable[String] and
  (JsPath \ "phone").read[String] 
  )(Tables.CustomersRow.apply _)

 
  def customers = Action {
    Ok(Json.toJson(getAll()))
  }

  def postCustomer = Action(parse.json) { request =>
    val result = Insert(request.body.as[Tables.CustomersRow])
    result.map(i => Ok(i.toString)).getOrElse(InternalServerError("Error in creating"))
   }
}

 
