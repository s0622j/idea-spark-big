package com.spark.java;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.Optional;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function0;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.Seconds;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/4/3.
 */
public class JavaSparkStreamingWordCountWindowsApp {
    public static void main(String[] args) throws Exception {
        SparkConf conf = new SparkConf();
        conf.setAppName("wc");
        conf.setMaster("local[4]");
        //创建Spark流应用上下文，时间批次2
        JavaStreamingContext jsc = new JavaStreamingContext(conf, Seconds.apply(2));
        jsc.checkpoint("file:///d:/scala/check");
//        JavaStreamingContext jsc = JavaStreamingContext.getOrCreate("file:///d:/scala/check", new Function0<JavaStreamingContext>() {
//            public JavaStreamingContext call() throws Exception {
//                JavaStreamingContext jsc = new JavaStreamingContext(conf, Seconds.apply(2));
//                jsc.checkpoint("file:///d:/scala/check");
//                return jsc;
//            }
//        });
        //创建socket离散流
        JavaReceiverInputDStream sock = jsc.socketTextStream("localhost",9999);
        //压扁
        JavaDStream<String> wordsDS = sock.flatMap(new FlatMapFunction<String,String>() {
            public Iterator call(String str) throws Exception {
                List<String> list = new ArrayList<String>() ;
                String[] arr = str.split(" ");
                for(String s : arr){
                    list.add(s);
                }
                return list.iterator();
            }
        });

        //映射成元组（key-value,标1的过程）
        JavaPairDStream<String,Integer> pairDS = wordsDS.mapToPair(new PairFunction<String, String, Integer>() {
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<String,Integer>(s,1);
            }
        }) ;


//        //key和window聚合
//        JavaPairDStream<String,Integer> countDS = pairDS.reduceByKeyAndWindow(new Function2<Integer, Integer, Integer>() {
//            public Integer call(Integer v1, Integer v2) throws Exception {
//                return v1 + v2;
//            }
//        },new Duration(6 * 1000),new Duration(4 * 1000));

        //统计windows内元素的个数
        JavaDStream<Long> countDS = wordsDS.countByWindow(new Duration(24 * 60 * 60 * 1000),new Duration(4 * 1000));

        //打印
        countDS.print();

        jsc.start();

        jsc.awaitTermination();

    }
}
