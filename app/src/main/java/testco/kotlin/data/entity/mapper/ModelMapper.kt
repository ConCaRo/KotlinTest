package testco.kotlin.data.entity.mapper

/**
 * Created by Concaro on 8/2/2017.
 * Transform from Model in layer MODEL to entity in layer DOMAIN
 */
abstract class ModelMapper<Model, Entity> {

    abstract fun transform(entity: Entity?): Model?

    fun transformCollection(collection: Collection<Entity>) : List<Model> {
        val result = ArrayList<Model>()
        var model: Model?
        for (entity in collection) {
            model = transform(entity)
            if(model != null) {
                result.add(model)
            }
        }
        return result
    }
}