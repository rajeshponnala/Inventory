package controllers
import play.api.mvc._

object Products extends Controller {

  def products = Action{
     Ok("HelloWorld")
  }

}
