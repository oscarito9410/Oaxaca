package com.boolea.oaxaca.ui.places

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.boolea.oaxaca.R
import com.boolea.oaxaca.model.Comment
import com.boolea.oaxaca.model.Place
import com.boolea.oaxaca.ui.base.BaseFragment
import com.bumptech.glide.Glide
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.content_place_detail.*
import kotlinx.android.synthetic.main.fragment_place_detail.*
import java.util.*

/**
 * Created by Oscar Emilio Pérez Mtz on 25/11/2018.
operez@na-at.com.mx
 */
class PlacesDetailFragment : BaseFragment(), ValueEventListener {


    companion object {
        val TAG = PlacesDetailFragment.toString()
        val ARG_SELECTED_PLACE = "selected_place"
        fun newInstance(place: Place): PlacesDetailFragment {
            val args = Bundle()
            args.putSerializable(ARG_SELECTED_PLACE, place)
            val fragment = PlacesDetailFragment()
            fragment.arguments = args
            return fragment
        }
    }


    var mSelectedPlace: Place? = null

    var mComments = emptyList<Comment>().toMutableList()

    lateinit var mCommentAdapter: PlaceCommentAdapter

    lateinit var mCommentsReference: DatabaseReference


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_place_detail, container, false)
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSelectedPlace = getSelectedPlace()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setInfoPlace()
    }

    fun setInfoPlace() {
        if (mSelectedPlace != null) {
            mCommentsReference = FirebaseDatabase.getInstance().getReference("comments")
                    .child(mSelectedPlace!!.hashCode().toString());
            mCommentsReference.addValueEventListener(this)
            mCommentAdapter = PlaceCommentAdapter(context!!, mComments)
            rvComments.layoutManager = LinearLayoutManager(context)
            rvComments.adapter = mCommentAdapter
            rvComments.setHasFixedSize(true);
            rvComments.setNestedScrollingEnabled(true);
            tvDescriptionDetail.text = mSelectedPlace!!.description
            Glide.with(context!!).load(mSelectedPlace!!.image).into(ivPlaceDetail)
            toolbar.title = mSelectedPlace!!.name
            btnSendComment.setOnClickListener({
                sendComment(mSelectedPlace.hashCode().toString(), etCommentPlace.text.toString(),
                        5)
            })

        }
    }

    fun sendComment(placeId: String, text: String, rating: Long) {
        val comment = Comment(placeId, text, rating)
        mCommentsReference.child(placeId)
                .setValue(comment).addOnCompleteListener {
                    if (it.isComplete) {
                        showToast("Comentario agregado correctamente!")
                    }
                }
    }

    override fun onCancelled(p0: DatabaseError) {
        //On cancelled
    }

    override fun onDataChange(dataSnap: DataSnapshot) {
        dataSnap.children.forEach {
            if (it != null) {
                val map = (it.value as HashMap<*, *>)
                val comment = Comment()
                comment.text = map["text"] as String?
                comment.rating = (map["rating"] as Long?)!!
                mComments.add(comment)
                mCommentAdapter.notifyDataSetChanged()
            }
        }
    }


    fun getSelectedPlace(): Place {
        return arguments!!.getSerializable(ARG_SELECTED_PLACE) as Place
    }


}