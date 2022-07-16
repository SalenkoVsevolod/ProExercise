package salenko.vsevolod.framework.retrofit

import salenko.vsevolod.domain.repositories.CellsRepository
import salenko.vsevolod.entity.entity.Cell

class RetrofitCellsRepository(private val api: ProexeApi) : CellsRepository {

    override suspend fun getCells(): Result<List<Cell>> =
        try {
            val models = api.getCells()
            Result.success(CellMapper.mapToCellList(models))
        } catch (error: Exception) {
            Result.failure(error)
        }
}