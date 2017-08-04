package testco.kotlin.data.entity.mapper

import testco.kotlin.data.entity.ArtistEntity
import testco.kotlin.domain.model.ArtistModel

/**
 * Created by Concaro on 8/2/2017.
 */
class ArtistMapper : ModelMapper<ArtistModel, ArtistEntity>() {

    override fun transform(entity: ArtistEntity?): ArtistModel? {
        return ArtistModel(entity?.name!!, entity?.date_of_birth)
    }

}