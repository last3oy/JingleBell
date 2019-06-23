package scb.academy.jinglebell.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import scb.academy.jinglebell.R
import scb.academy.jinglebell.vo.Room

class BAdapter : ListAdapter<Room, RoomViewHolder>(RoomDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RoomViewHolder(parent)

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class RoomDiffCallBack : DiffUtil.ItemCallback<Room>() {

    override fun areItemsTheSame(oldItem: Room, newItem: Room): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Room, newItem: Room): Boolean {
        return oldItem == newItem
    }

}

class RoomViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_room, parent, false)
) {

    fun bind(room: Room) {
        // TODO: bind data here.
    }

}