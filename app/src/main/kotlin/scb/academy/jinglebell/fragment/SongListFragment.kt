package scb.academy.jinglebell.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import scb.academy.jinglebell.R
import scb.academy.jinglebell.activity.SongInfoActivity
import scb.academy.jinglebell.adapter.SongAdapter
import scb.academy.jinglebell.service.ApiManager
import scb.academy.jinglebell.vo.SongSearchResult

class SongListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val element = Room(
//                "hah",
//                1000.0f,
//                "2000",
//                R.drawable.room_1
//        )
//        val rooms = listOf(
//                element,
//                element,
//                element,
//                element,
//                element,
//                element,
//                element,
//                element,
//                element,
//                element,
//                element,
//                element
//        )
//
        val rvRooms: RecyclerView = view.findViewById(R.id.rv_rooms)
        rvRooms.apply {
            layoutManager = LinearLayoutManager(context)
            itemAnimator = DefaultItemAnimator()
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        }

        ApiManager.artistSevice.songs("taylorswift").enqueue(object : Callback<SongSearchResult> {
            override fun onFailure(call: Call<SongSearchResult>, t: Throwable) {
                Log.i("retrofit", t.message ?: "")
            }

            override fun onResponse(call: Call<SongSearchResult>, response: Response<SongSearchResult>) {
                Log.i("retrofit", response.body()?.toString() ?: "")
                rvRooms.adapter = SongAdapter {
                    val intent = Intent(context, SongInfoActivity::class.java).apply {
                        putExtra("song", it)
                    }
                    startActivity(intent)
                }
                        .apply {
                            submitList(response.body()!!.results)
                        }
            }
        })
    }
}