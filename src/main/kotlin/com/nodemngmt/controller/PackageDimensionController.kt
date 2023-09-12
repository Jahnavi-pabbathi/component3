package com.nodemngmt.controller

import com.nodemngmt.entity.PackageDimensions
import com.nodemngmt.service.PackageDimensionsService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put

@Controller("/component3")
class PackageDimensionController(private val packageDimensionsService:PackageDimensionsService) {
    @Post("/add")
    fun saveDimensions(packageDimensions: PackageDimensions):PackageDimensions{
        System.out.println("compliance "+packageDimensions)
        return packageDimensionsService.saveDimensions(packageDimensions)
    }
    @Put("/updateCompliance")
    fun updateCompliance(packageDimensions: PackageDimensions):PackageDimensions{
        return packageDimensionsService.updateDimensions(packageDimensions)
    }
}