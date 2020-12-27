package dz.uc2.sci.echomall;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

import edu.cmu.pocketsphinx.Assets;
import edu.cmu.pocketsphinx.Hypothesis;
import edu.cmu.pocketsphinx.LogMath;
import edu.cmu.pocketsphinx.RecognitionListener;
import edu.cmu.pocketsphinx.SpeechRecognizer;
import edu.cmu.pocketsphinx.SpeechRecognizerSetup;

public class ProductActivity extends AppCompatActivity implements RecognitionListener {

    /* Named searches allow to quickly reconfigure the decoder */

    private static final String EMO_SEARCH = "+AFER";


    /* Keyword we are looking for to activate menu */


    /* Used to handle permission request */
    private static final int PERMISSIONS_REQUEST_RECORD_AUDIO = 1;

    private SpeechRecognizer recognizer;
    private HashMap<String, Integer> captions;
    Intent intent ;
    String Title ;
    String Categorie;
    String Description;
    int image;
    double Prix ;
    float evaluation ;

        private TextView tvtitle,tvdescription, tvmarque, prix;
        private ImageView img;
        ToggleButton  btn_favorite;
        Button btn_add;
         String[] keywordwatch = {"watch","electronique","time"};
        private List<Produit> mData ;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_product);




            // Recieve data
            intent = getIntent();
            Title = intent.getExtras().getString("Title");
            Categorie = intent.getExtras().getString("Marque");
            Description = intent.getExtras().getString("Description");
            image = intent.getExtras().getInt("Thumbnail") ;
            Prix = intent.getExtras().getDouble("Prix");
            evaluation = intent.getExtras().getFloat("Evaluation");





            tvtitle = (TextView) findViewById(R.id.txttitle);
            tvdescription = (TextView) findViewById(R.id.txtDesc);
            tvmarque = (TextView) findViewById(R.id.txtmarque);
            img = (ImageView) findViewById(R.id.bookthumbnail);
            prix = (TextView) findViewById(R.id.prix);
            btn_favorite = findViewById(R.id.button_favorite);
            btn_add = findViewById(R.id.addpanier);



            // Setting values
            tvtitle.setText(Title);
            tvdescription.setText(Description);
            tvmarque.setText(Categorie);
            img.setImageResource(image);
            prix.setText("$ "+ Prix);


            btn_add.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                   Intent ii = new Intent(ProductActivity.this, PanierActivity.class);
                    Panier.ajouterproduit(new Produit(Title,Categorie,Description,image,keywordwatch,Categorie,5,Prix,evaluation));



                   startActivity(ii);
                }
            });


          //  ratingbar=(RatingBar)findViewById(R.id.ratingBar);





            // Check if user has given permission to record audio
            int permissionCheck = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO);
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, PERMISSIONS_REQUEST_RECORD_AUDIO);
                return;
            }
            // Recognizer initialization is a time-consuming and it involves IO,
            // so we execute it in async task
            new SetupTask(this).execute();

        }




        private static class SetupTask extends AsyncTask<Void, Void, Exception> {
            WeakReference<ProductActivity> activityReference;
            SetupTask(ProductActivity activity) {
                this.activityReference = new WeakReference<>(activity);
            }
            @Override
            protected Exception doInBackground(Void... params) {
                try {
                    Assets assets = new Assets(activityReference.get());
                    File assetDir = assets.syncAssets();
                    activityReference.get().setupRecognizer(assetDir);
                } catch (IOException e) {
                    return e;
                }
                return null;
            }
            @Override
            protected void onPostExecute(Exception result) {
                if (result != null) {
                    //((TextView) activityReference.get().findViewById(R.id.caption_text))
                    //      .setText("Failed to init recognizer " + result);
                } else {
                    activityReference.get().switchSearch(EMO_SEARCH);
                }
            }
        }

        @Override
        public void onRequestPermissionsResult(int requestCode,
                                               @NonNull String[] permissions, @NonNull  int[] grantResults) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);

            if (requestCode == PERMISSIONS_REQUEST_RECORD_AUDIO) {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Recognizer initialization is a time-consuming and it involves IO,
                    // so we execute it in async task
                    new SetupTask(this).execute();
                } else {
                    finish();
                }
            }
        }

        @Override
        public void onDestroy() {
            super.onDestroy();

            if (recognizer != null) {
                recognizer.cancel();
                recognizer.shutdown();
            }
        }

        /**
         * In partial result we get quick updates about current hypothesis. In
         * keyword spotting mode we can react here, in other modes we need to wait
         * for final result in onResult.
         */
        @Override
        public void onPartialResult(Hypothesis hypothesis) {

        }

        /**
         * This callback is called when we stop the recognizer.
         */
        @Override
        public void onResult(Hypothesis hypothesis) {
            //((TextView) findViewById(R.id.result_text)).setText("");
            LogMath ll = new LogMath();

            if (hypothesis != null) {
                double score = ll.exp(hypothesis.getBestScore()) ;
                double proba = ll.exp(hypothesis.getProb());
                String text = hypothesis.getHypstr();
                double ff = 3.00;
                //  int best = hypothesis.getBestScore();
                //eebest = (best * (-1))/100;


                // proba = (((proba+score)/2)*10);
                proba = ((proba+score)/2) * 10;
                char azf ='-';
                char azl ='-';
                if(text.length()==0){
                    Toast.makeText(this, "Le système ne peut pas capturer la voix en raison du bruit existant", Toast.LENGTH_SHORT).show();

                }else {
                    azl = text.charAt(text.length() - 1);
                    azf = text.charAt(0);
                }

                //
                // makeText(getApplicationContext(), text+" : "+best+" : "+proba, Toast.LENGTH_SHORT).show();

                if (proba >= ff) {
                    if (azl == '+' || azf == '+') {


                        btn_favorite.setChecked(true);


                    }
                    else {
                        btn_favorite.setChecked(false);
                    }
                }
           }



        }
        @Override
        public void onBeginningOfSpeech() {
        }

        /**
         * We stop recognizer here to get a final result
         */
        @Override
        public void onEndOfSpeech() {
            switchSearch(EMO_SEARCH);
        }

        private void switchSearch(String searchName) {
            recognizer.stop();

            // If we are not spotting, start listening with timeout (10000 ms or 10 seconds).
            recognizer.startListening(searchName);

            //else
           // recognizer.startListening(searchName, 10000);

            //String caption = getResources().getString(captions.get(searchName));
            //((TextView) findViewById(R.id.caption_text)).setText(caption);
        }

        private void setupRecognizer(File assetsDir) throws IOException {
            // The recognizer can be configured to perform multiple searches
            // of different kind and switch between them

            recognizer = SpeechRecognizerSetup.defaultSetup()
                    .setAcousticModel(new File(assetsDir, "en-us-ptm"))
                    .setDictionary(new File(assetsDir, "emotion.dict"))

                    .setRawLogDir(assetsDir) // To disable logging of raw audio comment out this call (takes a lot of space on the device)

                    .getRecognizer();
            recognizer.addListener(this);

        /* In your application you might not need to add all those searches.
          They are added here for demonstration. You can leave just one.
         */

            // Create keyword-activation search.
            //recognizer.addKeyphraseSearch(KWS_SEARCH, KEYPHRASE);


            // Create language model search
            File languageModel = new File(assetsDir, "emotion.lm.dmp");
            recognizer.addNgramSearch(EMO_SEARCH, languageModel);

        }

        @Override
        public void onError(Exception error) {
            // ((TextView) findViewById(R.id.caption_text)).setText(error.getMessage());
        }

        @Override
        public void onTimeout() {
            switchSearch(EMO_SEARCH);
        }
    }
