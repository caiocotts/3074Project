package ca.georgebrown.keags.a3074project.model

data class Restaurant(
    val id: Int,
    val name: String,
    val location: String,
    val rating: String,
)

val sampleRestaurants = listOf(
    Restaurant(1, "The Maple Leaf Bistro", "200 King St W", "4/5"),
    Restaurant(2, "Harbourfront Grill", "10 Queens Quay E", "5/5"),
    Restaurant(3, "Campus Café", "160 Kendal Ave", "3/5"),
    Restaurant(4, "Spadina Noodles", "450 Spadina Ave", "4/5"),
    Restaurant(5, "Distillery Tacos", "55 Mill St", "4/5"),
    Restaurant(6, "Yonge Street Pizza", "789 Yonge St", "2/5"),
    Restaurant(7, "Kensington Market Bowls", "297 Augusta Ave", "5/5"),
    Restaurant(8, "Liberty Village Burgers", "171 East Liberty St", "3/5"),
    Restaurant(9, "Queen West Brunch", "842 Queen St W", "4/5"),
    Restaurant(10, "St. Lawrence Seafood", "93 Front St E", "5/5"),
    Restaurant(11, "Annex Sushi Bar", "512 Bloor St W", "4/5"),
    Restaurant(12, "Roncesvalles Polish Kitchen", "303 Roncesvalles Ave", "3/5"),
    Restaurant(13, "Leslieville Smokehouse", "1455 Queen St E", "4/5"),
    Restaurant(14, "Bloor-Yonge Ramen", "2 Bloor St E", "5/5"),
    Restaurant(15, "High Park Ice Cream", "1873 Bloor St W", "4/5"),
    Restaurant(16, "Danforth Greek Taverna", "888 Danforth Ave", "3/5"),
)
