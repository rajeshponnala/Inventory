package Tables
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = scala.slick.driver.MySQLDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: scala.slick.driver.JdbcProfile
  import profile.simple._
  import scala.slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import scala.slick.jdbc.{GetResult => GR}
  
  /** DDL for all tables. Call .create to execute. */
  lazy val ddl = Customers.ddl ++ Orders.ddl ++ Products.ddl
  
  /** Entity class storing rows of table Customers
   *  @param id Database column id DBType(INT), PrimaryKey
   *  @param name Database column Name DBType(VARCHAR), Length(45,true)
   *  @param address Database column Address DBType(VARCHAR), Length(100,true)
   *  @param email Database column Email DBType(VARCHAR), Length(45,true), Default(None)
   *  @param phone Database column Phone DBType(VARCHAR), Length(45,true) */
  case class CustomersRow(id: Int, name: String, address: String, email: Option[String] = None, phone: String)
  /** GetResult implicit for fetching CustomersRow objects using plain SQL queries */
  implicit def GetResultCustomersRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[String]]): GR[CustomersRow] = GR{
    prs => import prs._
    CustomersRow.tupled((<<[Int], <<[String], <<[String], <<?[String], <<[String]))
  }
  /** Table description of table Customers. Objects of this class serve as prototypes for rows in queries. */
  class Customers(_tableTag: Tag) extends Table[CustomersRow](_tableTag, "Customers") {
    def * = (id, name, address, email, phone) <> (CustomersRow.tupled, CustomersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, name.?, address.?, email, phone.?).shaped.<>({r=>import r._; _1.map(_=> CustomersRow.tupled((_1.get, _2.get, _3.get, _4, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id DBType(INT), PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.PrimaryKey)
    /** Database column Name DBType(VARCHAR), Length(45,true) */
    val name: Column[String] = column[String]("Name", O.Length(45,varying=true))
    /** Database column Address DBType(VARCHAR), Length(100,true) */
    val address: Column[String] = column[String]("Address", O.Length(100,varying=true))
    /** Database column Email DBType(VARCHAR), Length(45,true), Default(None) */
    val email: Column[Option[String]] = column[Option[String]]("Email", O.Length(45,varying=true), O.Default(None))
    /** Database column Phone DBType(VARCHAR), Length(45,true) */
    val phone: Column[String] = column[String]("Phone", O.Length(45,varying=true))
  }
  /** Collection-like TableQuery object for table Customers */
  lazy val Customers = new TableQuery(tag => new Customers(tag))
  
  /** Entity class storing rows of table Orders
   *  @param id Database column id DBType(INT), PrimaryKey
   *  @param orderno Database column OrderNo DBType(VARCHAR), Length(45,true)
   *  @param customerid Database column CustomerId DBType(INT)
   *  @param date Database column Date DBType(DATETIME), Default(None) */
  case class OrdersRow(id: Int, orderno: String, customerid: Int, date: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching OrdersRow objects using plain SQL queries */
  implicit def GetResultOrdersRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[java.sql.Timestamp]]): GR[OrdersRow] = GR{
    prs => import prs._
    OrdersRow.tupled((<<[Int], <<[String], <<[Int], <<?[java.sql.Timestamp]))
  }
  /** Table description of table Orders. Objects of this class serve as prototypes for rows in queries. */
  class Orders(_tableTag: Tag) extends Table[OrdersRow](_tableTag, "Orders") {
    def * = (id, orderno, customerid, date) <> (OrdersRow.tupled, OrdersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, orderno.?, customerid.?, date).shaped.<>({r=>import r._; _1.map(_=> OrdersRow.tupled((_1.get, _2.get, _3.get, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id DBType(INT), PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.PrimaryKey)
    /** Database column OrderNo DBType(VARCHAR), Length(45,true) */
    val orderno: Column[String] = column[String]("OrderNo", O.Length(45,varying=true))
    /** Database column CustomerId DBType(INT) */
    val customerid: Column[Int] = column[Int]("CustomerId")
    /** Database column Date DBType(DATETIME), Default(None) */
    val date: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("Date", O.Default(None))
  }
  /** Collection-like TableQuery object for table Orders */
  lazy val Orders = new TableQuery(tag => new Orders(tag))
  
  /** Entity class storing rows of table Products
   *  @param id Database column id DBType(INT), PrimaryKey
   *  @param name Database column Name DBType(VARCHAR), Length(45,true)
   *  @param description Database column Description DBType(VARCHAR), Length(500,true), Default(None) */
  case class ProductsRow(id: Int, name: String, description: Option[String] = None)
  /** GetResult implicit for fetching ProductsRow objects using plain SQL queries */
  implicit def GetResultProductsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[String]]): GR[ProductsRow] = GR{
    prs => import prs._
    ProductsRow.tupled((<<[Int], <<[String], <<?[String]))
  }
  /** Table description of table Products. Objects of this class serve as prototypes for rows in queries. */
  class Products(_tableTag: Tag) extends Table[ProductsRow](_tableTag, "Products") {
    def * = (id, name, description) <> (ProductsRow.tupled, ProductsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, name.?, description).shaped.<>({r=>import r._; _1.map(_=> ProductsRow.tupled((_1.get, _2.get, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id DBType(INT), PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.PrimaryKey)
    /** Database column Name DBType(VARCHAR), Length(45,true) */
    val name: Column[String] = column[String]("Name", O.Length(45,varying=true))
    /** Database column Description DBType(VARCHAR), Length(500,true), Default(None) */
    val description: Column[Option[String]] = column[Option[String]]("Description", O.Length(500,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Products */
  lazy val Products = new TableQuery(tag => new Products(tag))
}