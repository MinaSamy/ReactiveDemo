package net.minasamy.reactiveprogrammingdemo.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;

/**
 * Created by minsamy on 8/1/2016.
 */
public class UiUtils {
    public static Animator makeCardViewClickAnimation(View v) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int centerX = v.getWidth() / 2;
            int centerY = v.getHeight() / 2;
            float finalRadius = (float) Math.hypot(centerX, centerY);
            Animator animator = ViewAnimationUtils.createCircularReveal(v, centerX, centerY, 0, finalRadius);
            return animator;
        } else {
            ObjectAnimator animator=ObjectAnimator.ofFloat(v,"alpha",0.0f,1.0f);
            animator.setDuration(100);
            return animator;
        }
    }
}
