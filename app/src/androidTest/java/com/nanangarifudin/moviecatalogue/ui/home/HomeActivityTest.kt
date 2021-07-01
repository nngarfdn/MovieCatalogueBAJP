package com.nanangarifudin.moviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.nanangarifudin.moviecatalogue.R
import com.nanangarifudin.moviecatalogue.utils.DataDummy
import com.nanangarifudin.moviecatalogue.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dummyMovies = DataDummy.generateDummyMovies()
//    private val dummyTvShow = DataDummy.generateDummyTvShows()

    @get:Rule
    var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }


    @Test
    fun loadMovies(){
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

//    @Test
//    fun loadTvShow(){
//        onView(withText("TV SHOW")).perform(click())
//        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
//        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
//    }

    @Test
    fun loadDetailMovie(){
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.txtTitleDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.txtTitleDetail)).check(matches(withText(dummyMovies[0].title)))
        onView(withId(R.id.txtDescriptionDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.txtDescriptionDetail)).check(matches(withText(dummyMovies[0].overview)))
    }

//    @Test
//    fun loadDetailTVShow(){
//        onView(withText("TV SHOW")).perform(click())
//        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
//        onView(withId(R.id.txtTitleDetail)).check(matches(isDisplayed()))
//        onView(withId(R.id.txtTitleDetail)).check(matches(withText(dummyTvShow[0].name)))
//        onView(withId(R.id.txtDescriptionDetail)).check(matches(isDisplayed()))
//        onView(withId(R.id.txtDescriptionDetail)).check(matches(withText(dummyTvShow[0].overview)))
//    }

}