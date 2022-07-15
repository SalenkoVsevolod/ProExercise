package salenko.vsevolod.framework.retrofit

import salenko.vsevolod.domain.repositories.CellsRepository
import salenko.vsevolod.entity.entity.Cell

class RetrofitCellsRepository : CellsRepository {
    override suspend fun getCells(): Result<List<Cell>> {
        TODO("Not yet implemented")
    }
}