package com.deb.chapter4

trait IEmployeeDAO[A] {

  def add(obj: A): Long
}