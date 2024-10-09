package com.mozhimen.cachek.room.mos

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

/**
 * @ClassName Cache
 * @Description TODO
 * @Author Kolin Zhao / Mozhimen
 * @Version 1.0
 */
@Entity(tableName = "cachekrm2")
data class MCacheKRM2(
    var rmName: String,
    var key: String,
    var data: ByteArray,
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
) : Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MCacheKRM2

        if (rmName != other.rmName) return false
        if (key != other.key) return false
        if (!data.contentEquals(other.data)) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = rmName.hashCode()
        result = 31 * result + key.hashCode()
        result = 31 * result + data.contentHashCode()
        result = 31 * result + id.hashCode()
        return result
    }
}