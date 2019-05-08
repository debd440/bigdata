package com.deb.b2c.module

import com.google.inject.AbstractModule
import com.deb.b2c.presistant.IStudentDAO
import com.deb.b2c.presistant.StudentDAOImpl
import com.deb.b2c.service.IStudentService
import com.deb.b2c.service.StudentServiceImpl

class AppModule extends AbstractModule {

  override def configure() = {

    //Service Binding
    bind(classOf[IStudentService])
      .to(classOf[StudentServiceImpl])

    //DAO Binding
    bind(classOf[IStudentDAO])
      .to(classOf[StudentDAOImpl])
  }
}