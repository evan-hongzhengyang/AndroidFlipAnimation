package net.hyang.gbflip;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

public class GBFlipActivity extends Activity {
    private ImageView image1;
    private ImageView image2;
    
    private boolean isFirstImage = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // get the image
        image1 = (ImageView) this.findViewById(R.id.ImageView01);
        image2 = (ImageView) this.findViewById(R.id.ImageView02);
        
        // click to rotate
        image1.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View arg0) {
                if(isFirstImage) {
                    applyRotation(0, 90);                    
                } else {
                    applyRotation(0, -90);
                }
                isFirstImage = !isFirstImage;                
            }
        });
    }
    
    private void applyRotation(float start, float end) {
        // rotate from the center
        final float centerX = image1.getWidth() / 2.0f;
        final float centerY = image1.getHeight() / 2.0f;
        
        final FlipAnimation rotation = 
                new FlipAnimation(start, end, centerX, centerY);
        rotation.setDuration(500);
        rotation.setFillAfter(true);
        rotation.setInterpolator(new AccelerateInterpolator());
        rotation.setAnimationListener(new DisplayNextView(isFirstImage, image1, image2));
        
        if(isFirstImage) {
            image1.startAnimation(rotation);            
        } else {
            image2.startAnimation(rotation);
        }
    }
}
