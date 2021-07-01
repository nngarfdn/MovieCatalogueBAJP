package com.nanangarifudin.moviecatalogue.utils

import com.nanangarifudin.moviecatalogue.data.local.MovieEntity
import com.nanangarifudin.moviecatalogue.data.local.TvShowEntity
import com.nanangarifudin.moviecatalogue.data.remote.response.MovieItem
import com.nanangarifudin.moviecatalogue.data.remote.response.MovieResponse
import com.nanangarifudin.moviecatalogue.data.remote.response.TVItem
import com.nanangarifudin.moviecatalogue.data.remote.response.TVResponse

object DataDummy {
    fun generateDummyMovies(): ArrayList<MovieItem> {

        val movies = ArrayList<MovieItem>()

        movies.add(
            MovieItem(
                id = 567189,
                title = "Tom Clancy's Without Remorse",
               overview =  "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                posterPath =  "R.drawable.poster_a_start_is_born"
            )
        )

        movies.add(
            MovieItem(
                id =460465,
                title = "Alita: Battle Angel",
                overview =  "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                posterPath = "R.drawable.poster_alita"
            )
        )

        movies.add(
            MovieItem(
                id =804435,
                title = "Aquaman",
                overview =  "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                posterPath = "R.drawable.poster_aquaman"
            )
        )

        movies.add(
            MovieItem(
                id =399566,
                title =  "Bohemian Rhapsody",
                overview =  "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                posterPath = "R.drawable.poster_bohemian"
            )
        )

        movies.add(
            MovieItem(
                id =615678,
                title =  "Cold Pursuit",
                overview =  "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                posterPath = "R.drawable.poster_cold_persuit"
            )
        )

        movies.add(
            MovieItem(
                id =615457,
                title = "Creed",
                overview =  "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
                posterPath = "R.drawable.poster_creed"
            )
        )

        movies.add(
            MovieItem(
                id =811367,
                title =  "Fantastic Beasts: The Crimes of Grindelwald",
                overview =   "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                posterPath = "R.drawable.poster_crimes"
            )
        )

        movies.add(
            MovieItem(
                id =791373,
                title = "Glass",
                overview =  "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                posterPath = "R.drawable.poster_glass"
            )
        )

        movies.add(
            MovieItem(
                id = 632357,
                title =  "How to Train Your Dragon: The Hidden World",
                overview =  "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                posterPath = "R.drawable.poster_how_to_train"
            )
        )

        movies.add(
            MovieItem(
                id =793723,
                title = "Avengers: Infinity War",
                overview =  "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                posterPath = "R.drawable.poster_infinity_war"
            )
        )

        movies.add(
            MovieItem(
                id =  635302,
                title =  "Spider-Man: Into the Spider-Verse",
                overview =  "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                posterPath = "R.drawable.poster_spiderman"
            )
        )

        return movies

    }

    fun generateDummyTvShows(): ArrayList<TVItem> {

        val tvShows = ArrayList<TVItem>()

        tvShows.add(
            TVItem(
                id = 0,
                name = "The Falcon and the Winter Soldier",
                overview = "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                        posterPath= "R.drawable.poster_arrow"
            )
        )

        tvShows.add(
            TVItem(
                id = 1,
                name = "Doom Patrol",
                overview = "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                posterPath = "R.drawable.poster_doom_patrol"
            )
        )

        tvShows.add(
            TVItem(
                id = 2,
               name =  "Dragon Ball Z",
                overview = "Five years have passed since the fight with Piccolo Jr., and Goku now has a son, Gohan. The peace is interrupted when an alien named Raditz arrives on Earth in a spacecraft and tracks down Goku, revealing to him that that they are members of a near-extinct warrior race called the Saiyans.",
                posterPath = "R.drawable.poster_dragon_ball"
            )
        )

        tvShows.add(
            TVItem(
                id = 3,
               name =  "Fairy Tail",
                overview = "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                posterPath = "R.drawable.poster_fairytail"
            )
        )

        tvShows.add(
            TVItem(
                id = 4,
                name = "Family Guy",
                overview = "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                posterPath = "R.drawable.poster_family_guy"
            )
        )

        tvShows.add(
            TVItem(
                id = 5,
                name = "The Flash",
                overview = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only meta-human who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it wont be long before the world learns what Barry Allen has become...The Flash.",
                posterPath = "R.drawable.poster_flash"
            )
        )

        tvShows.add(
            TVItem(
                id = 6,
                        name ="Grey's Anatomy",
                        overview = "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                posterPath = "R.drawable.poster_grey_anatomy"
            )
        )

        tvShows.add(
            TVItem(
                        id = 7,
                        name = "Marvel's Iron Fist",
                        overview = "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                posterPath ="R.drawable.poster_iron_fist"
            )
        )

        tvShows.add(
            TVItem(
                        id = 8,
                        name ="Riverdale",
                        overview = "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                posterPath = "R.drawable.poster_riverdale"
            )
        )

        tvShows.add(
            TVItem(
                        id = 9,
                        name ="Shameless",
                        overview = "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
                posterPath = "R.drawable.poster_shameless"
            )
        )

        tvShows.add(
            TVItem(
                        id = 10,
                        name ="Supergirl",
                overview = "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                posterPath = "R.drawable.poster_supergirl"
            )
        )

        return tvShows
    }

    fun getMoviesById(id: Int, listMovies: ArrayList<MovieEntity>): MovieEntity {
        return listMovies[id]
    }

    fun getTvShowById(id: Int, listTvShow: ArrayList<TvShowEntity>): TvShowEntity {
        return listTvShow[id]
    }

}
