package com.spark.scala

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ArrayBuffer

object MapDemo1 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf();
    conf.setAppName("WordCountScala")
    conf.setMaster("local[2]")  //开启2个线程 模拟并发程序
    val sc = new SparkContext(conf);
    val rdd1:RDD[String] = sc.textFile("D:/scala/test.txt",2);  //设置分区数
    val rdd2:RDD[String] = rdd1.flatMap(line => line.split(" ")) //    val rdd2 = rdd1.flatMap(line=>line.split(" "))


    //todo mapPartitions
//    val rdd3 = rdd2.mapPartitions(it => {
////      var list = Nil;
//      val buf = ArrayBuffer[String]();
//      val tname = Thread.currentThread().getName
//      println(tname + ":mapPartition stard");
//      for (e <- it){
//        buf.+=("_" + e);
//
//      }
//      buf.iterator
//    })

    //todo mapPartitionsWithIndex
    val rdd3 = rdd2.mapPartitionsWithIndex((index,it) => {
      //      var list = Nil;
      val buf = ArrayBuffer[String]();
      val tname = Thread.currentThread().getName
      println(tname + ":" + index + ":mapPartition stard");
      for (e <- it){
        buf.+=("_" + e);

      }
      buf.iterator
    })


    val rdd33 = rdd3.map(w => {
      val tname = Thread.currentThread().getName
      println(tname + ":map" + w);
      (w,1)});
    val rdd4 = rdd33.reduceByKey(_ + _);

    rdd4.collect().foreach(println)
  }
}
