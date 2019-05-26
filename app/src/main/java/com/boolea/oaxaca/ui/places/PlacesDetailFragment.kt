package com.boolea.oaxaca.ui.places

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.boolea.oaxaca.R
import com.boolea.oaxaca.model.Comment
import com.boolea.oaxaca.model.Gallery
import com.boolea.oaxaca.model.Place
import com.boolea.oaxaca.ui.base.BaseFragment
import com.boolea.oaxaca.ui.places.adapter.PlaceCommentAdapter
import com.boolea.oaxaca.ui.places.adapter.PlaceGalleryAdapter
import com.boolea.oaxaca.ui.utils.snappyRecyclerView.CenterZoomLayoutManager
import com.boolea.oaxaca.ui.utils.snappyRecyclerView.CirclePagerIndicatorDecoration
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

    private lateinit var mCommentAdapter: PlaceCommentAdapter

    private lateinit var mGalleryAdapter: PlaceGalleryAdapter

    private lateinit var mCommentsReference: DatabaseReference


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
                    .child(mSelectedPlace!!.idPlace.toString())
            mCommentsReference.addValueEventListener(this)
            mCommentAdapter = PlaceCommentAdapter(context!!, mComments)

            mGalleryAdapter = PlaceGalleryAdapter(context!!, mSelectedPlace!!.gallery)


            val layoutManager = CenterZoomLayoutManager(context!!, LinearLayoutManager.HORIZONTAL, false)

            rvPlaceGallery.layoutManager = layoutManager

            rvPlaceGallery.addItemDecoration(CirclePagerIndicatorDecoration(ContextCompat.getColor(context!!,
                    R.color.colorAccent), ContextCompat.getColor(context!!, R.color.colorMorado)))

            rvPlaceGallery.adapter = mGalleryAdapter


            rvComments.layoutManager = LinearLayoutManager(context)
            rvComments.adapter = mCommentAdapter
            rvComments.setNestedScrollingEnabled(false);

            tvPlaceName.text = mSelectedPlace!!.name
            tvDescriptionDetail.text = mSelectedPlace!!.description
            toolbar.title = mSelectedPlace!!.name
            btnSendComment.setOnClickListener({
                sendComment(mSelectedPlace.hashCode().toString(), etCommentPlace.text.toString(),
                        5)
            })

        }
    }

    fun sendComment(placeId: String, text: String, rating: Long) {
        val comment = Comment(placeId, text, rating)
        mCommentsReference.child(Date().time.toString())
                .setValue(comment).addOnCompleteListener {
                    if (it.isComplete) {
                        showToast(getString(R.string.success_comment_added))
                    }
                }
    }

    override fun onCancelled(p0: DatabaseError) {
        //On cancelled
    }

    override fun onDataChange(dataSnap: DataSnapshot) {

        if (dataSnap.children.toList().isEmpty())
            return


        val last = dataSnap.children.last()

        val comments = emptyList<Comment>().toMutableList()

        dataSnap.children.forEach {
            if (it != null) {
                val map = (it.value as HashMap<*, *>)

                if (map.containsKey("text") && map.containsKey("rating")) {
                    val comment = Comment()
                    comment.text = map["text"] as String?
                    comment.rating = (map["rating"] as Long?)!!
                    comments.add(comment)

                    if (it.key.equals(last.key)) {
                        mComments.clear()
                        mComments.addAll(comments)
                        mCommentAdapter.notifyDataSetChanged()
                    }
                }
            }
        }
    }


    fun getSelectedPlace(): Place {
        return arguments!!.getSerializable(ARG_SELECTED_PLACE) as Place
    }


}