package com.deb.b2c.filter

import javax.inject._
import play.filters.cors.CORSFilter
import play.api.http.DefaultHttpFilters

class AppFilter @Inject() (corsFilter: CORSFilter, authorizedFilter: AuthorizedFilter) extends DefaultHttpFilters(corsFilter, authorizedFilter)