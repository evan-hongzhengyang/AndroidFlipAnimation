package net.hyang.gbflip;
import android.view.animation.Animation;
import android.widget.ImageView;

public class DisplayNextView implements Animation.AnimationListener {
    private boolean currentView;
    private ImageView image1;
    private ImageView image2;
    
    public DisplayNextView(boolean currentView, ImageView image1, ImageView image2) {
        this.currentView = currentView;
        this.image1 = image1;
        this.image2 = image2;
    }

    @Override
    public void onAnimationEnd(Animation arg0) {
        // TODO Auto-generated method stub
        image1.post(new SwapViews(this.currentView, image1, image2));
        
    }

    @Override
    public void onAnimationRepeat(Animation arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onAnimationStart(Animation arg0) {
        // TODO Auto-generated method stub
        
    }

}
