package com.spark.scala

import java.net.{InetAddress, Socket}

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object DeployModeTest {
  val ip = InetAddress.getLocalHost.getHostAddress;
  def printInfo(str:String): Unit = {
    val sock = new Socket("192.168.50.103",8888);
    val out = sock.getOutputStream;
    out.write((ip + " : " + str + "\r\n").getBytes())
    out.flush()
    sock.close();
  }
  def main(args: Array[String]): Unit = {
    //创建spark配置对象
    val conf = new SparkConf();
    conf.setAppName("DeployModeTest")
    //配置master属性
    conf.setMaster("yarn")
//    conf.setMaster("spark://master100:7077")
//    conf.setMaster("local[4]")
    //通过conf创建sc
    val sc = new SparkContext(conf);

    printInfo("hello world");
    val rdd1 = sc.parallelize(1 to 10,3);
    val rdd2 = rdd1.map(e=>{
      printInfo("map : " + e)
      e * 2 ;
    })

    val rdd3 = rdd2.repartition(2)
    val rdd4 = rdd3.map(e=>{
      printInfo("map2 : " + e)
      e
    })

    val res = rdd4.reduce((a,b)=>{
      printInfo("reduce :" + a + "," + b)
      a + b ;
    })

    printInfo("driver ： " + res + ":")
//    print(res)



  }
}
