package net.hyang.gbflip;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public class SwapViews implements Runnable {
    private boolean isFirstView;
    private ImageView image1;
    private ImageView image2;
    
    public SwapViews(boolean isFirstView, ImageView image1, ImageView image2) {
        this.isFirstView = isFirstView;
        this.image1 = image1;
        this.image2 = image2;   
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        final float centerX = image1.getWidth() / 2.0f;
        final float centerY = image1.getHeight() / 2.0f;
        FlipAnimation rotation;
        
        if(this.isFirstView) {
            image1.setVisibility(View.GONE);
            image2.setVisibility(View.VISIBLE);
//            image2.requestFocus();
            image2.bringToFront();            
            rotation = new FlipAnimation(-90, 0, centerX, centerY);
        } else {
            image2.setVisibility(View.GONE);
            image1.setVisibility(View.VISIBLE);
//            image1.requestFocus();
            image1.bringToFront();
            rotation = new FlipAnimation(90, 0, centerX, centerY);
        }
        
        rotation.setDuration(500);
        rotation.setFillAfter(true);
        rotation.setInterpolator(new DecelerateInterpolator());
        
        if(this.isFirstView) {
            image2.startAnimation(rotation);           
        } else {
            image1.startAnimation(rotation);
        }

    }

}
