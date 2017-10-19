package fr.jeremie

import org.apache.spark.sql.SparkSession

object App {
  def main(args: Array[String]) {

    println("Hello World!")

    val logFile = "README.md" // Should be some file on your system

//    System.setProperty("hadoop.home.dir", "D:\\binaires\\hadoop")

    val spark = SparkSession.builder.appName("Simple Application").master("local[2]").getOrCreate()


    val logData = spark.read.textFile(logFile).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println(s"Lines with a: $numAs, Lines with b: $numBs")
    spark.stop()
  }
}