package testco.kotlin.data.model.mapper

import testco.kotlin.data.model.AlbumEntity
import testco.kotlin.data.model.AlbumModel
import testco.kotlin.data.model.SongMapper

/**
 * Created by Concaro on 8/2/2017.
 */
class AlbumMapper(val artistMapper: ArtistMapper = ArtistMapper(),
                  val songMapper: SongMapper = SongMapper()) : ModelMapper<AlbumEntity, AlbumModel>() {
    override fun transform(model: AlbumModel?): AlbumEntity? {
        return AlbumEntity(model?.name!!,
                artistMapper.transformCollection(model.artists),
                songMapper.transformCollection(model?.songs),
                model.release_date)
    }
}