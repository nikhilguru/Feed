package com.nikhil.feed

import com.nikhil.feed.entity.Row
import com.nikhil.feed.presenter.HomePresenterImp
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class HomeUnitTest {
    @Test
    fun isListEmpty() {
        var list = ArrayList<Row>()

        var res = HomePresenterImp.isListIsEmpty(list)
        assertEquals(true, res)

        res = HomePresenterImp.isListIsEmpty(null)
        assertEquals(true, res)

        res = HomePresenterImp.isListIsEmpty(list.apply {
            add(Row())
        })
        assertEquals(false, res)
    }
}
