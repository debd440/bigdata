package com.deb.chapter4

trait IStudentDAO {

  def add(name: String, id: Int): Long
  def update(id: Int): Long
}