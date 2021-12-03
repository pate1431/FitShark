package project.stN991536967.snehal.RecycleView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import project.stN991536967.snehal.Entity.ExerciseEntity
import project.stN991536967.snehal.R

class MyRecyclerViewExerciseLog (public var sampleList:MutableList<ExerciseEntity>): RecyclerView.Adapter<MyRecyclerViewExerciseLog.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {

        val date: TextView = itemView.findViewById(R.id.dateLogs)
        val textView1: TextView = itemView.findViewById(R.id.output1)
        val textView2 : TextView = itemView.findViewById(R.id.output2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.excercise_list,parent,false);
        val viewHolder = ViewHolder(itemView)
        return viewHolder;

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = sampleList[position]
       holder.date.text = currentItem.date
        holder.textView1.text = "" +currentItem.speed
        holder.textView2.text = "" +currentItem.distance
    }

    override fun getItemCount() = sampleList.size



}
