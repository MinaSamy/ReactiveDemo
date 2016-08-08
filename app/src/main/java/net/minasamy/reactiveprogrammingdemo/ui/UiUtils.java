package net.minasamy.reactiveprogrammingdemo.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.LinearInterpolator;

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

    public static Animator makeFabAnimation(View v){
        PropertyValuesHolder xValuesHolder=PropertyValuesHolder.ofFloat("scaleX",1.2f);
        PropertyValuesHolder yValuesHolder=PropertyValuesHolder.ofFloat("scaleY",1.2f);
        ObjectAnimator animator=ObjectAnimator.ofPropertyValuesHolder(v,xValuesHolder,yValuesHolder);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(500);
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        animator.setRepeatMode(ObjectAnimator.REVERSE);
        return animator;
    }
}
