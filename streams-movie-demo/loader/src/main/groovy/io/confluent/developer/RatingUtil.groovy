package io.confluent.developer

import groovy.transform.CompileStatic

@CompileStatic
class RatingUtil {

  public static def ratingTargets = [
      [id: 128, rating: 7.9], // The Big Lebowski
      [id: 211, rating: 7.7], // A Beautiful Mind
      [id: 552, rating: 4.5], // The Village
      [id: 907, rating: 7.4], // True Grit
      [id: 354, rating: 10.0], // The Tree of Life
      [id: 782, rating: 8.2], // A Walk in the Clouds
      [id: 802, rating: 7.1], // Gravity
      [id: 900, rating: 6.5], // Children of Men
      [id: 25, rating: 8.9],  // The Goonies
      [id: 294, rating: 9.1], // Die Hard
      [id: 362, rating: 7.8], // Lethal Weapon
      [id: 592, rating: 3.4], // Happy Feet
      [id: 744, rating: 8.6], // The Godfather
      [id: 780, rating: 1.2], // Super Mario Brothers
      [id: 805, rating: 7.2], // Highlander
      [id: 833, rating: 2.5], // Bolt
      [id: 898, rating: 7.1], // Big Fish
      [id: 658, rating: 4.6], // Beowulf
      [id: 547, rating: 2.3], // American Pie 2
      [id: 496, rating: 6.9], // 13 Going on 30
      [id: 193, rating: 8.0], // Terminator
      [id: 501, rating: 8.5] // Terminator 2
  ]

  public static def userTargets = [
      [id: 101, name: "Ale"],
      [id: 102, name: "Ricardo"],
      [id: 103, name: "Robin"],
      [id: 104, name: "Victoria"],
      [id: 105, name: "Viktor"],
      [id: 106, name: "Yeva"]
  ]

  static Rating generateRandomRating(List<LinkedHashMap<String, Number>> ratingTargets,
                                     List<LinkedHashMap<String, Number>> userTargets,
                                     int stddev) {

    Random random = new Random()
    int numberOfTargetRatings = ratingTargets.size()
    def numberOfUsers = userTargets.size()

    int targetIndex = random.nextInt(numberOfTargetRatings)
    def targetUserIndex = random.nextInt(numberOfUsers)

    double randomRating = (double) ((random.nextGaussian() * stddev) + ratingTargets[targetIndex].rating)
    randomRating = Math.max(Math.min(randomRating, 10), 0)

    long randomUser = (long) ((random.nextGaussian() * stddev) + userTargets[targetUserIndex].id)
    randomUser = Math.max(Math.min(randomUser, 106), 101)

    // simulating ??real person rating?? - int value for rating
    new Rating((Long) ratingTargets[targetIndex].id, randomRating.intValue(), randomUser)
  }
}
