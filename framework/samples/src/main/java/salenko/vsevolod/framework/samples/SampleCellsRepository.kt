package salenko.vsevolod.framework.samples

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import salenko.vsevolod.domain.repositories.CellsRepository
import salenko.vsevolod.entity.entity.Cell
import kotlin.random.Random

class SampleCellsRepository : CellsRepository {

    private val random by lazy { Random(System.currentTimeMillis()) }
    private val testNames by lazy {
        listOf(
            "Audi",
            "fun nickname",
            "very very very long name",
            "Ford",
            "not funny =)",
            "Tesla",
            "Simple name",
            "Hyundai",
            "Uvuvwevwevwe Onyetenyevwe Ugwemuhwem Osas",
            "Smiling guy"
        )
    }

    private val testPicURL by lazy {
        listOf(
            "https://i1.sndcdn.com/artworks-000198393770-vdcdsj-t240x240.jpg",
            "https://media.cntraveler.com/photos/5f15986ca107fd1a0223ddde/16:9/w_2560%2Cc_limit/MaineAcadiaNationalPark-2020-GettyImages-1065259808.jpg",
            "https://img.freepik.com/premium–vector/austrian–black–tan-hound-dog-watercolor-sketch-hand-drawn-illustration_633389-37.jpg",
            "https://i.ebayimg.com/images/g/ocAAAOSwhodf0GS7/s-l64.jpg",
            "https://i.ebayimg.com/images/g/JfkAAOSweNBf0UY-/s-l64.jpg",
            "https://findicons.com/files/icons/2365/social_bookmarking_02/60/delicious_60x60px.png",
            "https://images.pexels.com/photos/417074/pexels-photo-417074.jpeg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/87/Way_through_the_forest.jpg/1200px-Way_through_the_forest.jpg",
            "https://images.all-free-download.com/images/graphiclarge/beauty_of_nature_17_211513.jpg",
            "https://images.all-free-download.com/images/graphiclarge/beauty_of_nature_15_211311.jpg",
            "https://static.wikia.nocookie.net/meme/images/5/52/Polite_Cat-0.jpg",
            "https://images.theconversation.com/files/2770/original/orly.jpg",
            "https://c.dns-shop.ru/thumb/st4/fit/300/219/3fdb344ccec0557e566f2a141b4452f4/q93_e470d5b1bb764724deb62d8ddb503921a67b9f9e06d46ac0e8afd694c7b5fd93.jpg",
        )
    }

    override suspend fun getCells(): Result<List<Cell>> =
        withContext(Dispatchers.IO) {
            delay(random.nextLong(1, 5) * 1000)
            if (random.nextBoolean()) {
                val arrayList = ArrayList<Cell>()
                for (i in 1..testPicURL.size) {
                    arrayList.add(generateCell())
                }
                Result.success(
                    arrayList
                )
            } else {
                Result.failure(IllegalStateException("Sample exception"))
            }

        }

    private fun generateCell() = Cell(
        testNames[random.nextInt(testNames.size)],
        testPicURL[random.nextInt(testPicURL.size)]
    )
}