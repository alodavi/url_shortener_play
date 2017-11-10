package services

object UrlServices {

  def generateTinyUrl(inputUrl:String, baseUrl: String):String = {
    baseUrl+randomNumber(inputUrl)
  }

  def randomNumber(url:String):Int={
     Math.floor(100000 + Math.random() * 900000).toInt
  }

}
