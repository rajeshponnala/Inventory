
package controllers
import play.api._
import play.api.mvc._
import play.api.libs.json._
import anorm._
import play.api.db.DB
import play.api.Play._
import Tables._
import play.api.libs.functional.syntax._

object Customers extends Controller {

  implicit val customerReads: Reads[Tables.CustomersRow] = (
  (JsPath \ "id").read[Int] and
  (JsPath \ "name").read[String] and
  (JsPath \ "address").read[String] and
  (JsPath \ "email").readNullable[String] and
  (JsPath \ "phone").read[String] 
  )(Tables.CustomersRow.apply _)

 
  def customers = Action {
    Ok("Hello Customers")
  }

  def postCustomer = Action(parse.json) { request =>
    val customer =  request.body.as[Tables.CustomersRow]
    DB.withConnection{ implicit c =>  
       val id: Option[Long] = SQL("insert into Inventory.Customers(Name,Address,Email,Phone) values({name},{address},{email},{phone})")
                            .on('name-> customer.name,'address->customer.address,'email-> customer.email.getOrElse(""),'phone->customer.phone)
                            .executeInsert()

      id.map(i => Ok(i.toString)).getOrElse(InternalServerError("Error in creating"))
    }
    
  }

}
 
