package com.nodemngmt.service

import com.nodemngmt.entity.PackageDimensions
import com.nodemngmt.repository.DimensionsRepository
import spock.lang.Shared
import spock.lang.Specification

class PackageServiceTest extends Specification{
    @Shared
    DimensionsRepository dimensionsRepository

    PackageDimensionsService packageDimensionsService

    @Shared
    PackageDimensions packageDimensions

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
        dimensionsRepository=Mock()
        packageDimensionsService=new PackageDimensionsService(dimensionsRepository)
    }
    def "test save endpoint"() {
        given:
        dimensions
        dimensionsRepository.save(dimensions) >> PackageDimensions

        when:
//        def response = client.toBlocking().exchange("/add", HttpMethod.POST, packageDimensions, PackageDimensions.class)
            def response =dimensionsRepository.save(dimensions)
        then:
//        response.status == HttpStatus.OK
//        response.contentType.isPresent()
//        response.contentType.get() == MediaType.APPLICATION_JSON
        response == com.nodemngmt.entity.PackageDimensions
    }

    def "test update endpoint"(){
        given:
        dimensions
        dimensionsRepository.update(dimensions) >> PackageDimensions
        dimensionsRepository.save(dimensions) >> PackageDimensions

        when:
        def response1 = dimensionsRepository.update(dimensions)
        def response2 = dimensionsRepository.save(dimensions)

        then:
        response1==response2
    }
}
