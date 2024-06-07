package com.example.modelingrobots

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.textfield.TextInputEditText

class TimeDataAdapter(private val dataSet: Array<ItemTimeTable>):  RecyclerView.Adapter<TimeDataAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val time: TextInputEditText
        val q1t: TextInputEditText
        val q2t: TextInputEditText

        init {
            // Define click listener for the ViewHolder's View
            time = view.findViewById(R.id.et_time)
            q1t = view.findViewById(R.id.et_q1time)
            q2t = view.findViewById(R.id.et_q2time)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_time_table, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.time.setText(dataSet[position].t.toString())
        viewHolder.time.hint = "t$position"
        viewHolder.q1t.setText(dataSet[position].q1.toString())
        viewHolder.q1t.hint = "q1(t$position)"
        viewHolder.q2t.setText(dataSet[position].q2.toString())
        viewHolder.q2t.hint = "q2(t$position)"
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size
}