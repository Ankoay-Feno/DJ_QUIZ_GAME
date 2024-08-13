package mg.geit.DJ.quiz

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Personnes")
class Personne(var UserName:String,
               var UserFirstname:String,
               @PrimaryKey
               var userEmail:String,
               var userNumberPhone:String,
               var userLevel:MutableMap<String, Int>)
