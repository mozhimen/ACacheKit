package com.mozhimen.cachek.room.commons

import androidx.room.*
import com.mozhimen.cachek.room.mos.MCacheKRM
import com.mozhimen.cachek.room.mos.MCacheKRM2

/**
 * @ClassName CacheDao
 * @Description TODO
 * @Author Kolin Zhao / Mozhimen
 * @Version 1.0
 */
@Dao
interface ICacheKRMDao2 {
    @Insert(entity = MCacheKRM2::class, onConflict = OnConflictStrategy.REPLACE)
    fun saveCache(cache: MCacheKRM2): Long

    @Query("select * from cachekrm2 where `key`=:key and rmName=:rmName")
    fun getCache(rmName: String,key: String): MCacheKRM2?

    @Query("delete from cachekrm2 where `key`=:key and rmName=:rmName")
    fun deleteCacheByKey(rmName: String, key: String)

    @Query("delete from cachekrm2 where rmName=:rmName")
    fun deleteAllCaches(rmName: String)
}