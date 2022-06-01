package com.duolight.projeteg23.controller;

import androidx.annotation.DrawableRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.duolight.projeteg23.R;

public class Reserve extends AppCompatActivity {
    private static final String SHARED_PREF_JOUEUR_1_INFO = "SHARED_PREF_JOUEUR_1_INFO"; // nom du fichier
    private static final String SHARED_PREF_JOUEUR_1_INFO_KEY = "SHARED_PREF_JOUEUR_1_INFO_KEY"; // Key
    private TextView mBranche;
    // Create a string for the ImageView label.
    private static final String IMAGEVIEW_TAG1 = "Chef de guerre";
    private static final String IMAGEVIEW_TAG2 = "Soldat d'élite";
    private static final String IMAGEVIEW_TAG3 = "Alpha";
    private static final String IMAGEVIEW_TAG4 = "Bravo";
    private static final String IMAGEVIEW_TAG5 = "Charlie";

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);

        mBranche=findViewById(R.id.joueur1);
        String brancheJoueur1 = getSharedPreferences(SHARED_PREF_JOUEUR_1_INFO,MODE_PRIVATE).getString(SHARED_PREF_JOUEUR_1_INFO_KEY,null);
        mBranche.setText("Joueur 1 : " + brancheJoueur1);

        // Create new ImageViews.
        ImageView imageView1 = findViewById(R.id.imageView);
        ImageView imageView2 = findViewById(R.id.imageView2);
        ImageView imageView3 = findViewById(R.id.imageView3);
        ImageView imageView4 = findViewById(R.id.imageView4);
        ImageView imageView5 = findViewById(R.id.imageView5);
        ImageView reserve1 = findViewById(R.id.imageViewReserve1);
        ImageView reserve2 = findViewById(R.id.imageViewReserve2);
        ImageView reserve3 = findViewById(R.id.imageViewReserve3);
        ImageView reserve4 = findViewById(R.id.imageViewReserve4);
        ImageView reserve5 = findViewById(R.id.imageViewReserve5);

        // Set tags.
        imageView1.setTag(IMAGEVIEW_TAG1);
        imageView2.setTag(IMAGEVIEW_TAG2);
        imageView3.setTag(IMAGEVIEW_TAG3);
        imageView4.setTag(IMAGEVIEW_TAG4);
        imageView5.setTag(IMAGEVIEW_TAG5);

        // Sets a long click listener for the ImageView using an anonymous listener object that
        // implements the OnLongClickListener interface.
        imageView1.setOnLongClickListener(v -> {
            // Create a new ClipData.
            // This is done in two steps to provide clarity. The convenience method
            // ClipData.newPlainText() can create a plain text ClipData in one step.

            // Create a new ClipData.Item from the ImageView object's tag.
            ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());

            // Create a new ClipData using the tag as a label, the plain text MIME type, and
            // the already-created item. This creates a new ClipDescription object within the
            // ClipData and sets its MIME type to "text/plain".
            ClipData dragData = new ClipData(
                    (CharSequence) v.getTag(),
                    new String[] { ClipDescription.MIMETYPE_TEXT_PLAIN },
                    item);
            // Instantiate the drag shadow builder.
            View.DragShadowBuilder myShadow = new MyDragShadowBuilder(imageView1);
            // Start the drag.
            v.startDragAndDrop(dragData,  // The data to be dragged
                    myShadow,             // The drag shadow builder
                    null,      // No need to use local data
                    0                // Flags (not currently used, set to 0)
            );
            // Indicate that the long-click was handled.
            return true;
        });
        imageView2.setOnLongClickListener(v -> {
            ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
            ClipData dragData = new ClipData((CharSequence) v.getTag(), new String[] { ClipDescription.MIMETYPE_TEXT_PLAIN }, item);
            View.DragShadowBuilder myShadow = new MyDragShadowBuilder(imageView2);
            v.startDragAndDrop(dragData, myShadow,null,0);
            return true;
        });
        imageView3.setOnLongClickListener(v -> {
            ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
            ClipData dragData = new ClipData((CharSequence) v.getTag(), new String[] { ClipDescription.MIMETYPE_TEXT_PLAIN }, item);
            View.DragShadowBuilder myShadow = new MyDragShadowBuilder(imageView3);
            v.startDragAndDrop(dragData, myShadow,null,0);
            return true;
        });
        imageView4.setOnLongClickListener(v -> {
            ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
            ClipData dragData = new ClipData((CharSequence) v.getTag(), new String[] { ClipDescription.MIMETYPE_TEXT_PLAIN }, item);
            View.DragShadowBuilder myShadow = new MyDragShadowBuilder(imageView4);
            v.startDragAndDrop(dragData, myShadow,null,0);
            return true;
        });
        imageView5.setOnLongClickListener(v -> {
            ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
            ClipData dragData = new ClipData((CharSequence) v.getTag(), new String[] { ClipDescription.MIMETYPE_TEXT_PLAIN }, item);
            View.DragShadowBuilder myShadow = new MyDragShadowBuilder(imageView5);
            v.startDragAndDrop(dragData, myShadow,null,0);
            return true;
        });

        // Set the drag event listener for the View.
        reserve1.setOnDragListener( (v, e) -> {
            // Handles each of the expected events.
            switch(e.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // Determines if this View can accept the dragged data.
                    if (e.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                        // As an example of what your application might do, applies a blue color tint
                        // to the View to indicate that it can accept data.
                        ((ImageView)v).setColorFilter(Color.BLUE);
                        // Invalidate the view to force a redraw in the new tint.
                        v.invalidate();
                        // Returns true to indicate that the View can accept the dragged data.
                        return true;
                    }
                    // Returns false to indicate that, during the current drag and drop operation,
                    // this View will not receive events again until ACTION_DRAG_ENDED is sent.
                    return false;

                case DragEvent.ACTION_DRAG_ENTERED:
                    // Applies a green tint to the View.
                    ((ImageView)v).setColorFilter(Color.GREEN);
                    // Invalidates the view to force a redraw in the new tint.
                    v.invalidate();
                    // Returns true; the value is ignored.
                    return true;

                case DragEvent.ACTION_DRAG_LOCATION:
                    // Ignore the event.
                    return true;

                case DragEvent.ACTION_DRAG_EXITED:
                    // Resets the color tint to blue.
                    ((ImageView)v).setColorFilter(Color.BLUE);
                    // Invalidates the view to force a redraw in the new tint.
                    v.invalidate();
                    // Returns true; the value is ignored.
                    return true;

                case DragEvent.ACTION_DROP:
                    // Gets the item containing the dragged data.
                    ClipData.Item item = e.getClipData().getItemAt(0);
                    // Gets the text data from the item.
                    CharSequence dragData = item.getText();
                    // Displays a message containing the dragged data.
                    Toast.makeText(this, "Vous avez déplacé un " + dragData, Toast.LENGTH_SHORT).show();
                    // Turns off any color tints.
                    ((ImageView)v).clearColorFilter();

                    // Set the linear layout's background to green, showing that the hole is filled
                    View layoutView = findViewById(R.id.reserve1_layout);
                    layoutView.setBackgroundResource(R.drawable.border_reserve);
                    // Check and match the dragData to put the right image
                    TextView textView = findViewById(R.id.reserve1_title);
                    if(dragData.equals(imageView1.getTag())) {
                        ((ImageView) v).setImageResource(R.drawable.logo_chefdeguerre);
                        textView.setText("Chef de Guerre");
                    } else if (dragData.equals(imageView2.getTag())) {
                        ((ImageView) v).setImageResource(R.drawable.logo_elite);
                        textView.setText("Soldat d'élite");
                    } else if (dragData.equals(imageView3.getTag())) {
                        ((ImageView) v).setImageResource(R.drawable.logo_alpha);
                        textView.setText("Alpha");
                    } else if (dragData.equals(imageView4.getTag())) {
                        ((ImageView) v).setImageResource(R.drawable.logo_bravo);
                        textView.setText("Bravo");
                    } else if (dragData.equals(imageView5.getTag())) {
                        ((ImageView) v).setImageResource(R.drawable.logo_charlie);
                        textView.setText("Charlie");
                    }
                    // Returns true. DragEvent.getResult() will return true.
                    return true;

                case DragEvent.ACTION_DRAG_ENDED:
                    // Turns off any color tinting.
                    ((ImageView)v).clearColorFilter();
                    // Invalidates the view to force a redraw.
                    v.invalidate();
                    // Returns true; the value is ignored.
                    return true;

                // An unknown action type was received.
                default:
                    Log.e("DragDrop Example","Unknown action type received by View.OnDragListener.");
                    break;
            }
            return false;
        });
        reserve2.setOnDragListener((v, e) -> {
            switch(e.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    if (e.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                        ((ImageView)v).setColorFilter(Color.BLUE);
                        v.invalidate();
                        return true;
                    }
                    return false;

                case DragEvent.ACTION_DRAG_ENTERED:
                    ((ImageView)v).setColorFilter(Color.GREEN);
                    v.invalidate();
                    return true;

                case DragEvent.ACTION_DRAG_LOCATION:
                    return true;

                case DragEvent.ACTION_DRAG_EXITED:
                    ((ImageView)v).setColorFilter(Color.BLUE);
                    v.invalidate();
                    return true;

                case DragEvent.ACTION_DROP:
                    ClipData.Item item = e.getClipData().getItemAt(0);
                    CharSequence dragData = item.getText();
                    Toast.makeText(this, "Vous avez déplacé un " + dragData, Toast.LENGTH_SHORT).show();
                    ((ImageView)v).clearColorFilter();

                    View layoutView = findViewById(R.id.reserve2_layout);
                    layoutView.setBackgroundResource(R.drawable.border_reserve);
                    TextView textView = findViewById(R.id.reserve2_title);

                    if(dragData.equals(imageView1.getTag())) {
                        ((ImageView) v).setImageResource(R.drawable.logo_chefdeguerre);
                        textView.setText("Chef de Guerre");
                    } else if (dragData.equals(imageView2.getTag())) {
                        ((ImageView) v).setImageResource(R.drawable.logo_elite);
                        textView.setText("Soldat d'élite");
                    } else if (dragData.equals(imageView3.getTag())) {
                        ((ImageView) v).setImageResource(R.drawable.logo_alpha);
                        textView.setText("Alpha");
                    } else if (dragData.equals(imageView4.getTag())) {
                        ((ImageView) v).setImageResource(R.drawable.logo_bravo);
                        textView.setText("Bravo");
                    } else if (dragData.equals(imageView5.getTag())) {
                        ((ImageView) v).setImageResource(R.drawable.logo_charlie);
                        textView.setText("Charlie");
                    }
                    return true;

                case DragEvent.ACTION_DRAG_ENDED:
                    ((ImageView)v).clearColorFilter();
                    v.invalidate();
                    return true;

                default:
                    Log.e("DragDrop Example","Unknown action type received by View.OnDragListener.");
                    break;
            }
            return false;
        });
        reserve3.setOnDragListener((v, e) -> {
            switch(e.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    if (e.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                        ((ImageView)v).setColorFilter(Color.BLUE);
                        v.invalidate();
                        return true;
                    }
                    return false;

                case DragEvent.ACTION_DRAG_ENTERED:
                    ((ImageView)v).setColorFilter(Color.GREEN);
                    v.invalidate();
                    return true;

                case DragEvent.ACTION_DRAG_LOCATION:
                    return true;

                case DragEvent.ACTION_DRAG_EXITED:
                    ((ImageView)v).setColorFilter(Color.BLUE);
                    v.invalidate();
                    return true;

                case DragEvent.ACTION_DROP:
                    ClipData.Item item = e.getClipData().getItemAt(0);
                    CharSequence dragData = item.getText();
                    Toast.makeText(this, "Vous avez déplacé un " + dragData, Toast.LENGTH_SHORT).show();
                    ((ImageView)v).clearColorFilter();

                    View layoutView = findViewById(R.id.reserve3_layout);
                    layoutView.setBackgroundResource(R.drawable.border_reserve);
                    TextView textView = findViewById(R.id.reserve3_title);

                    if(dragData.equals(imageView1.getTag())) {
                        ((ImageView) v).setImageResource(R.drawable.logo_chefdeguerre);
                        textView.setText("Chef de Guerre");
                    } else if (dragData.equals(imageView2.getTag())) {
                        ((ImageView) v).setImageResource(R.drawable.logo_elite);
                        textView.setText("Soldat d'élite");
                    } else if (dragData.equals(imageView3.getTag())) {
                        ((ImageView) v).setImageResource(R.drawable.logo_alpha);
                        textView.setText("Alpha");
                    } else if (dragData.equals(imageView4.getTag())) {
                        ((ImageView) v).setImageResource(R.drawable.logo_bravo);
                        textView.setText("Bravo");
                    } else if (dragData.equals(imageView5.getTag())) {
                        ((ImageView) v).setImageResource(R.drawable.logo_charlie);
                        textView.setText("Charlie");
                    }
                    return true;

                case DragEvent.ACTION_DRAG_ENDED:
                    ((ImageView)v).clearColorFilter();
                    v.invalidate();
                    return true;

                default:
                    Log.e("DragDrop Example","Unknown action type received by View.OnDragListener.");
                    break;
            }
            return false;
        });
        reserve4.setOnDragListener((v, e) -> {
            switch(e.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    if (e.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                        ((ImageView)v).setColorFilter(Color.BLUE);
                        v.invalidate();
                        return true;
                    }
                    return false;

                case DragEvent.ACTION_DRAG_ENTERED:
                    ((ImageView)v).setColorFilter(Color.GREEN);
                    v.invalidate();
                    return true;

                case DragEvent.ACTION_DRAG_LOCATION:
                    return true;

                case DragEvent.ACTION_DRAG_EXITED:
                    ((ImageView)v).setColorFilter(Color.BLUE);
                    v.invalidate();
                    return true;

                case DragEvent.ACTION_DROP:
                    ClipData.Item item = e.getClipData().getItemAt(0);
                    CharSequence dragData = item.getText();
                    Toast.makeText(this, "Vous avez déplacé un " + dragData, Toast.LENGTH_SHORT).show();
                    ((ImageView)v).clearColorFilter();

                    View layoutView = findViewById(R.id.reserve4_layout);
                    layoutView.setBackgroundResource(R.drawable.border_reserve);
                    TextView textView = findViewById(R.id.reserve4_title);

                    if(dragData.equals(imageView1.getTag())) {
                        ((ImageView) v).setImageResource(R.drawable.logo_chefdeguerre);
                        textView.setText("Chef de Guerre");
                    } else if (dragData.equals(imageView2.getTag())) {
                        ((ImageView) v).setImageResource(R.drawable.logo_elite);
                        textView.setText("Soldat d'élite");
                    } else if (dragData.equals(imageView3.getTag())) {
                        ((ImageView) v).setImageResource(R.drawable.logo_alpha);
                        textView.setText("Alpha");
                    } else if (dragData.equals(imageView4.getTag())) {
                        ((ImageView) v).setImageResource(R.drawable.logo_bravo);
                        textView.setText("Bravo");
                    } else if (dragData.equals(imageView5.getTag())) {
                        ((ImageView) v).setImageResource(R.drawable.logo_charlie);
                        textView.setText("Charlie");
                    }
                    return true;

                case DragEvent.ACTION_DRAG_ENDED:
                    ((ImageView)v).clearColorFilter();
                    v.invalidate();
                    return true;

                default:
                    Log.e("DragDrop Example","Unknown action type received by View.OnDragListener.");
                    break;
            }
            return false;
        });
        reserve5.setOnDragListener((v, e) -> {
            switch(e.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    if (e.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                        ((ImageView)v).setColorFilter(Color.BLUE);
                        v.invalidate();
                        return true;
                    }
                    return false;

                case DragEvent.ACTION_DRAG_ENTERED:
                    ((ImageView)v).setColorFilter(Color.GREEN);
                    v.invalidate();
                    return true;

                case DragEvent.ACTION_DRAG_LOCATION:
                    return true;

                case DragEvent.ACTION_DRAG_EXITED:
                    ((ImageView)v).setColorFilter(Color.BLUE);
                    v.invalidate();
                    return true;

                case DragEvent.ACTION_DROP:
                    ClipData.Item item = e.getClipData().getItemAt(0);
                    CharSequence dragData = item.getText();
                    Toast.makeText(this, "Vous avez déplacé un " + dragData, Toast.LENGTH_SHORT).show();
                    ((ImageView)v).clearColorFilter();

                    View layoutView = findViewById(R.id.reserve5_layout);
                    layoutView.setBackgroundResource(R.drawable.border_reserve);
                    TextView textView = findViewById(R.id.reserve5_title);

                    if(dragData.equals(imageView1.getTag())) {
                        ((ImageView) v).setImageResource(R.drawable.logo_chefdeguerre);
                        textView.setText("Chef de Guerre");
                    } else if (dragData.equals(imageView2.getTag())) {
                        ((ImageView) v).setImageResource(R.drawable.logo_elite);
                        textView.setText("Soldat d'élite");
                    } else if (dragData.equals(imageView3.getTag())) {
                        ((ImageView) v).setImageResource(R.drawable.logo_alpha);
                        textView.setText("Alpha");
                    } else if (dragData.equals(imageView4.getTag())) {
                        ((ImageView) v).setImageResource(R.drawable.logo_bravo);
                        textView.setText("Bravo");
                    } else if (dragData.equals(imageView5.getTag())) {
                        ((ImageView) v).setImageResource(R.drawable.logo_charlie);
                        textView.setText("Charlie");
                    }
                    return true;

                case DragEvent.ACTION_DRAG_ENDED:
                    ((ImageView)v).clearColorFilter();
                    v.invalidate();
                    return true;

                default:
                    Log.e("DragDrop Example","Unknown action type received by View.OnDragListener.");
                    break;
            }
            return false;
        });

        final ImageView mArrowRight= findViewById(R.id.arrow_right);
        mArrowRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //------------------------------------------ICI changement de Page------------------------------------//
                Intent intent = new Intent(Reserve.this, DeploiementArmee.class);
                // Exécution de l’activité : ouverture de la fenêtre
                startActivity(intent);
            }
        });
    }

    private static class MyDragShadowBuilder extends View.DragShadowBuilder {
        // The drag shadow image, defined as a drawable object.
        private static Drawable shadow;

        // Constructor
        public MyDragShadowBuilder(View v) {
            // Stores the View parameter.
            super(v);
            // Creates a draggable image that fills the Canvas provided by the system.
            shadow = new ColorDrawable(Color.LTGRAY);
        }

        // Defines a callback that sends the drag shadow dimensions and touch point
        // back to the system.
        @Override
        public void onProvideShadowMetrics (Point size, Point touch) {
            // Defines local variables
            int width, height;
            // Set the width of the shadow to half the width of the original View.
            width = getView().getWidth() / 2;
            // Set the height of the shadow to half the height of the original View.
            height = getView().getHeight() / 2;

            // The drag shadow is a ColorDrawable. This sets its dimensions to be the
            // same as the Canvas that the system provides. As a result, the drag shadow
            // fills the Canvas.
            shadow.setBounds(0, 0, width, height);

            // Set the size parameter's width and height values. These get back to the
            // system through the size parameter.
            size.set(width, height);

            // Set the touch point's position to be in the middle of the drag shadow.
            touch.set(width / 2, height / 2);
        }

        // Defines a callback that draws the drag shadow in a Canvas that the system
        // constructs from the dimensions passed to onProvideShadowMetrics().
        @Override
        public void onDrawShadow (Canvas canvas) {
            // Draw the ColorDrawable on the Canvas passed in from the system.
            shadow.draw(canvas);
        }
    }
}