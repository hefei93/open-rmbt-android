package at.specure.database.dao

import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import at.specure.database.Tables
import at.specure.database.entity.Capabilities

@Dao
interface CapabilitesDao {

    @Query("SELECT * from ${Tables.CAPABILITIES} WHERE testUUID == :testUUID")
    fun getCapabilitiesForTest(testUUID: String): MutableLiveData<List<Capabilities>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(capabilities: Capabilities)
}

