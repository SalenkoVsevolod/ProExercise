package salenko.vsevolod.domain.interactor

import salenko.vsevolod.domain.interactor.base.SuspendGetResultUseCase
import salenko.vsevolod.domain.repositories.CellsRepository
import salenko.vsevolod.entity.entity.Cell

class GetCellsUseCase(private val cellsRepository: CellsRepository) :
    SuspendGetResultUseCase<List<Cell>>() {

    override suspend fun get(): Result<List<Cell>> =
        cellsRepository.getCells()

}