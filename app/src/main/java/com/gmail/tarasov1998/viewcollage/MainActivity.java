package com.gmail.tarasov1998.viewcollage;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lopei.collageview.CollageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CollageView collageView = (CollageView) findViewById(R.id.collageView);

        String[] urls = new String[]{"https://www.gstatic.com/webp/gallery3/1.sm.png", "https://www.gstatic.com/webp/gallery3/4.sm.jpg", "https://www.developers.google.com/search/mobile-sites/imgs/mobile-seo/separate-urls.png"};

        collageView
                .photoMargin(1)
                .photoPadding(3)
                .backgroundColor(Color.RED)
                .photoFrameColor(Color.BLUE)
                .useFirstAsHeader(true) // makes first photo fit device widtdh and use full line
                .defaultPhotosForLine(5) // sets default photos number for line of photos (can be changed by program at runtime)
                .iconSelector(new CollageView.IconSelector() {
                                  @Override
                                  public int getIconResId(int pos) {
                                      if (pos == 0 || pos  == 4) {
                                          return R.mipmap.ic_launcher;
                                      }
                                      return 0;
                                  }
                              }
                        , getResources().getDimensionPixelSize(R.dimen.icon_size)) // adds cardview backgrounds to all photos
                .maxWidth(100) // will resize images if their side is bigger than 100
                .placeHolder(R.drawable.placeholder_photo) //adds placeholder resource
                .headerForm(CollageView.ImageForm.IMAGE_FORM_SQUARE) // sets form of image for header (if useFirstAsHeader == true)
                .photosForm(CollageView.ImageForm.IMAGE_FORM_HALF_HEIGHT) //sets form of image for other photos
                .loadPhotos(urls); // here you can use Array/List of photo urls or array of resource ids

        collageView.setOnPhotoClickListener(new CollageView.OnPhotoClickListener() {
            @Override
            public void onPhotoClick(int position) {
                // do random stuff here
            }
        });
    }


}
