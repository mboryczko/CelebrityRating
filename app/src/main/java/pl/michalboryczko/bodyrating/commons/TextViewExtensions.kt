package pl.michalboryczko.bodyrating.commons

import android.support.v4.graphics.drawable.DrawableCompat
import android.widget.TextView

/**
 * Created on 20.08.2018.
 */
/**
 * Extracted positions from [TextView.Drawables]
 */

val TextView.DRAWABLE_LEFT
	get() = 0

val TextView.DRAWABLE_TOP
	get() = 1

val TextView.DRAWABLE_RIGHT
	get() = 2

val TextView.DRAWABLE_BOTTOM
	get() = 3

fun TextView.setDrawableTint(color: Int, drawablePos: Int) {
	val copy = DrawableCompat.wrap(this.compoundDrawables[drawablePos]).mutate()
	DrawableCompat.setTint(copy, color)
	this.compoundDrawables[drawablePos] = copy
}