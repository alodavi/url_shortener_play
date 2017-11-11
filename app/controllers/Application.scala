package controllers

import models.UrlRecord
import play.api.mvc._
import services.UrlServices

object Application extends Controller {

  def index = Action {
    Ok(views.html.main())
  }

  def showUrls(url:String) = Action { implicit request =>
    val absUrl = routes.Application.index().absoluteURL()
    val generatedUrl = UrlServices.generateTinyUrl(url,absUrl)
    val urlRecord = UrlRecord(None,url,generatedUrl)
    Ok(UrlServices.toJson(urlRecord.url,urlRecord.newUrl))
  }

}
