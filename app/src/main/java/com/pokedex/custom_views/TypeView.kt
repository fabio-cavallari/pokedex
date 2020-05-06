package com.pokedex.custom_views

import android.content.Context
import android.view.LayoutInflater
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.pokedex.R
import kotlinx.android.synthetic.main.pokemon_list_item_type.view.*

class TypeView: CoordinatorLayout {
    constructor(context: Context, type: String): super(context){
        LayoutInflater.from(context).inflate(R.layout.pokemon_list_item_type, this, true)
        val mTypeIcon = type_icon
//        mTypeIcon.setColorFilter(context.resources.getIdentifier(type, "color",context.packageName))
//        mTypeIcon.setImageResource(context.resources.getIdentifier(type, "drawable", context.packageName))
        mTypeIcon.setImageResource(R.drawable.ic_fire)
    }
}

/*
package com.b2w.droidwork.customview

import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.b2w.droidwork.IdentifierUtils
import com.b2w.droidwork.model.product.review.Commentary

class ReviewCardCommentaryView: ConstraintLayout {

    var likeCounts = 0
    var dislikeCounts = 0

    val mIdentifierUtils: IdentifierUtils

    private val mCommentaryTitle:TextView
    private val mCommentaryRating:RatingBar
    private val mCommentaryDescription:TextView
    private val mCommentaryAuthor:TextView
    private val mLikeButton: ImageView
    private val mLikeCount: TextView
    private val mDislikeButton: ImageView
    private val mDislikeCount : TextView

    constructor(context: Context, commentary: Commentary): super(context){

        mIdentifierUtils = IdentifierUtils.getInstance(context)
        LayoutInflater.from(context).inflate(mIdentifierUtils.getLayoutByIdentifier("view_review_card_commentary"), this, true)

        mCommentaryTitle = findViewById(mIdentifierUtils.getItemIdByIdentifier("commentary_title"))
        mCommentaryRating = findViewById(mIdentifierUtils.getItemIdByIdentifier("commentary_rating"))
        mCommentaryDescription = findViewById(mIdentifierUtils.getItemIdByIdentifier("commentary_description"))
        mCommentaryAuthor = findViewById(mIdentifierUtils.getItemIdByIdentifier("commentary_author"))
        mLikeButton = findViewById(mIdentifierUtils.getItemIdByIdentifier("like_button"))
        mLikeCount = findViewById(mIdentifierUtils.getItemIdByIdentifier("like_count"))
        mDislikeButton = findViewById(mIdentifierUtils.getItemIdByIdentifier("dislike_button"))
        mDislikeCount  = findViewById(mIdentifierUtils.getItemIdByIdentifier("dislike_count"))

        fun like(){
            mLikeCount.text = "(${likeCounts + 1})"
            mDislikeCount.text = "(${dislikeCounts})"
            mLikeButton.setColorFilter(mIdentifierUtils.getColorByIdentifier("color_primary"))
            mDislikeButton.setColorFilter(null)
        }

        fun dislike(){
            mDislikeCount.text = "(${dislikeCounts + 1})"
            mLikeCount.text = "(${likeCounts})"
            mDislikeButton.setColorFilter(mIdentifierUtils.getColorByIdentifier("color_primary"))
            mLikeButton.setColorFilter(null)
        }

        mLikeButton.setOnClickListener { like() }
        mDislikeButton.setOnClickListener { dislike() }
        setCommentaryInfo(commentary)
    }

    private fun setCommentaryInfo(commentary: Commentary){
        mCommentaryTitle.text = commentary.title
        mCommentaryRating.rating = commentary.rating.toFloat()
        mCommentaryDescription.text = commentary.reviewText
        commentary.name?.let{ mCommentaryAuthor.text = it }
        likeCounts = commentary.positiveFeedbackCount
        dislikeCounts = commentary.negativeFeedbackCount
        mLikeCount.text = "(${commentary.positiveFeedbackCount})"
        mDislikeCount.text = "(${commentary.negativeFeedbackCount})"
    }
}
 */