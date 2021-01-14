package com.spark.java;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.*;

import java.util.Properties;

/**
 * Created by Administrator on 2017/4/3.
 */
public class SQLJDBCJava {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf();
        conf.setMaster("local") ;
        conf.setAppName("SQLJava");
        SparkSession sess = SparkSession.builder()
                            .appName("SQLJava")
                            .config("spark.master","local")
                            .getOrCreate();
        String url = "jdbc:mysql://192.168.0.103:3306/big4" ;
        String table = "words" ;

        //查询数据库
        Dataset<Row> df = sess.read()
                .format("jdbc")
                .option("url", url)
                .option("dbtable", table)
                .option("user", "root")
                .option("password", "root")
                .option("driver", "com.mysql.jdbc.Driver")
                .load();
        df.show();

        //投影查询
        Dataset<Row> df2 = df.select(new Column("id"),new Column("txt"));
        //过滤
        df2 = df2.where("txt like 'world%'");
        //去重
        df2 = df2.distinct();


        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "root");
        prop.put("driver", "com.mysql.jdbc.Driver");

        //写入
        df2.write().jdbc(url,"subpersons",prop);
        df2.show();

    }
}
