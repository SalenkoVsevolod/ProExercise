package salenko.vsevolod.framework.samples

import salenko.vsevolod.domain.repositories.CellsRepository
import salenko.vsevolod.entity.entity.Cell

class SampleCellsRepository : CellsRepository {
    override suspend fun getCells(): Result<List<Cell>> =
        //TODO provide a sample list of the cells
        Result.success(listOf(Cell("sample name", "sampleUrl")))

}