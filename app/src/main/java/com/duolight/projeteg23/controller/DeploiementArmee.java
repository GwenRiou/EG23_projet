package com.duolight.projeteg23.controller;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.duolight.projeteg23.R;

public class DeploiementArmee extends AppCompatActivity implements View.OnClickListener {
    private static final String SHARED_PREF_JOUEUR_1_INFO = "SHARED_PREF_JOUEUR_1_INFO"; // nom du fichier
    private static final String SHARED_PREF_JOUEUR_1_INFO_KEY = "SHARED_PREF_JOUEUR_1_INFO_KEY"; // Key
    private TextView mBranche;
    private Button next;

    private static final String VIEW_TAG1 = "Chef de guerre";
    private static final String VIEW_TAG2 = "Soldat d'élite";
    private static final String VIEW_TAG3 = "Alpha";
    private static final String VIEW_TAG4 = "Bravo";
    private static final String VIEW_TAG5 = "Charlie";

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deploiement_armee);
        mBranche=findViewById(R.id.joueur1);
        String brancheJoueur1 = getSharedPreferences(SHARED_PREF_JOUEUR_1_INFO,MODE_PRIVATE).getString(SHARED_PREF_JOUEUR_1_INFO_KEY,null);
        mBranche.setText("Joueur 1 : " + brancheJoueur1);

        next = findViewById(R.id.nextButton);
        next.setOnClickListener(this);

        // Create new views to drags
        LinearLayout groupe1 = (LinearLayout) findViewById(R.id.armee_CdG);
        LinearLayout groupe2 = (LinearLayout) findViewById(R.id.armee_SE);
        LinearLayout groupe3 = (LinearLayout) findViewById(R.id.armee_Alpha);
        LinearLayout groupe4 = (LinearLayout) findViewById(R.id.armee_Bravo);
        LinearLayout groupe5 = (LinearLayout) findViewById(R.id.armee_Charlie);

        // Create views to drop to
        LinearLayout zone1 = (LinearLayout) findViewById(R.id.zone1);
        LinearLayout zone2 = (LinearLayout) findViewById(R.id.zone2);
        LinearLayout zone3 = (LinearLayout) findViewById(R.id.zone3);
        LinearLayout zone4 = (LinearLayout) findViewById(R.id.zone4);
        LinearLayout zone5 = (LinearLayout) findViewById(R.id.zone5);

        // Set tags.
        groupe1.setTag(VIEW_TAG1);
        groupe2.setTag(VIEW_TAG2);
        groupe3.setTag(VIEW_TAG3);
        groupe4.setTag(VIEW_TAG4);
        groupe5.setTag(VIEW_TAG5);

        groupe1.setOnLongClickListener(v -> {
            ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
            ClipData dragData = new ClipData((CharSequence) v.getTag(), new String[] { ClipDescription.MIMETYPE_TEXT_PLAIN }, item);
            View.DragShadowBuilder myShadow = new DeploiementArmee.MyDragShadowBuilder(groupe1);
            v.startDragAndDrop(dragData, myShadow,null,0);
            return true;
        });
        groupe2.setOnLongClickListener(v -> {
            ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
            ClipData dragData = new ClipData((CharSequence) v.getTag(), new String[] { ClipDescription.MIMETYPE_TEXT_PLAIN }, item);
            View.DragShadowBuilder myShadow = new DeploiementArmee.MyDragShadowBuilder(groupe1);
            v.startDragAndDrop(dragData, myShadow,null,0);
            return true;
        });
        zone1.setOnDragListener((v, e) -> {
            switch(e.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    if (e.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                        v.setBackgroundColor(Color.BLUE);
                        v.invalidate();
                        return true;
                    }
                    return false;

                case DragEvent.ACTION_DRAG_ENTERED:
                    v.setBackgroundColor(Color.GREEN);
                    v.invalidate();
                    return true;

                case DragEvent.ACTION_DRAG_LOCATION:
                    return true;

                case DragEvent.ACTION_DRAG_EXITED:
                    v.setBackgroundColor(Color.BLUE);
                    v.invalidate();
                    return true;

                case DragEvent.ACTION_DROP:
                    ClipData.Item item = e.getClipData().getItemAt(0);
                    CharSequence dragData = item.getText();
                    Toast.makeText(this, "Vous avez déplacé un " + dragData, Toast.LENGTH_SHORT).show();
                    v.setBackgroundResource(R.drawable.border_reserve);
                    ImageView imageView = new ImageView(this);

                    //LinearLayout linearLayout = (LinearLayout) findViewById(R.id.zone1);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );
                    //layoutParams.addRule(RelativeLayout.BELOW, R.id.ButtonRecalculate);
                    //layoutParams. addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

                    if(dragData.equals(groupe1.getTag())) {
                        imageView.setImageResource(R.drawable.logo_chefdeguerre);
                    } else if (dragData.equals(groupe2.getTag())) {
                        imageView.setImageResource(R.drawable.logo_elite);
                    } else if (dragData.equals(groupe3.getTag())) {
                        imageView.setImageResource(R.drawable.logo_alpha);
                    } else if (dragData.equals(groupe4.getTag())) {
                        imageView.setImageResource(R.drawable.logo_bravo);
                    } else if (dragData.equals(groupe5.getTag())) {
                        imageView.setImageResource(R.drawable.logo_charlie);
                    }
                    ((LinearLayout)v).addView(imageView, layoutParams);
                    addSoldat((LinearLayout) v, dragData); //v : zone | dragData : CharSequence (différent d'un String) expliquant ce qu'est la donnée transférée
                    return true;

                case DragEvent.ACTION_DRAG_ENDED:
                    v.setBackgroundResource(R.drawable.border_reserve);
                    v.invalidate();
                    return true;

                default:
                    Log.e("DragDrop Example","Unknown action type received by View.OnDragListener.");
                    break;
            }
            return false;
        });
        zone2.setOnDragListener((v, e) -> {
            switch(e.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    if (e.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                        v.setBackgroundColor(Color.BLUE);
                        v.invalidate();
                        return true;
                    }
                    return false;

                case DragEvent.ACTION_DRAG_ENTERED:
                    v.setBackgroundColor(Color.GREEN);
                    v.invalidate();
                    return true;

                case DragEvent.ACTION_DRAG_LOCATION:
                    return true;

                case DragEvent.ACTION_DRAG_EXITED:
                    v.setBackgroundColor(Color.BLUE);
                    v.invalidate();
                    return true;

                case DragEvent.ACTION_DROP:
                    ClipData.Item item = e.getClipData().getItemAt(0);
                    CharSequence dragData = item.getText();
                    Toast.makeText(this, "Vous avez déplacé un " + dragData, Toast.LENGTH_SHORT).show();
                    v.setBackgroundResource(R.drawable.border_reserve);
                    ImageView imageView = new ImageView(this);

                    if(dragData.equals(groupe1.getTag())) {
                        imageView.setImageResource(R.drawable.logo_chefdeguerre);
                    } else if (dragData.equals(groupe2.getTag())) {
                        imageView.setImageResource(R.drawable.logo_elite);
                    } else if (dragData.equals(groupe3.getTag())) {
                        imageView.setImageResource(R.drawable.logo_alpha);
                    } else if (dragData.equals(groupe4.getTag())) {
                        imageView.setImageResource(R.drawable.logo_bravo);
                    } else if (dragData.equals(groupe5.getTag())) {
                        imageView.setImageResource(R.drawable.logo_charlie);
                    }
                    ((LinearLayout)v).addView(imageView);
                    addSoldat((LinearLayout) v, dragData);
                    return true;

                case DragEvent.ACTION_DRAG_ENDED:
                    v.setBackgroundResource(R.drawable.border_reserve);
                    v.invalidate();
                    return true;

                default:
                    Log.e("DragDrop Example","Unknown action type received by View.OnDragListener.");
                    break;
            }
            return false;
        });
    }
    private void addSoldat(LinearLayout linearLayout, CharSequence tag) {

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

    @Override
    public void onClick(View v) {
        if (v == next) {
            pageSuivante();
        }
        else {
            throw new IllegalStateException("Unknown clicked view : " + v);
        }
    }
    public void pageSuivante() {
        // Création d’une activité associée à l’exécution de MaGestionListe.class
        Intent intent = new Intent(DeploiementArmee.this, Reserve.class);
        // Exécution de l’activité : ouverture de la fenêtre
        startActivity(intent);
    }
}