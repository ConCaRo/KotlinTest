package testco.kotlin.data.model

import testco.kotlin.data.model.mapper.ArtistMapper
import testco.kotlin.data.model.mapper.ModelMapper
import testco.kotlin.data.model.mapper.SingerMapper

/**
 * Created by Concaro on 8/2/2017.
 */
class SongMapper(val singerMapper: SingerMapper = SingerMapper(), val artistMapper: ArtistMapper = ArtistMapper())
    : ModelMapper<SongEntity, SongModel>() {

    override fun transform(model: SongModel?): SongEntity? {
        return SongEntity(model?.name!!,
                singerMapper.transform(model?.singer),
                artistMapper.transform(model.artist),
                model?.release_date, model.lyric)
    }

}