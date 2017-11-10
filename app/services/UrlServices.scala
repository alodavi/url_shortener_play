package services

import java.net.URL

import scala.util.{Failure, Success, Try}

object UrlServices {

  def generateTinyUrl(inputUrl:String, baseUrl: String):String = {
    baseUrl+randomNumber(inputUrl)
  }

  def randomNumber(url:String):Int={
    validate(url) match {
      case Success(valid) => Math.floor(100000 + Math.random() * 900000).toInt
      case Failure(error) => throw new Exception("Invalid URL") //todo specific exception
    }
  }

  def validate(url:String)={
    Try { new URL(url) }
  }

}
