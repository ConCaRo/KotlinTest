package testco.kotlin.data.model.mapper

/**
 * Created by Concaro on 8/2/2017.
 * Transform from Model in layer MODEL to entity in layer DOMAIN
 */
abstract class ModelMapper<Entity, Model> {

    abstract fun transform(model: Model?): Entity?

    fun transformCollection(collection: Collection<Model>) : List<Entity> {
        val result = ArrayList<Entity>()
        var entity: Entity?
        for (model in collection) {
            entity = transform(model)
            if(entity != null) {
                result.add(entity)
            }
        }
        return result
    }
}