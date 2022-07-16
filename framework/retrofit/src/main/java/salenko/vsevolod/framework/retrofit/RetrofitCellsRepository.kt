package salenko.vsevolod.framework.retrofit

import salenko.vsevolod.domain.repositories.CellsRepository
import salenko.vsevolod.entity.entity.Cell

class RetrofitCellsRepository(private val api: ProexeApi) : CellsRepository {

    override suspend fun getCells(): Result<List<Cell>> = try {
        Result.success(CellMapper.mapToCellList(api.getCells()))
    } catch (error: Exception) {
        Result.failure(error)
    }
}