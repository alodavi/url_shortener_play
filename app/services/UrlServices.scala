package services

import java.net.URL

import models.{UrlRecord, UrlRecords}
import play.api.libs.json.{JsObject, JsString}

import scala.util.{Failure, Success, Try}

object UrlServices {

  def generateTinyUrl(inputUrl:String, baseUrl: String):String = {
    val tiny = baseUrl+randomNumber(inputUrl)
    val record = UrlRecord(None,url = inputUrl, newUrl = tiny)
    UrlRecords.create(record)
    tiny
  }

  private def randomNumber(url:String):Int={
    validate(url) match {
      case Success(valid) => Math.floor(100000 + Math.random() * 900000).toInt
      case Failure(error) => throw new Exception("Invalid URL") //todo specific exception
    }
  }

  private def validate(url:String)={
    Try { new URL(url) }
  }

  def toJson(url: String, tiny: String): JsObject ={
    JsObject(Seq(
      "url" -> JsString(url),
      "new url" -> JsString(tiny)
    )
    )
  }

}
