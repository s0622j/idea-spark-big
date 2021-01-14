package com.spark.java;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.Properties;

/**
 * Created by Administrator on 2017/4/3.
 */
public class SQLHiveJava {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf();
        conf.setMaster("local") ;
        conf.setAppName("SQLJava");
        SparkSession sess = SparkSession.builder()
                            .appName("SQLHiveJava")
                            .config("spark.master","local")
                            .getOrCreate();
        Dataset<Row> df = sess.sql("create table ttt(id int)");

//        sess.sql("use mydb2.db");
//        Dataset<Row> df = sess.sql("select * from tt");
        df.show();

    }
}
