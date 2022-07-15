package salenko.vsevolod.domain.repositories

import salenko.vsevolod.entity.entity.Cell

interface CellsRepository {
    suspend fun getCells(): Result<List<Cell>>
}