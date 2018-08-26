package pl.michalboryczko.bodyrating.model

data class Person(
    val id: String,
    val name: String,
    val votes: String,
    val rating_sum: String,
    val images: List<String>
)


data class PersonRating(
        val id: String,
        val rating: Int
)

