package vladus177.ru.geotest_10;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;


public class MainActivity extends Activity {
    FragmentFlags fragF;
    FragmentCapitals fragC;
    FragmentButtons fragButtons;
    FragmentTransaction fTrans;
    FrameLayout container;
    FrameLayout container2;
    FrameLayout containerButtons;
    FragmentManager myFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragF=new FragmentFlags();
        fragC=new FragmentCapitals();
        fragButtons=new FragmentButtons();
        container = (FrameLayout) findViewById(R.id.container);
        container2 = (FrameLayout) findViewById(R.id.container2);
        containerButtons = (FrameLayout) findViewById(R.id.containerButtons);
        myFragmentManager = getFragmentManager();
        addFragmentButtons();
        //addFragmentFlags();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void addFragmentFlags()
    {
        fTrans=myFragmentManager.beginTransaction();
        Configuration config = getResources().getConfiguration();
        if (config.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            fragF = new FragmentFlags();
            fTrans.replace(R.id.container, fragF);
            fTrans.commit();
        }
        else if(config.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            fragF = new FragmentFlags();
            fTrans.replace(R.id.container2,new FragmentFlags());
            fTrans.commit();
        }
    }
    public void addFragmentCapitals()
    {
        fTrans=myFragmentManager.beginTransaction();
        Configuration config = getResources().getConfiguration();
        if (config.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            fragC = new FragmentCapitals();
            fTrans.replace(R.id.container, fragC);
            fTrans.commit();
        }
        else if(config.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            fragC = new FragmentCapitals();
            fTrans.replace(R.id.container, new FragmentCapitals());
            fTrans.commit();
        }

    }
    public void addFragmentButtons()
    {
        fTrans=myFragmentManager.beginTransaction();
        fragButtons = new FragmentButtons();
        fTrans.replace(R.id.containerButtons,fragButtons);
        fTrans.commit();
    }

}
