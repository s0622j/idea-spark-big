package com.spark.scala

import java.io.File

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object StartModeScala {
  var count = 2;
  def main(args: Array[String]): Unit = {
    //创建spark配置对象
    val conf = new SparkConf();
    conf.setAppName("WordCountScala")
    //配置master属性
//    conf.setMaster("local[*]")
//    conf.setMaster("local[4,2]")
    conf.setMaster("local[4,3]")
    //通过conf创建sc
    val sc = new SparkContext(conf);

    val rdd1 = sc.parallelize(1 to 20)
    val rdd2 = rdd1.map(e => {
      val tname = Thread.currentThread().getName
      println(tname + "----------" + e)
      if(e == 2){
        val f = new File("d:/scala/1.txt");
//        if (f.exists()){
//          f.delete();
//          "xx".toInt
//        }
        if(count != 0){
          count -= 1;
          throw  new Exception("aaaaaaaaaaaaaaaaa");
        }
        else {
          e;
        }
      }
      else{

        e
      }
    })

//    val rdd3 = rdd1.repartition(4)
//    rdd3.foreach(e=>{
//      val tname = Thread.currentThread().getName;
//      println(tname + " :::: " + e)
//      e * 2
//    })
//    rdd2.collect()
//    rdd3.collect()
    println(rdd2.reduce(_ + _))



  }
}
