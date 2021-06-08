package com.mamunsproject.awesomecollege_user_app.Ui.Home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mamunsproject.awesomecollege_user_app.MainActivity;
import com.mamunsproject.awesomecollege_user_app.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

public class HomeFragment extends Fragment {

    private SliderLayout sliderLayout;
    private ImageView map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);



        sliderLayout = view.findViewById(R.id.slider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(2);

        setSliderView();


        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });


        return view;


    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0,0?q=Gopaldi Nazrul Islam Babu College");

        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    private void setSliderView() {
        for (int i = 0; i < 4; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(getContext());

            switch (i) {

                case 0:

                    sliderView.setImageUrl("https://scontent.fdac116-1.fna.fbcdn.net/v/t1.6435-9/58378171_2015466688581903_5723507808452739072_n.jpg?_nc_cat=106&ccb=1-3&_nc_sid=e3f864&_nc_ohc=KxXbtYPy6cwAX-ijX-m&_nc_ht=scontent.fdac116-1.fna&oh=d55c1162b21cfc7ffb558c33d8fe2472&oe=60D3FB4C");
                    break;

                case 1:
                    sliderView.setImageUrl("https://tritiyomatra.com/Media/PhotoGallery/tm-pg-07d123c0-784d-4ed3-b612-7d274bf99281-3.jpg");
                    break;

                case 2:
                    sliderView.setImageUrl("https://scontent.fdac116-1.fna.fbcdn.net/v/t1.18169-9/10570318_536995376429049_7462245630342783566_n.jpg?_nc_cat=110&ccb=1-3&_nc_sid=cdbe9c&_nc_ohc=itfvgbu_EJQAX_xlpRW&_nc_ht=scontent.fdac116-1.fna&oh=219f13518054c66f246e2e84fe60eb55&oe=60D2AF0A");
                    break;

                case 3:
                    sliderView.setImageUrl("https://scontent.fdac116-1.fna.fbcdn.net/v/t31.18172-8/10506561_536978343097419_5116622782281000142_o.jpg?_nc_cat=109&ccb=1-3&_nc_sid=174925&_nc_ohc=RdujlxODCpgAX_dQnTD&_nc_ht=scontent.fdac116-1.fna&oh=fbfa5bf65bfb111a6453580cb3c0cec2&oe=60D465F7");
                    break;


            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderLayout.addSliderView(sliderView);
        }
    }
}