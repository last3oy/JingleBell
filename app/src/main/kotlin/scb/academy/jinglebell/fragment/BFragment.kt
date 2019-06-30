package scb.academy.jinglebell.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import scb.academy.jinglebell.R
import scb.academy.jinglebell.adapter.BAdapter
import scb.academy.jinglebell.vo.Room

class BFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val element = Room(
                "hah",
                1000.0f,
                "2000",
                R.drawable.room_1
        )
        val rooms = listOf(
                element,
                element,
                element,
                element,
                element,
                element,
                element,
                element,
                element,
                element,
                element,
                element
        )

        val rvRooms: RecyclerView = view.findViewById(R.id.rv_rooms)
        rvRooms.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = BAdapter().apply {
                submitList(rooms)
            }
        }
    }
}