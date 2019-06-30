package scb.academy.jinglebell.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_room.view.*
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

    private val ivRoom = itemView.iv_room_image
    private val tvName = itemView.tv_room_name
    private val tvLocation = itemView.tv_room_location
    private val tvPrice = itemView.tv_room_price

    fun bind(room: Room) {
        ivRoom.setImageResource(room.imagePath)
        tvName.text = room.name
        tvLocation.text = room.location
        tvPrice.text = "฿${room.price}"
    }

}