package com.nodemngmt.repository
import com.nodemngmt.entity.PackageDimensions
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
@Repository
interface DimensionsRepository: CrudRepository<PackageDimensions, String> {

}