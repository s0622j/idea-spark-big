package com.spark.scala

import org.apache.spark.{SparkConf, SparkContext}

/**
  *
  */
object DistinctDemo1 {
    def main(args: Array[String]): Unit = {
        val conf = new SparkConf()
        conf.setAppName("WordCountScala")
        conf.setMaster("local[4]") ;
        val sc = new SparkContext(conf)
        val rdd1 = sc.textFile("D:/scala/test.txt",4)
        val rdd2 = rdd1.flatMap(_.split(" "))
        val rdd3 = rdd2.distinct()

        rdd3.collect().foreach(println)
    }
}
