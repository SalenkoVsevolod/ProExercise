package salenko.vsevolod.framework.retrofit

import salenko.vsevolod.entity.entity.Cell

object CellMapper {
    fun mapToCellList(retrievedData: List<CellDataModel>): List<Cell> =
        retrievedData.map { Cell(it.name, it.img) }
}


