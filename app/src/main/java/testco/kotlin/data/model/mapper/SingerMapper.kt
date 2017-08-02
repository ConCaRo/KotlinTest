package testco.kotlin.data.model.mapper

import testco.kotlin.data.model.SingerEntity
import testco.kotlin.data.model.SingerModel

/**
 * Created by Concaro on 8/2/2017.
 */
class SingerMapper : ModelMapper<SingerEntity, SingerModel>() {

    override fun transform(model: SingerModel?): SingerEntity? {
        return SingerEntity(model?.name!!, model?.date_of_birth)
    }
}