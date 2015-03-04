package models
import anorm._
import play.api.db.DB
import play.api.Play._
import Tables._
import play.api.libs.functional.syntax._
import anorm.SqlParser._

object Customer {

  def getAll() : Seq[Tables.CustomersRow] = DB.withConnection { implicit c =>
      SQL("select * From Inventory.Customers").map { case Row(id: Int,name: String,address: String,Some(email: String),phone: String) => Tables.CustomersRow(id,name,address,Some(email),phone) }.list
  }

  def Insert(customer: Tables.CustomersRow) : Option[Long]= DB.withConnection{ implicit c =>
        SQL("insert into Inventory.Customers(Name,Address,Email,Phone) values({name},{address},{email},{phone})")
                            .on('name-> customer.name,'address->customer.address,'email-> customer.email.getOrElse(""),'phone->customer.phone)
                            .executeInsert()
  }

}
