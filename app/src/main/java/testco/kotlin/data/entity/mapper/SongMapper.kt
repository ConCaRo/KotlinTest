package testco.kotlin.data.entity

import testco.kotlin.data.entity.mapper.ArtistMapper
import testco.kotlin.data.entity.mapper.ModelMapper
import testco.kotlin.data.entity.mapper.SingerMapper
import testco.kotlin.domain.model.SongModel

/**
 * Created by Concaro on 8/2/2017.
 */
class SongMapper(val singerMapper: SingerMapper = SingerMapper(),
                 val artistMapper: ArtistMapper = ArtistMapper())
    : ModelMapper<SongModel, SongEntity>() {

    override fun transform(entity: SongEntity?): SongModel? {
        return SongModel(entity?.name!!,
                singerMapper.transform(entity?.singer),
                artistMapper.transform(entity.artist),
                entity?.release_date, entity.lyric)
    }

}