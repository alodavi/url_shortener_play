package controllers

import models.{UrlRecord, UrlRecords}
import play.api.mvc._
import services.UrlServices

import scala.util.{Failure, Success}

object Application extends Controller {

  def index = Action {
    Ok(views.html.main())
  }

  def showUrls(url:String) = Action { implicit request =>
    val absUrl = routes.Application.index().absoluteURL()
    val generatedUrl = UrlRecords.find(url) match {
      case Success(c) => c.newUrl
      case Failure(e) => UrlServices.generateTinyUrl(url,absUrl)
    }
    Ok(UrlServices.toJson(url,generatedUrl))
  }

}
