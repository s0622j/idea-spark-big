package com.spark.scala

import java.io.File
import java.net.{InetAddress, Socket}

import org.apache.spark.storage.StorageLevel
import org.apache.spark.{SparkConf, SparkContext}




object PersistScala {
  var count = 2;
  def main(args: Array[String]): Unit = {
    //创建spark配置对象
    val conf = new SparkConf();
    conf.setAppName("WordCountScala")
    conf.setMaster("local[4,3]")
    val sc = new SparkContext(conf);

    val rdd1 = sc.parallelize(1 to 20)
    val rdd2 = rdd1.map(e => {
      println(e)
      e * 2
    })


//    rdd2.cache()
    rdd2.persist(StorageLevel.DISK_ONLY)
//    rdd2.getCheckpointFile
    println(rdd2.reduce(_ + _))
    rdd2.unpersist()
    println(rdd2.reduce(_ + _))

    val ip = InetAddress.getLocalHost.getHostAddress;
    val tname = Thread.currentThread().getName;
    println(ip + " : " + tname)

    var str = java.net.InetAddress.getLocalHost.getHostAddress;
    str = str + " : " + Thread.currentThread().getName + "\r\n"

    val sock = new java.net.Socket("master100",8888);
    val out = sock.getOutputStream;
    out.write(str.getBytes())
    out.flush()
    out.close();
    sock.close();

    sc.broadcast()


  }
}
