package com.nodemngmt.controller

import com.nodemngmt.entity.PackageDimensions
import com.nodemngmt.repository.DimensionsRepository
import com.nodemngmt.service.PackageDimensionsService
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.client.HttpClient
import io.micronaut.http.HttpHeaders
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import io.micronaut.http.client.annotation.Client

import spock.lang.Shared
import spock.lang.Specification

class PackageControllerTestSpec extends Specification{
    @Shared
    @MockBean
    PackageDimensionsService packageDimensionsService

    PackageDimensionController packageDimensionController

    @Shared
    DimensionsRepository dimensionsRepository

    @Shared
    @Client("/component3")
    HttpClient client

    @Shared
     PackageDimensions dimensions = new PackageDimensions(
          "11010144",
            4.69,
            2.13,
            "INCH",
            2.17,
            "POUND",
            0.14
    )

    void setup(){
        packageDimensionsService=Mock()
        packageDimensionController=  new PackageDimensionController(packageDimensionsService)
    }

    def "test saveDimensions endpoint"() {
        given:
        packageDimensionsService.saveDimensions(dimensions) >>  PackageDimensions
        when:
        var response = packageDimensionsService.saveDimensions(dimensions)
        then:
        response != null
        response instanceof PackageDimensions

    }

    def "test updateDimensions endpoint"() {
        given:
        packageDimensionsService.updateDimensions(dimensions) >> PackageDimensions
        when:
        var response = packageDimensionsService.updateDimensions(dimensions)
        then:
        response == com.nodemngmt.entity.PackageDimensions

    }


}
