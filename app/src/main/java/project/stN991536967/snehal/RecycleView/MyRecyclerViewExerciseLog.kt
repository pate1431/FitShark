package project.stN991536967.snehal.RecycleView

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import project.stN991536967.snehal.Database.fitDatabase
import project.stN991536967.snehal.Entity.ExerciseEntity
import project.stN991536967.snehal.R

class MyRecyclerViewExerciseLog (public var sampleList:MutableList<ExerciseEntity>): RecyclerView.Adapter<MyRecyclerViewExerciseLog.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {

        val date: TextView = itemView.findViewById(R.id.dateLogs)
        val exerciseType: TextView = itemView.findViewById(R.id.exerciseType)
        val textView1: TextView = itemView.findViewById(R.id.output1)
        val textView2 : TextView = itemView.findViewById(R.id.output2)
        val btnDelete: ImageView = itemView.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.excercise_list,parent,false);
        val viewHolder = ViewHolder(itemView)
        return viewHolder;

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = sampleList[position]
        holder.exerciseType.text= currentItem.exerciseName
       holder.date.text = currentItem.date
        holder.textView1.text = "" +currentItem.speed
        holder.textView2.text = "" +currentItem.distance

        holder.btnDelete.setOnClickListener {
            s->
            val confirmation= AlertDialog.Builder(s.context)
            confirmation.setTitle("Delete")
            confirmation.setMessage("Are you sure You want to delete the Exercise")
            confirmation.setPositiveButton(android.R.string.yes) { dialog, which ->
                Toast.makeText(
                    s.context,
                    android.R.string.yes, Toast.LENGTH_SHORT
                ).show()
            }

            confirmation.setNegativeButton(android.R.string.no) { dialog, which ->
                Toast.makeText(
                    s.context,
                    android.R.string.no, Toast.LENGTH_SHORT
                ).show()
            }

            confirmation.setPositiveButton("Accept") { _, _ ->
                Toast.makeText(
                    s.context,
                    "Deleting log", Toast.LENGTH_SHORT
                ).show()
                fitDatabase.getInstance(s.context).exerciseDao().delete(currentItem.id)
                sampleList.removeAt(position)
                notifyDataSetChanged()
            }

            confirmation.setNegativeButton("Decline") { _, _ ->

                Toast.makeText(
                    s.context,
                    "Not deleting log", Toast.LENGTH_SHORT
                ).show()
            }

            confirmation.show()
        }
        }




    override fun getItemCount() = sampleList.size



}
