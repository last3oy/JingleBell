package scb.academy.jinglebell.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import scb.academy.jinglebell.R

class AFragment: Fragment() {

    companion object {
        private const val KEY_ROTATION_COUNT = "ROTATION_COUNT"
    }

    private var tvRotationCountLabel: TextView? = null
    private var rotationCount: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rotationCount = savedInstanceState?.getInt(KEY_ROTATION_COUNT) ?: 0
        tvRotationCountLabel = view.findViewById(R.id.tv_rotation_count_label)
    }

    override fun onStart() {
        super.onStart()
        tvRotationCountLabel?.text = rotationCount.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_ROTATION_COUNT, rotationCount.inc())
    }
}