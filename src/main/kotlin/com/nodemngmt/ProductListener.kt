package com.nodemngmt

import com.nodemngmt.controller.PackageDimensionController
import com.nodemngmt.entity.PackageDimensions
import com.nodemngmt.entity.Item
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
class ProductListener(private val packageDimensionController: PackageDimensionController) {

    @Topic("component1")
    fun receive(@KafkaKey brand:String,name:Item) {

        val tcin = name.tcin
        val depth = name.packageDimensions.measurements.dimensions.depth
        val height = name.packageDimensions.measurements.dimensions.height
        val units = name.packageDimensions.measurements.dimensions.units
        val width = name.packageDimensions.measurements.dimensions.width
        val code = name.packageDimensions.measurements.weight.code
        val value = name.packageDimensions.measurements.weight.value

        val packageEntity= PackageDimensions(tcin,depth,height,units,width,code,value)

        packageDimensionController.updateCompliance(packageEntity)
        System.out.println("Received response - "+ name.packageDimensions )
    }
}