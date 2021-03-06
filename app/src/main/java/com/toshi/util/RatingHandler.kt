/*
 * 	Copyright (c) 2017. Toshi Inc
 *
 * 	This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.toshi.util

import android.support.v7.app.AppCompatActivity
import com.toshi.model.local.Review
import com.toshi.view.fragment.DialogFragment.RateDialog

class RatingHandler(
        private val activity: AppCompatActivity,
        private val onRateClicked: (Review) -> Unit) {

    private var rateDialog: RateDialog? = null

    fun showRatingDialog(userAddress: String) {
        rateDialog = RateDialog.newInstance().apply {
            onRateClicked = RateDialog.OnRateDialogClickListener(
                    { rating, reviewText -> onRateClicked(Review(rating, userAddress, reviewText)) }
            )
        }
        rateDialog?.show(activity.supportFragmentManager, RateDialog.TAG)
    }

    fun clear() = rateDialog?.dismissAllowingStateLoss()
}