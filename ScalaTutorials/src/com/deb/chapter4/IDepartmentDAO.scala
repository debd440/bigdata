package com.deb.chapter4

trait IDepartmentDAO {
  
  def add(name: String, id: Int): Long
}