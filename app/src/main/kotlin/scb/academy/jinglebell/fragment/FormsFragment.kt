package scb.academy.jinglebell.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.fragment.app.Fragment
import scb.academy.jinglebell.R
import scb.academy.jinglebell.activity.WelcomeActivity

class FormsFragment : Fragment() {

    private lateinit var etNickname: EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_forms, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        etNickname = view.findViewById(R.id.et_nickname)

        etNickname.setOnEditorActionListener { textView, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEND) {
                WelcomeActivity.startActivity(requireContext(), textView.text.toString())
                true
            } else {
                false
            }
        }
    }

}