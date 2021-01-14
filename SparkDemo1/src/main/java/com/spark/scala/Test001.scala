package com.spark.scala

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test001 {
  def main(args: Array[String]): Unit = {
    //创建spark配置对象
    val conf = new SparkConf();
    conf.setAppName("WordCountScala")
    //配置master属性
    conf.setMaster("local")
    //通过conf创建sc
    val sc = new SparkContext(conf);

    //加载文本文件
    val rdd1:RDD[String] = sc.textFile("d:/scala/scores.txt");
//    val rdd1:RDD[String] = sc.textFile(args(0));

    val rdd2:RDD[String] = rdd1.map(x=>(x,null)).repartition(4).reduceByKey {
      case (v1, v2) =>
        null
    }.map {
      case (k, v) =>
        k
    }

    val rdd3:RDD[String] = rdd1.map(x=>(x,null)).repartition(4).reduceByKey (
      (_ , _) => null
    ).map{
      case (a,v) => a
    }

    rdd2.collect().foreach(println)
    rdd3.collect().foreach(println)
//    rdd1.collect().foreach(println)


  }
}
