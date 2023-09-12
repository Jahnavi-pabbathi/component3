package com.nodemngmt.entity

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.*

@Entity
@Serdeable
@Table(name="package_dimensions")
data class PackageDimensions(
    @Id

    var tcin: String,
    var depth:Double,
    var height: Double,
    var units: String,
    var width:Double,
    var code :String,
    var value:Double
){
    constructor() : this("", 0.0, 0.0, "",0.0,"",0.0)
}