package project.stN991536967.snehal

import android.app.Application
import project.stN991536967.snehal.Database.fitDatabase

class fitsharkApplication: Application() {
    val database: fitDatabase by lazy { fitDatabase.getDatabase(this) }
}