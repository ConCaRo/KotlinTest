package testco.kotlin.data.entity.mapper

import testco.kotlin.data.entity.SingerEntity
import testco.kotlin.domain.model.SingerModel

/**
 * Created by Concaro on 8/2/2017.
 */
class SingerMapper : ModelMapper<SingerModel, SingerEntity>() {

    override fun transform(entity: SingerEntity?): SingerModel? {
        return SingerModel(entity?.name!!, entity?.date_of_birth)
    }
}