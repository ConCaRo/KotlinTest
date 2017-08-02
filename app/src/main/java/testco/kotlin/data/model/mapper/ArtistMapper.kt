package testco.kotlin.data.model.mapper

import testco.kotlin.data.model.ArtistEntity
import testco.kotlin.data.model.ArtistModel

/**
 * Created by Concaro on 8/2/2017.
 */
class ArtistMapper : ModelMapper<ArtistEntity, ArtistModel>() {

    override fun transform(model: ArtistModel?): ArtistEntity? {
        return ArtistEntity(model?.name!!, model?.date_of_birth)
    }

}