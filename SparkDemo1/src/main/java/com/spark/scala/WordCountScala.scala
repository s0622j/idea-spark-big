package com.spark.scala

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCountScala {
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
    println(rdd1.map(_.split(" ").length).reduce(_ + _))

    //压扁
    val rdd2:RDD[String] = rdd1.flatMap(line => {println("flatmap：" + line);line.split(" ")}) //    val rdd2 = rdd1.flatMap(line=>line.split(" "))
    println(rdd2.count())

    //映射 w=>(w,1)
    val rdd3: RDD[(String,Int)] = rdd2.map((_ , 1)); //    val rdd3 = rdd2.map(w => (w , 1));

    rdd3.countByKey().foreach(println(_))

    //聚合 按照key聚合，指定分区数
    val rdd4 = rdd3.reduceByKey(_ + _ ,3);
    rdd4.saveAsTextFile("d:/scala/out")
    rdd4.collect().foreach(println)

    val rdd5 = rdd4.map(_._2)
    val count = rdd5.reduce(_ + _)
    println(count)


  }
}
