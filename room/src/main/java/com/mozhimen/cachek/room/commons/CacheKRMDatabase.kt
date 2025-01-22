package com.mozhimen.cachek.room.commons

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.mozhimen.cachek.room.mos.MCacheKRM
import com.mozhimen.cachek.room.mos.MCacheKRM2
import com.mozhimen.kotlin.utilk.android.app.UtilKApplicationWrapper

/**
 * @ClassName CacheDatabase
 * @Description TODO
 * @Author Kolin Zhao / Mozhimen
 * @Version 1.0
 */
@Database(entities = [MCacheKRM::class, MCacheKRM2::class], version = 2, exportSchema = false)
abstract class CacheKRMDatabase : RoomDatabase() {
    abstract val cacheKDao: ICacheKRMDao
    abstract val cacheKDao2: ICacheKRMDao2

    companion object {
        private val _db: CacheKRMDatabase by lazy {
            Room.databaseBuilder(UtilKApplicationWrapper.instance.applicationContext, CacheKRMDatabase::class.java, "basick_cachek_rm")
                .enableMultiInstanceInvalidation()
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .addMigrations(MIGRATION_1_2())
                .build()
        }

        @JvmStatic
        fun get(): CacheKRMDatabase =
            _db

        fun cacheKDao(): ICacheKRMDao =
            get().cacheKDao

        fun cacheKDao2(): ICacheKRMDao2 =
            get().cacheKDao2

        ////////////////////////////////////////////////////////////////////////////

        class MIGRATION_1_2 : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                // 创建新的表 cachekrm2
                db.execSQL(
                    """
            CREATE TABLE IF NOT EXISTS `cachekrm2` (
                `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                `rmName` TEXT NOT NULL,
                `key` TEXT NOT NULL,
                `data` BLOB NOT NULL
            )
        """.trimIndent()
                )
            }
        }
    }
}