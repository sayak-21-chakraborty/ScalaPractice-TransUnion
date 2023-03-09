package scala.PracticeProgram1

import scala.io.Source
import scala.collection.mutable.Map


/* Problem Statement -

Word count:
Take a text file as data read it and find each word count and print the word used maximum time */

object PracticeProgram1 {

  private val map: Map[String, Int] = Map()

  def main(args: Array[String]): Unit = {
    val fileName = "F:\\ScalaTextFile\\InputFile.txt"

    var wordList: Array[String] = Array();

    for (line <- Source.fromFile(fileName).getLines()) {
//        println(line)
      wordList = line.split(" ")
//        println(wordList)
//      wordList.foreach(println)

      wordList.foreach(
        key =>
          if (map.contains(key))
            map(key) = map(key) + 1
          else
            map(key) = 1
      )

//      for(word <- wordList){
//        if (map.contains(word))
//          map(word) = map(word) + 1
//        else
//          map(word) = 1
//      }
    }
//    println(map)
    map.keys.foreach(key => println("Word: "+key+" , Occurrence: "+map(key)))
//    val fileContents = Source.fromFile(fileName).getLines.mkString
//    println(fileContents)
    var maxWord: String = ""
    var max: Int = 0

    map.keys.foreach{
      key =>
        if(map(key)>max) {
          max = map(key)
          maxWord = key

        }
    }

    println(s"Max Word: $maxWord, Occurrence: $max")


  }
}
