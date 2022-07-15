package salenko.vsevolod.presentation.view_models

import salenko.vsevolod.domain.interactor.GetCellsUseCase
import salenko.vsevolod.entity.entity.Cell
import salenko.vsevolod.presentation.view_models.base.SingleDataViewModel

class CellsViewModel(private val getCellsUseCase: GetCellsUseCase) :
    SingleDataViewModel<List<Cell>>() {

    override suspend fun suspendingRefresh(): Result<List<Cell>> = getCellsUseCase()

}