package com.nodemngmt.repository

import com.nodemngmt.entity.PackageDimensions
import spock.lang.Shared
import spock.lang.Specification

class dimensionRepository extends Specification{
    @Shared
    DimensionsRepository dimensionsRepository

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

    def "test save and findById"() {
        given:
        dimensionsRepository.save(dimensions) >> PackageDimensions
        dimensionsRepository.findById(savedDimensions.id) >> PackageDimensions
        when:
        def savedDimensions = dimensionsRepository.save(dimensions)
        def foundDimensions = dimensionsRepository.findById(savedDimensions.id).get()

        then:
        savedDimensions.id != null
        foundDimensions.isPresent()
        foundDimensions.get().id == savedDimensions.id
    }

    def "test update"() {
        given:
        dimensionsRepository.save(dimensions) >> PackageDimensions
        dimensionsRepository.update(dimensions) >> PackageDimensions

        when:
        def savedDimensions = dimensionsRepository.save(dimensions)

        savedDimensions.height = 3.24
        def updatedDimensions = dimensionsRepository.update(savedDimensions)

        then:
        updatedDimensions != null
        updatedDimensions.height == 3.24
    }

    def "test deleteById"() {
        given:
        dimensionsRepository.save(dimensions) >> PackageDimensions
        dimensionsRepository.findById(savedDimensions.id) >> PackageDimensions
        when:
        def savedDimensions = dimensionsRepository.save(dimensions)
        dimensionsRepository.deleteById(savedDimensions.id)

        then:
        !dimensionsRepository.findById(savedDimensions.id).isPresent()
    }
}
