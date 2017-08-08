package testco.kotlin.data.entity.mapper

import testco.kotlin.data.entity.AlbumEntity
import testco.kotlin.data.entity.SongMapper
import testco.kotlin.domain.model.AlbumModel

/**
 * Created by Concaro on 8/2/2017.
 */
class AlbumMapper(val artistMapper: ArtistMapper = ArtistMapper(),
                  val songMapper: SongMapper = SongMapper())
    : ModelMapper<AlbumModel, AlbumEntity>() {

    override fun transform(entity: AlbumEntity?): AlbumModel? {
        return AlbumModel(entity?.name!!,
                entity.cover,
                artistMapper.transformCollection(entity.artists),
                songMapper.transformCollection(entity?.songs),
                entity.release_date)
    }
}