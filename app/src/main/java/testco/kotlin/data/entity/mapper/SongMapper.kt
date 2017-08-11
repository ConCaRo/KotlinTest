package testco.kotlin.data.entity

import testco.kotlin.data.entity.mapper.ArtistMapper
import testco.kotlin.data.entity.mapper.ModelMapper
import testco.kotlin.data.entity.mapper.SingerMapper
import testco.kotlin.domain.model.SongModel
import javax.inject.Inject

/**
 * Created by Concaro on 8/2/2017.
 */
class SongMapper @Inject constructor(val singerMapper: SingerMapper ,
                 val artistMapper: ArtistMapper )
    : ModelMapper<SongModel, SongEntity>() {

    override fun transform(entity: SongEntity?): SongModel? {
        return SongModel(entity?.name!!,
                singerMapper.transform(entity?.singer),
                artistMapper.transform(entity.artist),
                entity?.release_date, entity.lyric)
    }

}