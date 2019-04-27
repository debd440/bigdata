package com.deb.chapter2

import org.apache.spark.Partitioner

class CustomPartitioner(noOfPartitioner: Int) extends Partitioner {

  override def numPartitions: Int = noOfPartitioner

  override def getPartition(key: Any): Int = {
    key.toString().toInt % noOfPartitioner
  }

  override def equals(other: Any): Boolean = {
    other match {
      case obj: CustomPartitioner =>
        obj.numPartitions == numPartitions
      case _ => false
    }
  }
}